package com.microservice.productservice.serviceImpl;

import com.microservice.productservice.dto.ProductRequest;
import com.microservice.productservice.dto.ProductResponse;
import com.microservice.productservice.model.Product;
import com.microservice.productservice.repository.ProductRepository;
import com.microservice.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public String createProduct(ProductRequest productDTO) {
        Product product=modelMapper.map(productDTO,Product.class);
        productRepository.save(product);
        log.info("Product is {} saved",product.getId());
        return "Product Saved" + product.getId();

    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product>productList=productRepository.findAll();

        //productList.stream().map(product ->mapToProductResponse(product));

//        List<ProductResponse>productResponseList=modelMapper.map(productList,
//                new TypeToken<List<ProductResponse>>(){}.getType());
        return productList.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        ProductResponse productResponse=modelMapper.map(product,ProductResponse.class);
//        List<ProductResponse>productResponseList=modelMapper.map(product,
//                new TypeToken<List<ProductResponse>>(){}.getType());
         return productResponse;
    }
}
