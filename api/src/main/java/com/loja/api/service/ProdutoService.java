package com.loja.api.service;

import com.loja.api.model.Produto;
import com.loja.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service

public class ProdutoService {
    @Autowired
    ProdutoRepository repository;


    public Produto criar(Produto produto) {

        return repository.save(produto);
    }

    public List<Produto> listaTodos() {

        return repository.findAll();
    }

    public Optional<Produto> procurarPeloID(Long id) {

        return repository.findById(id);
    }

    public void deletarPorID(Long id) {

        repository.deleteById(id);
    }


}
