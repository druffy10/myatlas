package com.myatlas.repository;

import com.myatlas.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    List<Route> findByUserId(String userId);

    List<Route> findByNameContainingIgnoreCase(String name);

    List<Route> findByPlaces_Id(Long placeId);
}
