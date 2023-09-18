package com.loja.api.controller;

import com.loja.api.model.Produto;
import com.loja.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Produto> criar(@RequestBody Produto produto) {

        Produto produtoCriado = service.criar(produto);

        return ResponseEntity.status(201).body(produtoCriado);
    }

    @GetMapping("/listar-todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> listarTodos() {

        return service.listaTodos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> listarPorID(@PathVariable Long id) {

        return service.procurarPeloID(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {

        service.deletarPorID(id);
    }
}
