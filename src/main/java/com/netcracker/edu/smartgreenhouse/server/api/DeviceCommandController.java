package com.netcracker.edu.smartgreenhouse.server.api;

import com.netcracker.edu.smartgreenhouse.server.domain.DeviceCommand;
import com.netcracker.edu.smartgreenhouse.server.exception.NotFoundException;
import com.netcracker.edu.smartgreenhouse.server.service.DeviceCommandService;
import com.netcracker.edu.smartgreenhouse.server.domain.CommandState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.netcracker.edu.smartgreenhouse.server.constant.Format.DATE_FORMAT;

@RestController
@RequestMapping("/api/commands")
public class DeviceCommandController {
    private final DeviceCommandService service;

    @Autowired
    public DeviceCommandController(DeviceCommandService service) {
        this.service = service;
    }

    @PostMapping("/{deviceId}")
    public void addDeviceCommand(@PathVariable UUID deviceId, @RequestBody DeviceCommand deviceCommand) {
        service.addDeviceCommand(deviceId, deviceCommand);
    }

    @GetMapping("/{deviceId}")
    public List<DeviceCommand> getDeviceCommands(@PathVariable UUID deviceId,
            @RequestParam(name = "commandState", required = false) CommandState commandState,
            @RequestParam(name = "fromDate", required = false) @DateTimeFormat(pattern = DATE_FORMAT) Date fromDate,
            @RequestParam(name = "toDate", required = false) @DateTimeFormat(pattern = DATE_FORMAT) Date toDate) {
        return service.getDeviceCommands(deviceId, commandState, fromDate, toDate);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public String handleNotFoundException(NotFoundException exception) {
        return exception.getMessage();
    }
}
