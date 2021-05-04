package com.uv.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExcepcionGlobal extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RecursoNoEncontrado.class)
    public ResponseEntity<?> recursoNoEncontrado (RecursoNoEncontrado ex, WebRequest request) {

        DetalleError detalle = new DetalleError(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(detalle, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> errorGlobal (RecursoNoEncontrado ex, WebRequest request) {

        DetalleError detalle = new DetalleError(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(detalle, HttpStatus.INTERNAL_SERVER_ERROR);

    }

}

