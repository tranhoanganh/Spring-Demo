package com.anhth.spring.service;

import com.anhth.spring.entity.AttributeEntity;
import com.anhth.spring.entity.ProductEntity;
import org.springframework.data.domain.Page;

public interface AttributeService {
    Page<AttributeEntity> getAllAttribute(int page, int limit);
    AttributeEntity createAttribute(AttributeEntity attributeEntity);
    AttributeEntity updateAttribute(AttributeEntity attributeEntity);
}
