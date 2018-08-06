package com.netracker.edu.smartgreenhouse.server.controller.api;

import com.netracker.edu.smartgreenhouse.server.domain.CommandState;
import com.netracker.edu.smartgreenhouse.server.domain.DeviceCommand;
import com.netracker.edu.smartgreenhouse.server.exception.NotFoundException;
import com.netracker.edu.smartgreenhouse.server.exception.NotImplementedException;
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

    @PostMapping("/{deviceId}")
    public void addDeviceCommand(@PathVariable UUID deviceId, @RequestBody DeviceCommand deviceCommand) {
        service.addDeviceCommand(deviceId, deviceCommand);
    }

    @GetMapping("/{deviceId}")
    public List<DeviceCommand> getDeviceCommands(@PathVariable UUID deviceId,
            @RequestParam(name = "state", required = false) CommandState state,
            @RequestParam(name = "fromDate", required = false) @DateTimeFormat(pattern = DATE_FORMAT) Date fromDate,
            @RequestParam(name = "toDate", required = false) @DateTimeFormat(pattern = DATE_FORMAT) Date toDate) {
        if (state == null) {
            return service.getDeviceCommands(deviceId, fromDate, toDate);
        }

        if (state == CommandState.NOT_EXECUTED) {
            return service.getNewDeviceCommands(deviceId);
        }

        if (fromDate == null) fromDate = new Date();
        if (toDate == null) toDate = new Date();

        switch (state) {
            case EXECUTED_OK:
                return service.getExecutedOkDeviceCommands(deviceId, fromDate, toDate);

            case EXECUTED_ERROR:
                return service.getExecutedErrorDeviceCommands(deviceId, fromDate, toDate);
        }

        throw new NotImplementedException();
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public String handleNotFoundException(NotFoundException exception) {
        return exception.getMessage();
    }
}
