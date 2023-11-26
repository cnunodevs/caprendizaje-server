package com.sena.caprendizaje.empleabilidad.service.adapter;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.persistence.entity.Empresa;
import com.sena.caprendizaje.empleabilidad.persistence.repository.adapter.jpa.EmpresasJpaRepository;
import com.sena.caprendizaje.empleabilidad.service.port.EmpresasServiceProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpresasServiceAdapter implements EmpresasServiceProvider {

    private final EmpresasJpaRepository repository;


    @Override
    public List<Empresa> handleFindAll() {
        return repository.findAll();
    }

    @Override
    public Empresa handleUpdate(Empresa pojo) {
        return repository.save(pojo);
    }

    @Override
    public void handleDelete(Empresa pojo) {
        repository.delete(pojo);
    }

    @Override
    public Boolean handleDeleteById(Long id) {
        if(handleAlreadyExistById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Page<Empresa> handleFindAllPaginateByExample(Example<Empresa> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public List<Empresa> handleFindAllByExample(Example<Empresa> example) {
        return repository.findAll(example);
    }

    @Override
    public Page<Empresa> handleFindAllPaginate(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Boolean handleAlreadyExist(Empresa pojo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleAlreadyExist'");
    }

    @Override
    public Boolean handleAlreadyExistById(Long id) {
        return repository.findById(id).isPresent();
    }

    @Override
    public Empresa handleCreateNewRegister(Empresa pojo) {
        return repository.save(pojo);
    }

    @Override
    public List<Empresa> handleCreateNewListOfRegisters(List<Empresa> list) {
        return repository.saveAll(list);
    }

    @Override
    public void handleChangeState(Integer id, boolean state) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleChangeState'");
    }
    
}
