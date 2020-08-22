package com.anhth.spring.service;

import com.anhth.spring.entity.ProductEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Page<ProductEntity> getAllProduct(int page, int limit);
    ProductEntity createProduct(ProductEntity productEntity);
    ProductEntity updateProduct(ProductEntity productEntity);
}
