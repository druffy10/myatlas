package com.myatlas.service;

import com.myatlas.dto.PlaceDTO;
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

    // Добавление нового места
    public Place addPlace(PlaceDTO placeDTO) {
        Place place = new Place();
        place.setName(placeDTO.getName());
        place.setDescription(placeDTO.getDescription());
        // Установите другие поля по необходимости
        return placeRepository.save(place);
    }

    // Обновление существующего места
    public Place updatePlace(Long id, PlaceDTO placeDTO) {
        Place place = placeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Place not found"));

        place.setName(placeDTO.getName());
        place.setDescription(placeDTO.getDescription());
        // Обновите другие поля по необходимости

        return placeRepository.save(place);
    }

    // Получение места по ID
    public Place getPlaceById(Long id) {
        return placeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Place not found"));
    }

    // Получение всех мест
    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    // Поиск места по ID
    public Optional<Place> findById(Long placeId) {
        return placeRepository.findById(placeId);
    }

    // Поиск места по категории
    public List<Place> findByCategory(String category) {
        return placeRepository.findByCategory(category);
    }

    // Поиск места по имени (поиск по части имени, игнорируя регистр)
    public List<Place> findByName(String name) {
        return placeRepository.findByNameContainingIgnoreCase(name);
    }

    // Поиск места по координатам
    public List<Place> findByCoordinates(double minLat, double maxLat, double minLon, double maxLon) {
        return placeRepository.findByLatitudeBetweenAndLongitudeBetween(minLat, maxLat, minLon, maxLon);
    }

    // Удаление места по ID
    public void deletePlace(Long placeId) {
        placeRepository.deleteById(placeId);
    }
}

