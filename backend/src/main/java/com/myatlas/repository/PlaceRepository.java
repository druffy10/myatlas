package com.myatlas.repository;

import com.myatlas.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    List<Place> findByCategory(String category);

    List<Place> findByNameContainingIgnoreCase(String name);

    List<Place> findByLatitudeBetweenAndLongitudeBetween(double minLat, double maxLat, double minLon, double maxLon);
}
