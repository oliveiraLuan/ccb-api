package com.luandeoliveira.ccb_api.controllers.exceptions;

import com.luandeoliveira.ccb_api.services.exceptions.HymnException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(HymnException.class)
    public ResponseEntity<StandardError> hymnException(HttpServletRequest request, HymnException exception){
        StandardError standardError = new StandardError(Instant.now(), request.getRequestURI(),  "Recurso não encontrado", exception.getMessage(), HttpStatus.NOT_FOUND.toString());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }
}