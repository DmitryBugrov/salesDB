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
import java.util.Optional;

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
    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping(path="/product/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity add (@Valid @RequestBody  Product product, BindingResult bindingResult) {
        log.debug(product.toString());
        if (product==null) return returnErrorEmptyObject();
        if (bindingResult.hasErrors()) return returnErrorBinding(bindingResult);

        List<Product> listProduct=repo.findByName(product.getName());
        log.debug(listProduct.toString());
        if (!listProduct.isEmpty()) {
            JsonError jsonError = new JsonError("error","Product with name: "+product.getName()+" already exist");
            return new ResponseEntity(jsonError , HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(repo.save(product),HttpStatus.OK);
    }

    /**
     * Endpoint: /product/update
     * @param product json object for update
     * @param bindingResult
     * @return updated object and http status
     */
    @PostMapping(path="/product/update", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity update(@Valid @RequestBody Product product, BindingResult bindingResult)  {
        log.debug(product.toString());
        if (product==null) return returnErrorEmptyObject();
        if (bindingResult.hasErrors()) return returnErrorBinding(bindingResult);
        if (product.getId()==null) return new ResponseEntity(
                new JsonError("error","Product have Id=null")
                , HttpStatus.BAD_REQUEST);

        Optional<Product> existProduct=repo.findById(product.getId());
        log.debug(existProduct.toString());
        if (!existProduct.isPresent()) return new ResponseEntity(
                new JsonError("error","Product with Id: "+product.getId()+" not exist")
                , HttpStatus.BAD_REQUEST);
        return new ResponseEntity(repo.save(product),HttpStatus.OK);

    }


    /**
     * Endpoint: /product/delete
     * Protocol: DELETE
     * @param id Id of object for remove
     *
     * @return http status
     */
    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        log.debug(id.toString());
        if (id==null) return returnErrorEmptyObject();
    //    if (bindingResult.hasErrors()) return returnErrorBinding(bindingResult);
        Optional<Product> existProduct=repo.findById(id);
        log.debug(existProduct.toString());
        if (!existProduct.isPresent()) return new ResponseEntity(
                new JsonError("error","Product with Id: "+id+" not exist")
                , HttpStatus.BAD_REQUEST);
        repo.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);

    }


    private ResponseEntity returnErrorBinding(BindingResult bindingResult) {
        return new ResponseEntity(
                new JsonError("error",bindingResult.toString())
                , HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity returnErrorEmptyObject() {
        JsonError jsonError = new JsonError("error","Input Object can't be empty");
        return new ResponseEntity(jsonError , HttpStatus.BAD_REQUEST);
    }



}
