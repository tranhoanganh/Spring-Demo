package com.anhth.spring.controller;

import com.anhth.spring.entity.ProductEntity;
import com.anhth.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String home(Model model){

        // Đưa thông tin vào Model UI
        model.addAttribute("mes", "Hello!");

        // Trả về template home.html
        return "home";
    }

    @GetMapping("/product")
    public String product(Model model) {
        Page<ProductEntity> list = productService.getAllProduct(0, 10);
        model.addAttribute("product", "Product Page");
        model.addAttribute("products", list.getContent());
        return "product";
    }

    @GetMapping("/addproduct")
    public String addProduct(Model model) {
        ProductEntity product = new ProductEntity();
        model.addAttribute("product", product);
        return "addproduct";
    }

    @PostMapping("/addproduct")
    public String postProduct(@ModelAttribute ProductEntity product) {

        return "redirect:/product";
    }
}
