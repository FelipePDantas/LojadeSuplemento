package com.loja.api.controller;


import com.loja.api.model.Fornecedor;
import com.loja.api.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    FornecedorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Fornecedor> criar(@RequestBody Fornecedor fornecedor) {

        Fornecedor fornecedorCriado = service.criar(fornecedor);

        return ResponseEntity.status(201).body(fornecedorCriado);
    }

    @GetMapping("/listar-todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Fornecedor> listarTodos() {

        return service.listaTodos();
    }

    @GetMapping("/{id}")
    public Optional<Fornecedor> ProcurarPorId(@PathVariable Long id) {

        return service.procurarPeloID(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        service.delete(id);
    }

}
