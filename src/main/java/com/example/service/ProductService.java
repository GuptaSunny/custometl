package com.example.service;

import com.example.dto.ProductDTO;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    public ProductDTO getProduct(String name, String category) {
        return new ProductDTO(name,category,5,"d","zalando");
    }
}
