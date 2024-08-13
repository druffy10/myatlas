package com.myatlas.dto;

public class ReviewDTO {

    private Long id;
    private String text;
    private int rating;
    private Long userId;
    private Long placeId;

    // Конструктор по умолчанию
    public ReviewDTO() {}

    // Полный конструктор
    public ReviewDTO(Long id, String text, int rating, Long userId, Long placeId) {
        this.id = id;
        this.text = text;
        this.rating = rating;
        this.userId = userId;
        this.placeId = placeId;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }
}
