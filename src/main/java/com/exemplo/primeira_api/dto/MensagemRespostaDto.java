package com.exemplo.primeira_api.dto;

public class MensagemRespostaDto {
    private String mensagem;

    public MensagemRespostaDto(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
