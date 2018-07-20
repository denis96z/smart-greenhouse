package com.netracker.edu.smartgreenhouse.server.controller.api;

import com.netracker.edu.smartgreenhouse.server.model.DeviceData;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/data")
public class DeviceDataController {
    @GetMapping("${deviceId}")
    public List<DeviceData> getDeviceData(@PathVariable("deviceId") Long deviceId) {
        throw new RuntimeException();
    }

    @PostMapping("${deviceId}")
    public void addDeviceData(@PathVariable("deviceId") Long deviceId) {
        throw new RuntimeException();
    }
}
