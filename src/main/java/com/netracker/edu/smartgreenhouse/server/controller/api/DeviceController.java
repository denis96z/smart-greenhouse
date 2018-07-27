package com.netracker.edu.smartgreenhouse.server.controller.api;

import com.netracker.edu.smartgreenhouse.server.domain.Device;
import com.netracker.edu.smartgreenhouse.server.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {
    private final DeviceService service;

    @Autowired
    public DeviceController(DeviceService service) {
        this.service = service;
    }

    @GetMapping("/{greenhouseId}")
    public List<Device> getDevices(@PathVariable UUID greenhouseId) {
        return service.getDevices(greenhouseId);
    }
}
