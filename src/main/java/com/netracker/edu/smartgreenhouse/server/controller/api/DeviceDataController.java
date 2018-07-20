package com.netracker.edu.smartgreenhouse.server.controller.api;

import com.netracker.edu.smartgreenhouse.server.domain.Device;
import com.netracker.edu.smartgreenhouse.server.domain.DeviceData;
import org.apache.tomcat.jni.Time;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/data")
public class DeviceDataController {
    @GetMapping("/{deviceId}")
    public List<DeviceData> getDeviceData(@PathVariable Long deviceId) {
        throw new RuntimeException();
    }

    @PostMapping("/{deviceId}")
    public void addDeviceData(@PathVariable Long deviceId) {
        throw new RuntimeException();
    }
}
