package com.myatlas.service;

import com.myatlas.dto.RouteDTO;
import com.myatlas.model.Route;
import com.myatlas.model.Place;
import com.myatlas.repository.RouteRepository;
import com.myatlas.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private PlaceRepository placeRepository;

    public Route addRoute(Route route) {
        validateRoute(route);
        return routeRepository.save(route);
    }

    public Optional<Route> findById(Long routeId) {
        return routeRepository.findById(routeId);
    }

    public List<Route> findByUserId(String userId) {
        return routeRepository.findByUserId(Long.valueOf(userId));
    }

    public List<Route> findByName(String name) {
        return routeRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Route> findByPlace(Long placeId) {
        return routeRepository.findByPlaceId(placeId);
    }

    public Route updateRoute(Route route) {
        validateRoute(route);
        return routeRepository.save(route);
    }

    public void deleteRoute(Long routeId) {
        routeRepository.deleteById(routeId);
    }

    public Route createRoute(RouteDTO routeDTO) {
        Route route = new Route();
        route.setName(routeDTO.getName());
        route.setDescription(routeDTO.getDescription());

        // Установите связи с местами (если требуется)
        if (routeDTO.getPlaceIds() != null) {
            List<Place> places = placeRepository.findAllById(routeDTO.getPlaceIds());
            route.setPlaces(places);
        }

        return routeRepository.save(route);
    }

    public Route updateRoute(Long id, RouteDTO routeDTO) {
        Route route = routeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Route not found"));
        route.setName(routeDTO.getName());
        route.setDescription(routeDTO.getDescription());

        // Обновите связи с местами (если требуется)
        if (routeDTO.getPlaceIds() != null) {
            List<Place> places = placeRepository.findAllById(routeDTO.getPlaceIds());
            route.setPlaces(places);
        }

        return routeRepository.save(route);
    }

    public Route getRouteById(Long id) {
        return routeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Route not found"));
    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    private void validateRoute(Route route) {
        if (route.getName() == null || route.getName().isEmpty()) {
            throw new IllegalArgumentException("Route name cannot be empty");
        }

        if (route.getDescription() == null || route.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Route description cannot be empty");
        }

        // Дополнительные проверки
        if (route.getPlaces() == null || route.getPlaces().isEmpty()) {
            throw new IllegalArgumentException("Route must include at least one place");
        }
    }
}
