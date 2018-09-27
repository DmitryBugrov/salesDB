package ru.dmitrybugrov.salesDB.controllers;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.dmitrybugrov.salesDB.model.JsonError;


@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        JsonError jsonError = new JsonError("Request validation Failed",
                ex.toString());
        return new ResponseEntity(jsonError, HttpStatus.BAD_REQUEST);

    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        JsonError jsonError = new JsonError("Request validation Failed",
                ex.toString());
        return new ResponseEntity(jsonError, HttpStatus.BAD_REQUEST);

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        JsonError jsonError = new JsonError("Request validation Failed",
                ex.toString());
        return new ResponseEntity(jsonError, HttpStatus.BAD_REQUEST);
    }


    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        JsonError jsonError = new JsonError(ex.getRequestURL() + " not found",
                ex.toString());
        return new ResponseEntity(jsonError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
            MethodArgumentTypeMismatchException ex, WebRequest request) {
        JsonError jsonError = new JsonError(ex.getName() + " should be of type " + ex.getRequiredType().getName(),
                ex.toString());
        return new ResponseEntity(jsonError, HttpStatus.BAD_REQUEST);
    }

}