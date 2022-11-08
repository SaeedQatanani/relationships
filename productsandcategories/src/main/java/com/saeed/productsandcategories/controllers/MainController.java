package com.saeed.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saeed.productsandcategories.models.Category;
import com.saeed.productsandcategories.models.Product;
import com.saeed.productsandcategories.services.CategoryService;
import com.saeed.productsandcategories.services.ProductService;

@Controller
public class MainController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/")
    public String index(Model model) {
		model.addAttribute("products", productService.allProducts());
		model.addAttribute("categories", categoryService.allCategories());
        return "home.jsp";
    }
	@GetMapping("/products/new")
	public String product(@ModelAttribute("product") Product product) {
		return "product.jsp";
	}
	@PostMapping("/products")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "product.jsp";
		}
		else {
			productService.createProduct(product);
			return "redirect:/";
		}
	}
	@GetMapping("/categories/new")
	public String category(@ModelAttribute("category") Category category) {
		return "category.jsp";
	}
	@PostMapping("/categories")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "category.jsp";
		}
		else {
			categoryService.createCategory(category);
			return "redirect:/";
		}
	}
	@GetMapping("/products/{productId}")
	public String showProduct(Model model, @PathVariable("productId") Long id) {
		Product product = productService.findProduct(id);
		model.addAttribute("product", product);
		model.addAttribute("categories", categoryService.categoriesNotInProduct(product));
		return "showproduct.jsp";
	}
	@GetMapping("/categories/{categoryId}")
	public String showCategory(Model model, @PathVariable("categoryId") Long id) {
		Category category = categoryService.findCategory(id);
		model.addAttribute("category", category);
		model.addAttribute("products", productService.productssNotIncategory(category));
		return "showcategory.jsp";
	}
	@PostMapping("/products/addCat")
	public String addCat(@RequestParam("product") Long idp, @RequestParam("category") Long idc) {
		Product product = productService.findProduct(idp);
		Category category = categoryService.findCategory(idc);
		List<Category> productCategories = product.getCategories();
		productCategories.add(category);
		product.setCategories(productCategories);
		productService.updateProduct(product);
		return "redirect:/";
	}
	
}
