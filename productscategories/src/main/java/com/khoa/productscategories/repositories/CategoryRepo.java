package com.khoa.productscategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.khoa.productscategories.models.Category;

public interface CategoryRepo extends CrudRepository<Category, Long>{
	List<Category> findAll();
}
