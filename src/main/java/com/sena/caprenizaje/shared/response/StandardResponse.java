package com.sena.caprenizaje.shared.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StandardResponse {

    private LocalDateTime localDateTime;
	private Object data;
	private String status;
	private String message;
    
}