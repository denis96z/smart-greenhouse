package com.netracker.edu.smartgreenhouse.server.controller.api;

import com.netracker.edu.smartgreenhouse.server.domain.DeviceCommand;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.netracker.edu.smartgreenhouse.server.constant.Format.DATE_FORMAT;

@RestController
@RequestMapping("/api/commands")
public class DeviceCommandController {
    @GetMapping("/{deviceId}/all")
    public List<DeviceCommand> getDeviceCommands(@PathVariable Long deviceId,
            @RequestParam("fromDate") @DateTimeFormat(pattern = DATE_FORMAT) Date fromDate,
            @RequestParam("toDate") @DateTimeFormat(pattern = DATE_FORMAT) Date toDate) {
        throw new RuntimeException();
    }

    @GetMapping("/{deviceId}/new")
    public List<DeviceCommand> getNewDeviceCommands(@PathVariable Long deviceId) {
        throw new RuntimeException();
    }

    @GetMapping("/{deviceId}/executed/ok")
    public List<DeviceCommand> getExecutedOkDeviceCommands(@PathVariable Long deviceId,
            @RequestParam("fromDate") @DateTimeFormat(pattern = DATE_FORMAT) Date fromDate,
            @RequestParam("toDate") @DateTimeFormat(pattern = DATE_FORMAT) Date toDate) {
        throw new RuntimeException();
    }

    @GetMapping("/{deviceId}/executed/error")
    public List<DeviceCommand> getExecutedErrorDeviceCommands(@PathVariable Long deviceId,
            @RequestParam("fromDate") @DateTimeFormat(pattern = DATE_FORMAT) Date fromDate,
            @RequestParam("toDate") @DateTimeFormat(pattern = DATE_FORMAT) Date toDate) {
        throw new RuntimeException();
    }

    @PostMapping("/{deviceId}")
    public void addDeviceCommand(@PathVariable Long deviceId, @RequestBody String body) {
        throw new RuntimeException();
    }
}
