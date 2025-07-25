package com.exemplo.primeira_api.controller;

import com.exemplo.primeira_api.model.PessoaModel;
import com.exemplo.primeira_api.service.PessoaService;

import com.exemplo.primeira_api.dto.MensagemRespostaDto;
import com.exemplo.primeira_api.dto.PessoaRequestDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Validated
@RestController
public class TesteController {

    PessoaService pessoaService = new PessoaService();

    @GetMapping("/teste")
    public ResponseEntity<?> digaOla(){
        return ResponseEntity.ok(new MensagemRespostaDto("Olá, mundo!"));
    }

    @GetMapping("/pessoas/nome/{id}")
    public ResponseEntity<?> getNomeOfPessoaById(@PathVariable @Min(value = 0, message = "O id informado não pode ser negativo") Integer id){
        return ResponseEntity.ok(new MensagemRespostaDto(pessoaService.getNomeById(id)));
    }

    @GetMapping("/pessoas/{id}")
    public ResponseEntity<?> GetPessoaById(@PathVariable @Min(value = 0, message = "O id informado não pode ser negativo") int id){
        return ResponseEntity.ok(pessoaService.getPessoaById(id));
    }

    @PostMapping("/pessoas")
    public ResponseEntity<?> NewPessoa(@Valid @RequestBody PessoaRequestDto pessoa){
        return ResponseEntity.status(201).body(new MensagemRespostaDto(pessoaService.insertPessoa(pessoa)));
    }

    @DeleteMapping("/pessoas/{id}")
    public ResponseEntity<Void> DeletePessoa(@PathVariable @Min(value = 0, message = "O id informado não pode ser negativo") Integer id){
        pessoaService.deletePessoaById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/pessoas/{id}")
    public ResponseEntity<?> ModifyPessoaById(@PathVariable @Min(value = 0, message = "O id informado não pode ser negativo") Integer id, @Valid @RequestBody PessoaRequestDto pessoa){
        return ResponseEntity.ok(new MensagemRespostaDto(pessoaService.modifyPessoaById(id, pessoa)));
    }

}
