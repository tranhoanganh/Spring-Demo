package com.anhth.spring.service;

import com.anhth.spring.entity.AttributeEntity;
import com.anhth.spring.entity.ProductEntity;
import com.anhth.spring.repository.AttributeRepo;
import com.anhth.spring.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttributeServiceImpl implements AttributeService{

    @Autowired
    AttributeRepo attributeRepo;


    @Override
    public Page<AttributeEntity> getAllAttribute(int page, int limit) {
        return attributeRepo.findAll(PageRequest.of(page, limit));
    }

    @Override
    public AttributeEntity createAttribute(AttributeEntity attributeEntity) {
        return attributeRepo.save(attributeEntity);
    }

    @Override
    public AttributeEntity updateAttribute(AttributeEntity attributeEntity) {
        Optional<AttributeEntity> wrap = attributeRepo.findById(attributeEntity.getId());
        if (!wrap.isPresent()) {
            return null;
        }
        AttributeEntity p = wrap.get();
        p.setName(attributeEntity.getName());
        return attributeRepo.save(p);
    }
}
