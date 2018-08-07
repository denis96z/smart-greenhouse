package com.netracker.edu.smartgreenhouse.server.service;

import com.netracker.edu.smartgreenhouse.server.domain.CommandState;
import com.netracker.edu.smartgreenhouse.server.domain.DeviceCommand;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface DeviceCommandService {
    void addDeviceCommand(UUID deviceId, DeviceCommand deviceCommand);
    List<DeviceCommand> getDeviceCommands(UUID deviceId, CommandState commandState, Date fromDate, Date toDate);
}
