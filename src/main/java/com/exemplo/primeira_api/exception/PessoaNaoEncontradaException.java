package com.exemplo.primeira_api.exception;

public class PessoaNaoEncontradaException extends RuntimeException{

    Integer idBuscado;

    public PessoaNaoEncontradaException(String message, Integer idBuscado) {
        super(message);
        this.idBuscado = idBuscado;
    }

    public Integer getIdBuscado() {
        return idBuscado;
    }
}
