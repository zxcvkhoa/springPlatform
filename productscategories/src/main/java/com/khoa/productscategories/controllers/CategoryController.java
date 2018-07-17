package com.khoa.productscategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khoa.productscategories.models.Category;
import com.khoa.productscategories.models.Product;
import com.khoa.productscategories.services.CategoryService;
import com.khoa.productscategories.services.ProductService;

@Controller
public class CategoryController {
	private final CategoryService categoryService;
	private final ProductService productService;
	
	public CategoryController(CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}
	
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		category = new Category();
		return "/categories/new.jsp";
	}
	
	@PostMapping("/categories")
	public String create(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "/categories/new.jsp";
		} else {
			Category createdCategory = categoryService.createCategory(category);
			return "redirect:/categories/" + createdCategory.getId();
		}
	}
	
	@GetMapping("/categories/{categoryId}")
	public String show(@PathVariable("categoryId") Long categoryId, Model model) {
		Category category = categoryService.findCategory(categoryId);
		model.addAttribute("category", category);
		List<Product> displayList = productService.readAll();
		List<Product> categoryProducts = categoryService.findCategory(categoryId).getProducts();
		for(int i=0; i < categoryProducts.size(); i++) {
			if(displayList.contains(categoryProducts.get(i))) {
				displayList.remove(categoryProducts.get(i));
			}
		}
		model.addAttribute("categoryProducts", categoryProducts);
		model.addAttribute("availableProducts", displayList);
		return "/categories/show.jsp";
	}
	
	@PostMapping("/categories/addproduct")
	private String add(@RequestParam("productId") Long productId, @RequestParam("categoryId") Long categoryId) {
		
		//get category and product objects to be modified
		Product updatedProduct = productService.findProduct(productId);
		Category addedCategory = categoryService.findCategory(categoryId);
		
		//get product's category list, add category to it
		List<Category> categoryList = updatedProduct.getCategories();
		categoryList.add(addedCategory);
		
		//set product's category list, update product
		updatedProduct.setCategories(categoryList);
		productService.update(updatedProduct);
		
		return "redirect:/products/" + productId;
	}
	
}
