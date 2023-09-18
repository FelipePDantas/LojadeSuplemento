package com.loja.api.service;

import com.loja.api.model.Fornecedor;
import com.loja.api.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    FornecedorRepository repository;


    public Fornecedor criar(Fornecedor fornecedor) {

        return repository.save(fornecedor);
    }

    public List<Fornecedor> listaTodos() {

        return repository.findAll();
    }

    public Optional<Fornecedor> procurarPeloID(Long id) {

        return repository.findById(id);
    }

    public void delete(Long id) {

        repository.deleteById(id);
    }


}
