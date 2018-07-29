package com.netracker.edu.smartgreenhouse.server.service;

import com.netracker.edu.smartgreenhouse.server.domain.DeviceCommand;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface DeviceCommandService {
    List<DeviceCommand> getDeviceCommands(UUID deviceId, Date fromDate, Date toDate);
    List<DeviceCommand> getNewDeviceCommands(UUID deviceId);
    List<DeviceCommand> getExecutedOkDeviceCommands(UUID deviceId, Date fromDate, Date toDate);
    List<DeviceCommand> getExecutedErrorDeviceCommands(UUID deviceId, Date fromDate, Date toDate);
    void addDeviceCommand(UUID deviceId, DeviceCommand deviceCommand);
}
