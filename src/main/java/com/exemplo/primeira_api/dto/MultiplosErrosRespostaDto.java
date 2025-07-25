package com.exemplo.primeira_api.dto;

public class MultiplosErrosRespostaDto {
    String[] errors;

    public MultiplosErrosRespostaDto(String[] errors) {
        this.errors = errors;
    }

    public String[] getErrors() {
        return errors;
    }
}
