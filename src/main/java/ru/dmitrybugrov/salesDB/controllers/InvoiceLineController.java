package ru.dmitrybugrov.salesDB.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.dmitrybugrov.salesDB.model.InvoiceLine;
import ru.dmitrybugrov.salesDB.model.JsonError;
import ru.dmitrybugrov.salesDB.repositories.InvoiceLineRepository;

import javax.validation.Valid;

@RestController
public class InvoiceLineController {
    private static final Logger log = Logger.getLogger(InvoiceLineController.class);

    private InvoiceLineRepository repo;

    @Autowired
    public InvoiceLineController(InvoiceLineRepository repo) {
        this.repo = repo;
    }

    public ResponseEntity<InvoiceLine> add(@Valid @RequestBody InvoiceLine invoice, BindingResult bindingResult) {
        log.debug(invoice.toString());
        if (bindingResult.hasErrors()) return returnErrorBinding(bindingResult);

        return new ResponseEntity(repo.save(invoice), HttpStatus.OK);

    }

    private ResponseEntity returnErrorBinding(BindingResult bindingResult) {
        return new ResponseEntity(
                new JsonError("error",bindingResult.toString())
                , HttpStatus.BAD_REQUEST);
    }
}
