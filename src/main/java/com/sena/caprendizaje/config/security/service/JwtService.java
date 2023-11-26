package com.sena.caprendizaje.config.security.service;

import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.sena.caprendizaje.config.security.constant.SecurityConstants;
import com.sena.caprendizaje.config.security.model.RefreshRequest;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Usuario;
import com.sena.caprendizaje.empleabilidad.persistence.repository.adapter.jpa.UsuariosRepository;
import com.sena.caprendizaje.shared.exception.IllegalRefreshTokenException;
import com.sena.caprendizaje.shared.exception.InvalidTokenException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtService {

  private final RefreshKeyService refreshKeyService;
  private final String SECRET_KEY = SecurityConstants.JWT_KEY;
  private final UsuariosRepository usuariosRepository;

  public String extractUsername(String token) throws Exception {
    return extractClaim(token, Claims::getSubject);
  }

  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) throws Exception {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  public String generateToken(UserDetails userDetails) {
    return generateToken(new HashMap<>(), userDetails);
  }

  public String generateToken(
      Map<String, Object> extraClaims,
      UserDetails userDetails) {
    Map<String, Object> rolesClaim = new HashMap<>();
    rolesClaim.put("role", userDetails.getAuthorities().stream().findFirst().get().getAuthority());
    Long id = usuariosRepository.findFirstByUsuario(userDetails.getUsername()).get().getId();
    rolesClaim.put("id", id);
    rolesClaim.put("xf", refreshKeyService.generateRefreshKey(id.toString(), userDetails.getUsername()));
    return Jwts
        .builder()
        .setClaims(extraClaims)
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10))
        .signWith(getSignInKey(), SignatureAlgorithm.HS256)
        .addClaims(rolesClaim)
        .compact();
  }

  public boolean isTokenValid(String token, UserDetails userDetails) throws Exception {
    final String username = extractUsername(token);
    return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
  }

  public boolean isTokenValid(String token) throws Exception {
    List<GrantedAuthority> authorities = new ArrayList<>();
    if (token == null || !token.startsWith("Bearer ")) {
      throw new InvalidTokenException("Token is not valid");
    }
    String jwt = token.substring(7);
    String username = extractUsername(jwt);
    Usuario usuario = usuariosRepository.findFirstByUsuario(username)
        .orElseThrow(() -> new InvalidTokenException("User does not exist"));
    authorities.add(new SimpleGrantedAuthority(usuario.getPerfil().getCodigo()));
    UserDetails userDetails = new User(usuario.getUsuario(), usuario.getContraseña(), authorities);
    if (!isTokenValid(jwt, userDetails)) {
      throw new InvalidTokenException("Token is not valid");
    }
    return true;
  }

  private boolean isTokenExpired(String token) throws Exception {
    return extractExpiration(token).before(new Date());
  }

  private Date extractExpiration(String token) throws Exception {
    return extractClaim(token, Claims::getExpiration);
  }

  private Claims extractAllClaims(String token) throws Exception {
    return Jwts
        .parserBuilder()
        .setSigningKey(getSignInKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
  }

  private Key getSignInKey() {
    byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(keyBytes);
  }

  protected String refreshToken(RefreshRequest refresh) {
    return refreshToken(refresh.getKey(), refresh.getExp(), refresh.getSub());
  }

  private String refreshToken(String key, String expiredToken, Long subject) {
    Usuario usuario = usuariosRepository.findById(subject)
    .orElseThrow(() -> new IllegalRefreshTokenException("User does not exist"));
    if (subject != usuario.getId()) {
      throw new IllegalRefreshTokenException("Subject is not valid");
    }
    String username = usuario.getUsuario();
    if (!refreshKeyService.validatedSecretKey(username, subject.toString(), key)) {
      throw new IllegalRefreshTokenException("Invalid secret key match");
    }
    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(usuario.getPerfil().getCodigo()));
    UserDetails userDetails = new User(usuario.getUsuario(), usuario.getContraseña(), authorities);
    String token = generateToken(userDetails);
    return token;
  }

}
