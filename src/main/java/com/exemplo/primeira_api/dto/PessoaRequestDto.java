package com.exemplo.primeira_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PessoaRequestDto {

    @NotBlank(message = "O campo nome não pode ser vazio")
    private String nome;

    @NotNull(message = "O campo idade não pode ser vazio") @Positive(message = "O campo idade deve conter um número positivo")
    private Integer idade;

    public PessoaRequestDto(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
