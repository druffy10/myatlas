package com.myatlas.repository;

import com.myatlas.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    List<Route> findByUserId(Long userId);

    List<Route> findByNameContainingIgnoreCase(String name);

    @Query("SELECT r FROM Route r JOIN r.places p WHERE p.id = :placeId")
    List<Route> findByPlaceId(@Param("placeId") Long placeId);
}
