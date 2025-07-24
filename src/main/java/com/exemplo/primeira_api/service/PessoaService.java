package com.exemplo.primeira_api.service;

import com.exemplo.primeira_api.model.PessoaModel;

import java.util.ArrayList;
import java.util.List;

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
        return "Not Found";
    }

    public PessoaModel getPessoaById(int id){
        for(PessoaModel pessoa : pessoas){
            if(pessoa.getId() == id){
                return pessoa;
            }
        }
        return(new PessoaModel(-1, "Not Found", -1));
    }

    public String insertPessoa(PessoaModel pessoa){
        pessoa.setId(pessoas.get(pessoas.size()-1).getId() + 1);
        pessoas.add(pessoa);
        return "Pessoa Adicionada com Sucesso!";
    }

    public String deletePessoaById(int id){
        for(PessoaModel pessoa : pessoas){
            if(pessoa.getId() == id){
                pessoas.remove(pessoa);
                return "Pessoa Removida com Sucesso!";
            }
        }
        return "Pessoa Não Encontrada";
    }

    public String modifyPessoaById(int id, PessoaModel novaPessoa){
        for(PessoaModel pessoa : pessoas){
            if(pessoa.getId() == id){
                int pessoaIndex = pessoas.indexOf(pessoa);
                novaPessoa.setId(id);
                pessoas.set(pessoaIndex, novaPessoa);
                return "Pessoa Modificada com Sucesso!";
            }
        }
        return "Pessoa Não Encontrada";
    }
}
