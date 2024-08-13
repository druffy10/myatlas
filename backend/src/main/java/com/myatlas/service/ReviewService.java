package com.myatlas.service;

import com.myatlas.model.Review;
import com.myatlas.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review addReview(Review review) {
        // Здесь можно добавить дополнительную логику для добавления отзыва, такую как валидация данных
        return reviewRepository.save(review);
    }

    public Optional<Review> findById(Long reviewId) {
        return reviewRepository.findById(reviewId);
    }

    public List<Review> findByPlaceId(Long placeId) {
        return reviewRepository.findByPlaceId(placeId);
    }

    public List<Review> findByUserId(Long userId) {
        return reviewRepository.findByUserId(userId);
    }

    public Review updateReview(Review review) {
        // Здесь можно добавить логику для обновления информации о отзыве
        return reviewRepository.save(review);
    }

    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
