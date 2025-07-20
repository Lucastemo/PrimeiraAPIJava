package com.exemplo.primeira_api;

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
    public String digaOla(){
        return "Olá, mundo!";
    }

    @GetMapping("/pessoas/nome/{id}")
    public String getNomeOfPessoaById(@PathVariable Integer id){
        String nomeObtido = pessoaService.getNomeById(id);
        return nomeObtido;
    }

    @GetMapping("/pessoas/{id}")
    public PessoaModel GetPessoaById(@PathVariable int id){
        PessoaModel pessoaEncontrada = pessoaService.getPessoaById(id);
        return pessoaEncontrada;
    }

    @PostMapping("/pessoas")
    public String NewPessoa(@RequestBody PessoaModel pessoa){
        String resultado = pessoaService.insertPessoa(pessoa);
        return resultado;
    }

    @DeleteMapping("/pessoas/{id}")
    public String DeletePessoa(@PathVariable Integer id){
        String resultado = pessoaService.deletePessoaById(id);
        return resultado;
    }

    @PutMapping("/pessoas/{id}")
    public String ModifyPessoaById(@PathVariable Integer id, @RequestBody PessoaModel pessoa){
        String resultado = pessoaService.modifyPessoaById(id, pessoa);
        return resultado;
    }

}
