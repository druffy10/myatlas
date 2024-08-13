package com.myatlas.controller;

import com.myatlas.dto.ReviewDTO;
import com.myatlas.model.Review;
import com.myatlas.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody ReviewDTO reviewDTO) {
        Review newReview = reviewService.addReview(reviewDTO);
        return ResponseEntity.ok(newReview);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO) {
        Review updatedReview = reviewService.updateReview(id, reviewDTO);
        return ResponseEntity.ok(updatedReview);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Review review = reviewService.getReviewById(id);
        return ResponseEntity.ok(review);
    }

    @GetMapping("/place/{placeId}")
    public ResponseEntity<List<Review>> getReviewsByPlaceId(@PathVariable Long placeId) {
        List<Review> reviews = reviewService.getReviewsByPlaceId(placeId);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }
}
