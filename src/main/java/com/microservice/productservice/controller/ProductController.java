package com.microservice.productservice.controller;

import com.microservice.productservice.dto.ProductRequest;
import com.microservice.productservice.dto.ProductResponse;
import com.microservice.productservice.dto.StandardResponse;
import com.microservice.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<StandardResponse>saveProduct(@RequestBody ProductRequest productDTO){
        String mes=productService.createProduct(productDTO);
        return new ResponseEntity<StandardResponse>(new
                StandardResponse(200,"Product Saved.",mes), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<StandardResponse>getAllProducts(){
        List<ProductResponse> productResponseList=productService.getAllProducts();
        return new ResponseEntity<>(new StandardResponse(200,"Rtirevde",productResponseList),HttpStatus.OK);

    }
}
