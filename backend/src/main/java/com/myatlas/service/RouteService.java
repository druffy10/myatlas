package com.myatlas.service;

import com.myatlas.model.Route;
import com.myatlas.model.Place;
import com.myatlas.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public Route addRoute(Route route) {
        // Здесь можно добавить дополнительную логику для добавления маршрута, такую как валидация данных
        return routeRepository.save(route);
    }

    public Optional<Route> findById(Long routeId) {
        return routeRepository.findById(routeId);
    }

    public List<Route> findByUserId(String userId) {
        return routeRepository.findByUserId(userId);
    }

    public List<Route> findByName(String name) {
        return routeRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Route> findByPlace(Long placeId) {
        return routeRepository.findByPlaces_Id(placeId);
    }

    public Route updateRoute(Route route) {
        // Здесь можно добавить логику для обновления информации о маршруте
        return routeRepository.save(route);
    }

    public void deleteRoute(Long routeId) {
        routeRepository.deleteById(routeId);
    }
}
