package ru.dmitrybugrov.salesDB.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.dmitrybugrov.salesDB.model.JsonError;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;


@ControllerAdvice
@RestController
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidDefinitionException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        JsonError jsonError = new JsonError("Validation Failed",
                ex.getBindingResult().toString());
        return new ResponseEntity(jsonError, HttpStatus.BAD_REQUEST);

    }
}