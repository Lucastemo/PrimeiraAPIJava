package com.exemplo.primeira_api.dto;

public class MultiplosErrosRespostaDto {
    private String[] errors;

    public MultiplosErrosRespostaDto(String[] errors) {
        this.errors = errors;
    }

    public String[] getErrors() {
        return errors;
    }
}
