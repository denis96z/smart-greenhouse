package com.netracker.edu.smartgreenhouse.server.controller.api;

import com.netracker.edu.smartgreenhouse.server.domain.Greenhouse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/greenhouses")
public class GreenhouseController {
    @GetMapping("/{userId}")
    public List<Greenhouse> getGreenhouses(@PathVariable UUID userId) {
        throw new RuntimeException();
    }
}
