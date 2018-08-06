package com.netracker.edu.smartgreenhouse.server.controller.api;

import com.netracker.edu.smartgreenhouse.server.domain.Greenhouse;
import com.netracker.edu.smartgreenhouse.server.exception.NotImplementedException;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/greenhouses")
public class GreenhouseController {
    @PostMapping("/new")
    public void addGreenhouseInfo(@RequestBody Greenhouse greenhouse) {
        throw new NotImplementedException();
    }

    @GetMapping("/{greenhouseId}")
    public void getGreenhouseInfo(@PathVariable UUID greenhouseId) {
        throw new NotImplementedException();
    }

    @PutMapping("/{greenhouseId}")
    public void editGreenhouseInfo(@PathVariable UUID greenhouseId, @RequestBody Greenhouse greenhouse) {
        throw new NotImplementedException();
    }

    @DeleteMapping("/{greenhouseId}")
    public void deleteGreenhouseInfo(@PathVariable UUID greenhouseId) {
        throw new NotImplementedException();
    }

    @GetMapping("/owner/{personId}")
    public void getGreenhousesByOwner(@PathVariable Long personId) {
        throw new NotImplementedException();
    }
}
