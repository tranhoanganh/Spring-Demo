package com.anhth.spring.controller;

import com.anhth.spring.dto.ResponseDTO;
import com.anhth.spring.entity.AttributeEntity;
import com.anhth.spring.entity.ProductEntity;
import com.anhth.spring.service.AttributeService;
import com.anhth.spring.service.ProductService;
import com.anhth.spring.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/att")
public class AttributeController {

    @Autowired
    ProductService productService;

    @Autowired
    AttributeService attributeService;

//    @GetMapping
//    public ResponseDTO getAll(@RequestParam(defaultValue = "0", required = false) String page, @RequestParam(defaultValue = "3", required = false) String limit) {
//        ResponseDTO res = new ResponseDTO();
//        res.setMessage("success");
//        Integer pa = Integer.valueOf(page);
//        Integer li = Integer.valueOf(limit);
//        res.setDatas(productService.getAllProduct(pa, li).getContent());
//        return res;
//    }

    @GetMapping
    public ResponseDTO getAll(@RequestParam Map<String, String> allParams) {
        ResponseDTO res = new ResponseDTO();
        res.setMessage("success");
        Integer page = Utils.parseInteger(allParams.get("page"), 0);
        Integer limit = Utils.parseInteger(allParams.get("limit"), 3);
        res.setDatas(productService.getAllProduct(page, limit).getContent());
        return res;
    }

    //Sử dụng cách này khi gọi api không truyền param sẽ lỗi
//    @GetMapping
//    public ResponseDTO getAll(@Param("page") int page, @Param("limit") int limit) {
//        ResponseDTO res = new ResponseDTO();
//        res.setMessage("success");
//        if (limit == 0) limit = 3;
//        res.setDatas(productService.getAllProduct(page, limit).getContent());
//        return res;
//    }

    @PostMapping
    public ResponseEntity<ResponseDTO> createAtt(@RequestHeader Map<String, String> allHeaders, @RequestBody AttributeEntity attributeEntity) {
        ResponseDTO res = new ResponseDTO("success");
        AttributeEntity p = attributeService.createAttribute(attributeEntity);
        res.setData(p);
        return ResponseEntity.ok(res);
    }

    @PutMapping
    public ResponseEntity<ResponseDTO> updateProduct(@Valid @RequestBody AttributeEntity attributeEntity) {
        ResponseDTO res = new ResponseDTO("success");
        AttributeEntity p = attributeService.updateAttribute(attributeEntity);
        res.setData(p);
        return ResponseEntity.ok(res);
    }
}
