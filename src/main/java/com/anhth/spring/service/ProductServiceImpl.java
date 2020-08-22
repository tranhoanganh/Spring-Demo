package com.anhth.spring.service;

import com.anhth.spring.repository.ProductRepo;
import com.anhth.spring.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepo productRepo;


    @Override
    public Page<ProductEntity> getAllProduct(int page, int limit) {
        return productRepo.findAll(PageRequest.of(page, limit));
    }

    @Override
    public ProductEntity createProduct(ProductEntity productEntity) {
        return productRepo.save(productEntity);
    }

    @Override
    public ProductEntity updateProduct(ProductEntity productEntity) {
        Optional<ProductEntity> wrap = productRepo.findById(productEntity.getId());
        if (!wrap.isPresent()) {
            return null;
        }
        ProductEntity p = wrap.get();
        p.setName(productEntity.getName());
        p.setPrice(productEntity.getPrice());
        p.setQuantity(productEntity.getQuantity());
        p.setCategoryid(productEntity.getCategoryid());
        return productRepo.save(p);
    }
}
