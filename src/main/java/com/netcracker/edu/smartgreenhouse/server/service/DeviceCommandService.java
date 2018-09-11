package com.netcracker.edu.smartgreenhouse.server.service;

import com.netcracker.edu.smartgreenhouse.server.domain.CommandState;
import com.netcracker.edu.smartgreenhouse.server.domain.DeviceCommand;
import org.springframework.security.access.annotation.Secured;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface DeviceCommandService {
    @Secured("ROLE_USER")
    void addDeviceCommand(UUID deviceId, DeviceCommand deviceCommand);

    @Secured("ROLE_USER")
    List<DeviceCommand> getDeviceCommands(UUID deviceId, CommandState commandState, Date fromDate, Date toDate);
}
