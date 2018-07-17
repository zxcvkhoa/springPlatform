package com.khoa.waterbnb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.khoa.waterbnb.models.Review;
import com.khoa.waterbnb.repositories.ReviewRepository;

@Service
public class ReviewService {
private final ReviewRepository reviewRepository;
	
	public ReviewService(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}
	
	public Review createReview(Review review) {
		return reviewRepository.save(review);
	}
	
	public Review findReview(Long reviewId) {
		Optional<Review> optionalReview = reviewRepository.findById(reviewId);
		if(optionalReview.isPresent()) {
			return optionalReview.get();
		}else {
			return null;
		}
	}
	
	public List<Review> readAll(){
		return (List<Review>) reviewRepository.findAll();
	}

	public void update(Review review) {
		reviewRepository.save(review);
	}

}
