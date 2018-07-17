package com.khoa.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.khoa.lookify.models.Lookify;

@Repository
public interface LookifyRepository extends CrudRepository<Lookify, Long>{
	List<Lookify> findAll();
	List<Lookify> findTop10ByOrderByRatingDesc();
}
