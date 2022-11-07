package com.saeed.productsandcategories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.saeed.productsandcategories.services.CategoryService;
import com.saeed.productsandcategories.services.ProductService;

@Controller
public class MainController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@GetMapping("/")
    public String index() {
        return "home.jsp";
    }
}
