package com.exemplo.primeira_api.dto;

public class ErroRespostaDto {
    private String error;

    public ErroRespostaDto(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
