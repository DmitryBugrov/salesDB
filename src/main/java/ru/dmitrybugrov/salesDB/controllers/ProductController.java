package ru.dmitrybugrov.salesDB.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.dmitrybugrov.salesDB.model.JsonError;
import ru.dmitrybugrov.salesDB.model.Product;
import ru.dmitrybugrov.salesDB.repositories.ProductRepository;

import javax.validation.Valid;
import java.util.List;

@RestController ("/product")
public class ProductController {

    private final ProductRepository repo;

    @Autowired
    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    /**
     * Endpoint: /product/all
     *
     * @return Array of Products
     */
    @GetMapping(path="/all")
    public Iterable<Product> getAllProducts() {
        return repo.findAll();
    }

    /**
     * Endpoint: /product/add
     * @param product json object for adding
     * @see Product
     * @return Product which was added and http status
     */
    @PostMapping(path="/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addproduct (@Valid @RequestBody  Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return new ResponseEntity(bindingResult, HttpStatus.BAD_REQUEST);

        return new ResponseEntity(repo.save(product),HttpStatus.OK);
    }

}
