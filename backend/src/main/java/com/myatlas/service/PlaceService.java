package com.myatlas.service;

import com.myatlas.model.Place;
import com.myatlas.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    public Place addPlace(Place place) {
        // Здесь можно добавить дополнительную логику для добавления места, такую как валидация данных
        return placeRepository.save(place);
    }

    public Optional<Place> findById(Long placeId) {
        return placeRepository.findById(placeId);
    }

    public List<Place> findByCategory(String category) {
        return placeRepository.findByCategory(category);
    }

    public List<Place> findByName(String name) {
        return placeRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Place> findByCoordinates(double minLat, double maxLat, double minLon, double maxLon) {
        return placeRepository.findByLatitudeBetweenAndLongitudeBetween(minLat, maxLat, minLon, maxLon);
    }

    public Place updatePlace(Place place) {
        // Здесь можно добавить логику для обновления информации о месте
        return placeRepository.save(place);
    }

    public void deletePlace(Long placeId) {
        placeRepository.deleteById(placeId);
    }
}
