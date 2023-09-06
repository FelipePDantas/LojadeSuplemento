package com.loja.api.service;

import com.loja.api.model.Cliente;
import com.loja.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public Cliente criar (Cliente cliente) {

        return repository.save(cliente);
    }
    public List<Cliente> listaTodos(){

        return repository.findAll();
    }
    public Optional<Cliente> procurarPeloID(Long id){

        return repository.findById(id);
    }
    public void delete(Long id){

        repository.deleteById(id);
    }

}
