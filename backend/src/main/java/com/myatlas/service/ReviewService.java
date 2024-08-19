package com.myatlas.service;

import com.myatlas.dto.ReviewDTO;
import com.myatlas.model.Review;
import com.myatlas.model.Place;
import com.myatlas.model.User;
import com.myatlas.repository.ReviewRepository;
import com.myatlas.repository.PlaceRepository;
import com.myatlas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private UserRepository userRepository;

    public Review addReview(ReviewDTO reviewDTO) {
        validateReview(reviewDTO);

        Place place = placeRepository.findById(reviewDTO.getPlaceId())
                .orElseThrow(() -> new IllegalArgumentException("Place not found"));
        User user = userRepository.findById(reviewDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Review review = new Review();
        review.setText(reviewDTO.getText());
        review.setRating(reviewDTO.getRating());
        review.setPlace(place);
        review.setUser(user);

        return reviewRepository.save(review);
    }

    public Review updateReview(Long id, ReviewDTO reviewDTO) {
        validateReview(reviewDTO);

        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        review.setText(reviewDTO.getText());
        review.setRating(reviewDTO.getRating());

        return reviewRepository.save(review);
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
    }

    public List<Review> getReviewsByPlaceId(Long placeId) {
        return reviewRepository.findByPlaceId(placeId);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> findById(Long reviewId) {
        return reviewRepository.findById(reviewId);
    }

    public List<Review> findByUserId(Long userId) {
        return reviewRepository.findByUserId(userId);
    }

    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    private void validateReview(ReviewDTO reviewDTO) {
        if (!StringUtils.hasText(reviewDTO.getText())) {
            throw new IllegalArgumentException("Review text cannot be empty");
        }

        if (reviewDTO.getRating() < 1 || reviewDTO.getRating() > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }

        if (reviewDTO.getUserId() == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }

        if (reviewDTO.getPlaceId() == null) {
            throw new IllegalArgumentException("Place ID cannot be null");
        }
    }
}



