package com.microservice.productservice.service;

import com.microservice.productservice.dto.ProductRequest;
import com.microservice.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    String createProduct(ProductRequest productDTO);

    List<ProductResponse> getAllProducts();
}
