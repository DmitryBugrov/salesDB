package ru.dmitrybugrov.salesDB.controllers;



import org.apache.log4j.Logger;
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

@RestController
public class ProductController {

    private static final Logger log = Logger.getLogger(ProductController.class);

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
    @GetMapping(path="/product/all")
    public Iterable<Product> getAllProducts() {
        return repo.findAll();
    }

    /**
     * Endpoint: /product/add
     * @param product json object for adding
     * @see Product
     * @return Product which was added and http status
     */
    @PostMapping(path="/product/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addproduct (@Valid @RequestBody  Product product, BindingResult bindingResult) {
        log.debug(product.toString());
        if (bindingResult.hasErrors()) return new ResponseEntity(bindingResult, HttpStatus.BAD_REQUEST);
        List<Product> listProduct=repo.findByName(product.getName());
        log.debug(listProduct.toString());
        if (!listProduct.isEmpty()) {

            //BindingResult er=new BindingResult();
            //JsonError er=new JsonError("error","Product with this name already exist");

            JsonError jsonError = new JsonError("error","Product with this name already exist");
            return new ResponseEntity(jsonError , HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(repo.save(product),HttpStatus.OK);
    }



}
