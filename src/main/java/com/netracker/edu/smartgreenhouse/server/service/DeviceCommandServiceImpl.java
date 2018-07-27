package com.netracker.edu.smartgreenhouse.server.service;

import com.netracker.edu.smartgreenhouse.server.domain.CommandState;
import com.netracker.edu.smartgreenhouse.server.domain.DeviceCommand;
import com.netracker.edu.smartgreenhouse.server.repository.DeviceCommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class DeviceCommandServiceImpl implements DeviceCommandService {
    private final DeviceCommandRepository repository;

    @Autowired
    public DeviceCommandServiceImpl(DeviceCommandRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DeviceCommand> getDeviceCommands(UUID deviceId, Date fromDate, Date toDate) {
        var list = new ArrayList<DeviceCommand>();
        repository.findByDevice_IdAndTimestampBetweenOrderByTimestamp(deviceId, fromDate, toDate).forEach(list::add);
        return list;
    }

    @Override
    public List<DeviceCommand> getNewDeviceCommands(UUID deviceId) {
        var list = new ArrayList<DeviceCommand>();
        repository.findByDevice_IdAndStateOrderByTimestamp(deviceId, CommandState.NOT_EXECUTED).forEach(list::add);
        return list;
    }

    @Override
    public List<DeviceCommand> getExecutedOkDeviceCommands(UUID deviceId, Date fromDate, Date toDate) {
        return getExecutedDeviceCommands(deviceId, CommandState.EXECUTED_OK, fromDate, toDate);
    }

    @Override
    public List<DeviceCommand> getExecutedErrorDeviceCommands(UUID deviceId, Date fromDate, Date toDate) {
        return getExecutedDeviceCommands(deviceId, CommandState.EXECUTED_ERROR, fromDate, toDate);
    }

    private List<DeviceCommand> getExecutedDeviceCommands(UUID deviceId, CommandState state, Date fromDate, Date toDate) {
        var list = new ArrayList<DeviceCommand>();
        repository.findByDevice_IdAndStateAndTimestampBetweenOrderByTimestamp(deviceId, state, fromDate, toDate).forEach(list::add);
        return list;
    }

    @Override
    public void addDeviceCommand(UUID deviceId, DeviceCommand command) {
        throw new RuntimeException();
    }
}
