package com.myatlas.dto;

import java.util.List;

public class RouteDTO {

    private Long id;
    private String name;
    private String description;
    private List<Long> placeIds;
    private Long userId;

    // Конструктор по умолчанию
    public RouteDTO() {}

    // Полный конструктор
    public RouteDTO(Long id, String name, String description, List<Long> placeIds, Long userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.placeIds = placeIds;
        this.userId = userId;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getPlaceIds() {
        return placeIds;
    }

    public void setPlaceIds(List<Long> placeIds) {
        this.placeIds = placeIds;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
