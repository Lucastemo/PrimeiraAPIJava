package com.exemplo.primeira_api.service;

import com.exemplo.primeira_api.model.PessoaModel;

import com.exemplo.primeira_api.dto.PessoaRequestDto;

import com.exemplo.primeira_api.exception.PessoaNaoEncontradaException;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {

    List<PessoaModel> pessoas = new ArrayList<>();

    public PessoaService(){

        // Inserts para teste
        PessoaModel pessoa1 = new PessoaModel(0, "Lucas", 20);
        PessoaModel pessoa2 = new PessoaModel(1, "José", 32);
        PessoaModel pessoa3 = new PessoaModel(2, "Rosa", 44);

        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);
    }

    public String getNomeById(int id){
        for(PessoaModel pessoa : pessoas){
            if(pessoa.getId() == id){
                return pessoa.getNome();
            }
        }
        throw new PessoaNaoEncontradaException("Falha ao tentar buscar nome de pessoa por ID", id);
    }

    public PessoaModel getPessoaById(int id){
        for(PessoaModel pessoa : pessoas){
            if(pessoa.getId() == id){
                return pessoa;
            }
        }
        throw new PessoaNaoEncontradaException("Falha ao tentar buscar pessoa por ID", id);
    }

    public String insertPessoa(PessoaRequestDto pessoa){
        int novoId = pessoas.get(pessoas.size()-1).getId() + 1; // Faz o novo id com base no último registro da lista
        PessoaModel novaPessoa = new PessoaModel(novoId, pessoa.getNome(), pessoa.getIdade());
        pessoas.add(novaPessoa);
        return "Pessoa Adicionada com Sucesso!";
    }

    public void deletePessoaById(int id){
        for(PessoaModel pessoa : pessoas){
            if(pessoa.getId() == id){
                pessoas.remove(pessoa);
            }
        }
    }

    public String modifyPessoaById(int id, PessoaRequestDto novaPessoaRequest){
        for(PessoaModel pessoa : pessoas){
            if(pessoa.getId() == id){
                int pessoaIndex = pessoas.indexOf(pessoa);
                PessoaModel novaPessoa = new PessoaModel(id, novaPessoaRequest.getNome(), novaPessoaRequest.getIdade());
                pessoas.set(pessoaIndex, novaPessoa);
                return "Pessoa Modificada com Sucesso!";
            }
        }
        throw new PessoaNaoEncontradaException("Falha ao tentar modificar pessoa por ID", id);
    }
}
