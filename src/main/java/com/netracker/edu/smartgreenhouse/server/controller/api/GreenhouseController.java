package com.netracker.edu.smartgreenhouse.server.controller.api;

import com.netracker.edu.smartgreenhouse.server.domain.Greenhouse;
import com.netracker.edu.smartgreenhouse.server.exception.NotFoundException;
import com.netracker.edu.smartgreenhouse.server.service.GreenhouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/new")
    public void addGreenhouseInfo(@RequestBody Greenhouse greenhouse) {
        service.addGreenhouseInfo(greenhouse);
    }

    @GetMapping("/{greenhouseId}")
    public Greenhouse getGreenhouseInfo(@PathVariable UUID greenhouseId) {
        return service.getGreenhouseInfo(greenhouseId);
    }

    @PutMapping("/{greenhouseId}")
    public void editGreenhouseInfo(@PathVariable UUID greenhouseId, @RequestBody Greenhouse greenhouse) {
        greenhouse.setId(greenhouseId);
        service.editGreenhouseInfo(greenhouse);
    }

    @DeleteMapping("/{greenhouseId}")
    public void deleteGreenhouseInfo(@PathVariable UUID greenhouseId) {
        service.deleteGreenhouseInfo(greenhouseId);
    }

    @GetMapping("/owner/{ownerId}")
    public List<Greenhouse> getGreenhousesByOwner(@PathVariable Long ownerId) {
        return service.getGreenhousesByOwner(ownerId);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public String handleNotFoundException(NotFoundException exception) {
        return exception.getMessage();
    }
}
