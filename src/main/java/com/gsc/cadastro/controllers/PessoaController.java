package com.gsc.cadastro.controllers;

import com.gsc.cadastro.DTO.PessoaDTO;
import com.gsc.cadastro.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PessoaController {

    @Autowired
    PessoaService service;

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> listAll(){
       return ResponseEntity.ok(service.listAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> getPetsById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> create(@RequestBody @Valid PessoaDTO dto) throws ParseException{
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping()
    public ResponseEntity<PessoaDTO> update(@RequestBody @Valid PessoaDTO dto){
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }
}
