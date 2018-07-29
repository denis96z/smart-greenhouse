package com.netracker.edu.smartgreenhouse.server.controller.api;

import com.netracker.edu.smartgreenhouse.server.domain.DeviceCommand;
import com.netracker.edu.smartgreenhouse.server.exception.NotFoundException;
import com.netracker.edu.smartgreenhouse.server.service.DeviceCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.netracker.edu.smartgreenhouse.server.constant.Format.DATE_FORMAT;

@RestController
@RequestMapping("/api/commands")
public class DeviceCommandController {
    private final DeviceCommandService service;

    @Autowired
    public DeviceCommandController(DeviceCommandService service) {
        this.service = service;
    }

    @GetMapping("/{deviceId}/all")
    public List<DeviceCommand> getDeviceCommands(@PathVariable UUID deviceId,
            @RequestParam("fromDate") @DateTimeFormat(pattern = DATE_FORMAT) Date fromDate,
            @RequestParam("toDate") @DateTimeFormat(pattern = DATE_FORMAT) Date toDate) {
        return service.getDeviceCommands(deviceId, fromDate, toDate);
    }

    @GetMapping("/{deviceId}/new")
    public List<DeviceCommand> getNewDeviceCommands(@PathVariable UUID deviceId) {
        return service.getNewDeviceCommands(deviceId);
    }

    @GetMapping("/{deviceId}/executed/ok")
    public List<DeviceCommand> getExecutedOkDeviceCommands(@PathVariable UUID deviceId,
            @RequestParam("fromDate") @DateTimeFormat(pattern = DATE_FORMAT) Date fromDate,
            @RequestParam("toDate") @DateTimeFormat(pattern = DATE_FORMAT) Date toDate) {
        return service.getExecutedOkDeviceCommands(deviceId, fromDate, toDate);
    }

    @GetMapping("/{deviceId}/executed/error")
    public List<DeviceCommand> getExecutedErrorDeviceCommands(@PathVariable UUID deviceId,
            @RequestParam("fromDate") @DateTimeFormat(pattern = DATE_FORMAT) Date fromDate,
            @RequestParam("toDate") @DateTimeFormat(pattern = DATE_FORMAT) Date toDate) {
        return service.getExecutedErrorDeviceCommands(deviceId, fromDate, toDate);
    }

    @PostMapping("/{deviceId}")
    public void addDeviceCommand(@PathVariable UUID deviceId, @RequestBody DeviceCommand deviceCommand) {
        service.addDeviceCommand(deviceId, deviceCommand);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public String handleNotFoundException(NotFoundException exception) {
        return exception.getMessage();
    }
}
