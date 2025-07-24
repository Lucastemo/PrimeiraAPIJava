package com.exemplo.primeira_api.controller;

import com.exemplo.primeira_api.model.PessoaModel;
import com.exemplo.primeira_api.service.PessoaService;

import com.exemplo.primeira_api.dto.MensagemRespostaDto;
import com.exemplo.primeira_api.dto.PessoaRequestDto;

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
    public MensagemRespostaDto digaOla(){
        return new MensagemRespostaDto("Olá, mundo!");
    }

    @GetMapping("/pessoas/nome/{id}")
    public MensagemRespostaDto getNomeOfPessoaById(@PathVariable Integer id){
        return new MensagemRespostaDto(pessoaService.getNomeById(id));
    }

    @GetMapping("/pessoas/{id}")
    public PessoaModel GetPessoaById(@PathVariable int id){
        PessoaModel pessoaEncontrada = pessoaService.getPessoaById(id);
        return pessoaEncontrada;
    }

    @PostMapping("/pessoas")
    public MensagemRespostaDto NewPessoa(@RequestBody PessoaRequestDto pessoa){
        return new MensagemRespostaDto(pessoaService.insertPessoa(pessoa));
    }

    @DeleteMapping("/pessoas/{id}")
    public MensagemRespostaDto DeletePessoa(@PathVariable Integer id){
        return new MensagemRespostaDto(pessoaService.deletePessoaById(id));
    }

    @PutMapping("/pessoas/{id}")
    public MensagemRespostaDto ModifyPessoaById(@PathVariable Integer id, @RequestBody PessoaRequestDto pessoa){
        return new MensagemRespostaDto(pessoaService.modifyPessoaById(id, pessoa));
    }

}
