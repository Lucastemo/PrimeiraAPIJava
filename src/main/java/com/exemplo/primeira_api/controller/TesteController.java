package com.exemplo.primeira_api.controller;

import com.exemplo.primeira_api.model.PessoaModel;
import com.exemplo.primeira_api.service.PessoaService;

import com.exemplo.primeira_api.dto.MensagemRespostaDto;
import com.exemplo.primeira_api.dto.PessoaRequestDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class TesteController {

    PessoaService pessoaService = new PessoaService();

    @GetMapping("/teste")
    public ResponseEntity<?> digaOla(){
        return ResponseEntity.ok(new MensagemRespostaDto("Olá, mundo!"));
    }

    @GetMapping("/pessoas/nome/{id}")
    public ResponseEntity<?> getNomeOfPessoaById(@PathVariable Integer id){
        return ResponseEntity.ok(new MensagemRespostaDto(pessoaService.getNomeById(id)));
    }

    @GetMapping("/pessoas/{id}")
    public ResponseEntity<?> GetPessoaById(@PathVariable int id){
        return ResponseEntity.ok(pessoaService.getPessoaById(id));
    }

    @PostMapping("/pessoas")
    public ResponseEntity<?> NewPessoa(@RequestBody PessoaRequestDto pessoa){
        return ResponseEntity.status(201).body(new MensagemRespostaDto(pessoaService.insertPessoa(pessoa)));
    }

    @DeleteMapping("/pessoas/{id}")
    public ResponseEntity<Void> DeletePessoa(@PathVariable Integer id){
        pessoaService.deletePessoaById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/pessoas/{id}")
    public ResponseEntity<?> ModifyPessoaById(@PathVariable Integer id, @RequestBody PessoaRequestDto pessoa){
        return ResponseEntity.ok(new MensagemRespostaDto(pessoaService.modifyPessoaById(id, pessoa)));
    }

}
