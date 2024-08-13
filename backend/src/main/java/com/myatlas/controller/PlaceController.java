package com.myatlas.controller;

import com.myatlas.dto.PlaceDTO;
import com.myatlas.model.Place;
import com.myatlas.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @PostMapping
    public ResponseEntity<Place> addPlace(@RequestBody PlaceDTO placeDTO) {
        Place newPlace = placeService.addPlace(placeDTO);
        return ResponseEntity.ok(newPlace);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Place> updatePlace(@PathVariable Long id, @RequestBody PlaceDTO placeDTO) {
        Place updatedPlace = placeService.updatePlace(id, placeDTO);
        return ResponseEntity.ok(updatedPlace);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable Long id) {
        placeService.deletePlace(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Place> getPlaceById(@PathVariable Long id) {
        Place place = placeService.getPlaceById(id);
        return ResponseEntity.ok(place);
    }

    @GetMapping
    public ResponseEntity<List<Place>> getAllPlaces() {
        List<Place> places = placeService.getAllPlaces();
        return ResponseEntity.ok(places);
    }
}
