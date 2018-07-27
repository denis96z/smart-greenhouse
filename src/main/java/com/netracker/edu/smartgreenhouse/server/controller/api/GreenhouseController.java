package com.netracker.edu.smartgreenhouse.server.controller.api;

import com.netracker.edu.smartgreenhouse.server.domain.Greenhouse;
import com.netracker.edu.smartgreenhouse.server.service.GreenhouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/greenhouses")
public class GreenhouseController {
    private final GreenhouseService service;

    @Autowired
    public GreenhouseController(GreenhouseService service) {
        this.service = service;
    }

    @GetMapping("/{ownerId}")
    public List<Greenhouse> getGreenhouses(@PathVariable UUID ownerId) {
        return service.getGreenhouses(ownerId);
    }
}
