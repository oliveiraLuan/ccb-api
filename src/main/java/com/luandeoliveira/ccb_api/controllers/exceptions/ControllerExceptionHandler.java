package com.luandeoliveira.ccb_api.controllers.exceptions;

import com.luandeoliveira.ccb_api.services.exceptions.HymnException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.io.FileNotFoundException;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(HymnException.class)
    public ResponseEntity<StandardError> hymnException(HttpServletRequest request, HymnException exception){
        StandardError standardError = new StandardError(Instant.now(), request.getRequestURI(),  "Recurso não encontrado", exception.getMessage(), HttpStatus.NOT_FOUND.toString());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<StandardError> mismatchException(HttpServletRequest request, MethodArgumentTypeMismatchException exception){
        StandardError standardError = new StandardError(Instant.now(), request.getRequestURI(),  "Argumento inválido", exception.getMessage(), HttpStatus.BAD_REQUEST.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }
    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<StandardError> fileNotFoundException(HttpServletRequest request, FileNotFoundException exception){
        StandardError standardError = new StandardError(Instant.now(), request.getRequestURI(),  "Arquivo não encontrado", exception.getMessage(), HttpStatus.NOT_FOUND.toString());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }
}