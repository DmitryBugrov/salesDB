package ru.dmitrybugrov.salesDB.controllers;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dmitrybugrov.salesDB.model.JsonError;
import ru.dmitrybugrov.salesDB.model.Sale;
import ru.dmitrybugrov.salesDB.repositories.SaleRepository;

import javax.validation.Valid;


@RestController
public class SaleController {
    private static final Logger log = Logger.getLogger(SaleController.class);

    private SaleRepository repo;

    @Autowired
    public SaleController(SaleRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/sale/add")
    public ResponseEntity<Sale> add (@Valid Sale sale, BindingResult bindingResult) {
        log.debug(sale.toString());
        if (bindingResult.hasErrors()) return returnErrorBinding(bindingResult);

        return new ResponseEntity<Sale>(repo.save(sale),HttpStatus.OK);

    }

    private ResponseEntity returnErrorBinding(BindingResult bindingResult) {
        return new ResponseEntity(
                new JsonError("error",bindingResult.toString())
                , HttpStatus.BAD_REQUEST);
    }
}
