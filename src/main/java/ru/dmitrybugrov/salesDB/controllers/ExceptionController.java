package ru.dmitrybugrov.salesDB.controllers;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.dmitrybugrov.salesDB.model.JsonError;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;

import javax.persistence.EntityNotFoundException;

import static org.springframework.http.HttpStatus.NOT_FOUND;


@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

//
//    @Override
//    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
//                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
//        JsonError jsonError = new JsonError("Request validation Failed",
//                ex.toString());
//        return new ResponseEntity(jsonError, HttpStatus.BAD_REQUEST);
//
//    }

    @ExceptionHandler ({Exception.class})
    protected  ResponseEntity<Object> handleExceptionHandlerExceptionResolver(Exception ex) {
        JsonError jsonError = new JsonError("error",
                ex.toString());
        return new ResponseEntity(jsonError, HttpStatus.BAD_REQUEST);
    }





}