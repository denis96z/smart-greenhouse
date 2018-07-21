package com.netracker.edu.smartgreenhouse.server.controller.api;

import com.netracker.edu.smartgreenhouse.server.domain.DeviceData;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/data")
public class DeviceDataController {
    @GetMapping("/{deviceId}")
    public List<DeviceData> getDeviceData(@PathVariable UUID deviceId, @RequestBody String jsonBody) {
        throw new RuntimeException();
    }

    @PostMapping("/{deviceId}")
    public void addDeviceData(@PathVariable UUID deviceId, @RequestBody String jsonBody) {
        throw new RuntimeException();
    }
}
