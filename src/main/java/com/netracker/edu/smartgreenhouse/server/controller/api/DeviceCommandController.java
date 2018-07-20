package com.netracker.edu.smartgreenhouse.server.controller.api;

import com.netracker.edu.smartgreenhouse.server.model.DeviceCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/commands")
public class DeviceCommandController {
    @GetMapping("${deviceId}/all")
    public List<DeviceCommand> getAllDeviceCommands(@PathVariable("deviceId") Long deviceId) {
        throw new RuntimeException();
    }

    @GetMapping("${deviceId}/new")
    public List<DeviceCommand> getNewDeviceCommands(@PathVariable("deviceId") Long deviceId) {
        throw new RuntimeException();
    }

    @GetMapping("${deviceId}/executed/ok")
    public List<DeviceCommand> getExecutedOkDeviceCommands(@PathVariable("deviceId") Long deviceId) {
        throw new RuntimeException();
    }

    @GetMapping("${deviceId}/executed/error")
    public List<DeviceCommand> getExecutedErrorDeviceCommands(@PathVariable("deviceId") Long deviceId) {
        throw new RuntimeException();
    }

    @PostMapping("${deviceId}")
    public void addDeviceCommand(@PathVariable("deviceId") Long deviceId) {
        throw new RuntimeException();
    }
}
