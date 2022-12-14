package me.kanggara.restful.controllers;

import me.kanggara.restful.models.entities.Product;
import me.kanggara.restful.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping
    public Iterable<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findOne(@PathVariable("id") Long id) {
        ResponseObject responseObject = new ResponseObject();
        Product product = productService.findOne(id);
        if (product != null) {
            responseObject.setStatus("");
            responseObject.setMessage("");
            responseObject.setContent(product);
            return new ResponseEntity<>(responseObject, new HttpHeaders(), HttpStatus.OK);
        }
        responseObject.setStatus("Not Found");
        responseObject.setMessage("User id : " + id + " Not Found");
        return new ResponseEntity<>(responseObject, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }


    @GetMapping("/name")
    public ResponseEntity<ResponseObject> findByName(@RequestParam("name")  String name, @RequestParam("start") int start, @RequestParam("size") int size) {
        ResponseObject responseObject = new ResponseObject();
        Page<Product> product = productService.findByName(name, start, size);
        if (product != null) {
            responseObject.setStatus("");
            responseObject.setMessage("");
            responseObject.setContent((Serializable) product.getContent());
            return new ResponseEntity<>(responseObject, new HttpHeaders(), HttpStatus.OK);
        }
        responseObject.setStatus("Not Found");
        responseObject.setMessage("User " + name + " Not Found");
        return new ResponseEntity<>(responseObject, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        productService.removeOne(id);
    }


}
