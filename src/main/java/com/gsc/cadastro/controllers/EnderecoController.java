package com.gsc.cadastro.controllers;

import com.gsc.cadastro.DTO.EnderecoDTO;
import com.gsc.cadastro.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/endereco")
public class EnderecoController {
    EnderecoService service = new EnderecoService();

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> listAll(){
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> getPetsById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<EnderecoDTO> create(@RequestBody @Valid EnderecoDTO dto) throws ParseException {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping()
    public ResponseEntity<EnderecoDTO> update(@RequestBody @Valid EnderecoDTO dto){
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok("Deletado");
    }
}
