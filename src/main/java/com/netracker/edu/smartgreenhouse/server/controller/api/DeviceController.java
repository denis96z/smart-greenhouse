package com.netracker.edu.smartgreenhouse.server.controller.api;

import com.netracker.edu.smartgreenhouse.server.domain.Device;
import com.netracker.edu.smartgreenhouse.server.exception.NotImplementedException;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {
    @PostMapping("/new")
    public void addDeviceInfo(@RequestBody Device device) {
        throw new NotImplementedException();
    }

    @GetMapping("{deviceId}")
    public void getDeviceInfo(@PathVariable UUID deviceId) {
        throw new NotImplementedException();
    }

    @PutMapping("{deviceId}")
    public void editDeviceInfo(@PathVariable UUID deviceId, @RequestBody Device device) {
        throw new NotImplementedException();
    }

    @DeleteMapping("{deviceId}")
    public void deleteDeviceInfo(@PathVariable UUID deviceId) {
        throw new NotImplementedException();
    }

    @GetMapping("/greenhouse/{greenhouseId}")
    public void getDevicesByGreenhouse(@PathVariable UUID greenhouseId) {
        throw new NotImplementedException();
    }
}
