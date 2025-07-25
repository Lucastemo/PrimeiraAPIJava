package com.exemplo.primeira_api.dto;

public class ErroRespostaDto {
    String error;

    public ErroRespostaDto(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
