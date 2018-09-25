package ru.dmitrybugrov.salesDB.model;


import lombok.Data;
import org.springframework.validation.BindingResult;

@Data
public class JsonError  {
    private String  message;
    private String  details;

    public JsonError(String message, String details) {
        this.message = message;
        this.details = details;
    }
}
