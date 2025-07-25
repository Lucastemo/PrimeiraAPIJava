package com.exemplo.primeira_api.exception;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.exemplo.primeira_api.dto.ErroRespostaDto;
import com.exemplo.primeira_api.dto.MultiplosErrosRespostaDto;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PessoaNaoEncontradaException.class)
    public ResponseEntity<ErroRespostaDto> handlePessoaNaoEncontrada(PessoaNaoEncontradaException exception){
        return ResponseEntity.status(404).body(new ErroRespostaDto(exception.getMessage() + ": Pessoa não encontrada com o ID " + exception.getIdBuscado()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErroRespostaDto> handleConstraintViolationException(ConstraintViolationException exception){
        return ResponseEntity.badRequest().body(new ErroRespostaDto(exception.getConstraintViolations().iterator().next().getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MultiplosErrosRespostaDto> handleMethodArgumentNotValid(MethodArgumentNotValidException exception){
        String[] erros = exception.getAllErrors()
                .stream()
                .map(erro -> erro.getDefaultMessage())
                .toArray(String[]::new);
        return ResponseEntity.badRequest().body(new MultiplosErrosRespostaDto(erros));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErroRespostaDto> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException exception){
        return ResponseEntity.badRequest().body(new ErroRespostaDto("Falha ao tentar converter valor '" + exception.getValue() + "' em '" + exception.getRequiredType().getCanonicalName() + "' para o campo '" + exception.getParameter().getParameterName() + "' - " + exception.getMessage()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroRespostaDto> handleHttpMessageNotReadable(HttpMessageNotReadableException exception){
        return ResponseEntity.badRequest().body(new ErroRespostaDto("Falha ao tentar ler dados do body da requisição: " + exception.getMessage().split(":")[0]));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErroRespostaDto> handleHttpRequestmethodNotSupported(HttpRequestMethodNotSupportedException exception){
        return ResponseEntity.status(501).body(new ErroRespostaDto("Método HTTP não suportado: " + exception.getMessage()));
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErroRespostaDto> handleNoResourceFoundException(NoResourceFoundException exception){
        return ResponseEntity.status(501).body(new ErroRespostaDto("Rota não implementada: " + exception.getResourcePath() + " - " + exception.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroRespostaDto> handleGenericException(Exception exception){
        return ResponseEntity.status(500).body(new ErroRespostaDto("Erro interno no servidor: " + exception.getMessage()));
    }

}
