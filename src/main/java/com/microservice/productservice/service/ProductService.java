package com.microservice.productservice.service;

import com.microservice.productservice.dto.ProductDTO;
import com.microservice.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    String createProduct(ProductDTO productDTO);

    List<ProductResponse> getAllProducts();
}
