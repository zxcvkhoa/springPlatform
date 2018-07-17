package com.khoa.waterbnb.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.khoa.waterbnb.models.Review;
import com.khoa.waterbnb.models.User;


@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
    
}