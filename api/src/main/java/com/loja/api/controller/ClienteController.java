package com.loja.api.controller;

import com.loja.api.model.Cliente;
import com.loja.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService service;

@PostMapping
@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente){

        Cliente clienteCriado = service.criar(cliente);

        return ResponseEntity.status(201).body(clienteCriado);
    }

@GetMapping("/listar-todos")
@ResponseStatus(HttpStatus.OK)
    public List<Cliente> listarTodos(){

    return service.listaTodos();
    }
@GetMapping("/{id}")
    public Optional<Cliente> procurarPorId(@PathVariable Long id){

    return service.procurarPeloID(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){

    service.delete(id);
    }

}
