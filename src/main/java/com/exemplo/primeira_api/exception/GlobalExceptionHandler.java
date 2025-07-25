package com.exemplo.primeira_api.exception;

import com.exemplo.primeira_api.dto.ErroRespostaDto;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PessoaNaoEncontradaException.class)
    public ResponseEntity<ErroRespostaDto> handlePessoaNaoEncontrada(PessoaNaoEncontradaException exception){
        return ResponseEntity.status(404).body(new ErroRespostaDto(exception.getMessage() + " | Pessoa não encontrada com o ID " + exception.getIdBuscado()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroRespostaDto> handleGenericException(Exception exception){
        return ResponseEntity.status(500).body(new ErroRespostaDto("Erro interno no servidor: " + exception.getMessage()));
    }

}
