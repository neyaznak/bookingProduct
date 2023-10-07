package com.infy.bookingProduct.controller;

import com.infy.bookingProduct.model.Product;
import com.infy.bookingProduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping()
    public ResponseEntity<?> productList(@RequestParam(value =  "name", required = false)String name,
                                         @RequestParam(value =  "code", required = false)String code,
                                         @RequestParam(value =  "mrp", required = false)String mrp){
        if(code !=  null && !code.isEmpty()){
            Product existProduct = productService.get(Integer.parseInt(code));
            if(existProduct == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else{
                return new ResponseEntity<>(existProduct, HttpStatus.OK);
            }
        } else if (name != null && !name.isEmpty()) {
            return new ResponseEntity<>(productService.getProductsByName(name), HttpStatus.OK);
        } else if (mrp != null && !mrp.isEmpty()) {
            return new ResponseEntity<>(productService.getProductsByMrp(Float.parseFloat(mrp)), HttpStatus.OK);
        }
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@Validated @RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> update(@RequestBody Product product, @PathVariable("code") int code){
        try{
            Product existProduct = productService.get(code);
            if(existProduct == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            productService.deleteProduct(existProduct);
            return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteProduct(@PathVariable("code") int code){
        productService.delete(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
