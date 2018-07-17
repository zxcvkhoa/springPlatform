package com.khoa.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.khoa.productscategories.models.Category;
import com.khoa.productscategories.repositories.CategoryRepo;

@Service
public class CategoryService {
	private final CategoryRepo categoryRepo;
	
	public CategoryService(CategoryRepo categoryRepo) {
		this.categoryRepo = categoryRepo;
	}
	
	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public List<Category> findAllCategories(){
		return categoryRepo.findAll();
	}
	
	public Category findCategory(Long categoryId) {
		Optional<Category> optionalCategory = categoryRepo.findById(categoryId);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
	
	public void update(Category category) {
		categoryRepo.save(category);
	}
	
	public List<Category> readAll(){
		return (List<Category>) categoryRepo.findAll();
	}
}
