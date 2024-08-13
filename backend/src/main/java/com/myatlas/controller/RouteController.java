package com.myatlas.controller;

import com.myatlas.dto.RouteDTO;
import com.myatlas.model.Route;
import com.myatlas.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping
    public ResponseEntity<Route> createRoute(@RequestBody RouteDTO routeDTO) {
        Route newRoute = routeService.createRoute(routeDTO);
        return ResponseEntity.ok(newRoute);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Route> updateRoute(@PathVariable Long id, @RequestBody RouteDTO routeDTO) {
        Route updatedRoute = routeService.updateRoute(id, routeDTO);
        return ResponseEntity.ok(updatedRoute);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoute(@PathVariable Long id) {
        routeService.deleteRoute(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Route> getRouteById(@PathVariable Long id) {
        Route route = routeService.getRouteById(id);
        return ResponseEntity.ok(route);
    }

    @GetMapping
    public ResponseEntity<List<Route>> getAllRoutes() {
        List<Route> routes = routeService.getAllRoutes();
        return ResponseEntity.ok(routes);
    }
}
