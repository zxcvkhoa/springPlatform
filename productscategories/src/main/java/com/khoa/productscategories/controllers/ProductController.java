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
public class ProductController {
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public ProductController(ProductService productService, CategoryService categoryService){
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "products/new.jsp";
	}
	
	@PostMapping("/products")
	public String create(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "/products/new.jsp";
		} else {
			Product createdProduct = productService.createProduct(product);
			return "redirect:/products/" + createdProduct.getId();
		}
	}
	
	@GetMapping("/products/{productId}")
	public String show(@PathVariable("productId") Long productId, Model model) {
		Product product = productService.findProduct(productId);
		model.addAttribute("product", product);
		List<Category> displayList = categoryService.readAll();
		List<Category> productCategories = productService.findProduct(productId).getCategories();
		for(int i=0; i < productCategories.size(); i++) {
			if(displayList.contains(productCategories.get(i))) {
				displayList.remove(productCategories.get(i));
			}
		}
		model.addAttribute("productCategories", productCategories);
		model.addAttribute("availableCategories", displayList);
		return "/products/show.jsp";
	}
	
	@PostMapping("/products/addcategory")
	private String add(@RequestParam("categoryId") Long categoryId, @RequestParam("productId") Long productId) {
		
		//get category and product objects to be modified
		Category updatedCategory = categoryService.findCategory(categoryId);
		Product addedProduct = productService.findProduct(productId);
		
		//get category's product list, add product to it
		List<Product> productList = updatedCategory.getProducts();
		productList.add(addedProduct);
		
		//set category's product list, update category
		updatedCategory.setProducts(productList);
		categoryService.update(updatedCategory);
		
		return "redirect:/categories/" + categoryId;
	}
	
	
	
	
	
}
