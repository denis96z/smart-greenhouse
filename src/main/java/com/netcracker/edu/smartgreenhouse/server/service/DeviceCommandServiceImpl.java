package com.netcracker.edu.smartgreenhouse.server.service;

import com.netcracker.edu.smartgreenhouse.server.domain.Device;
import com.netcracker.edu.smartgreenhouse.server.domain.DeviceCommand;
import com.netcracker.edu.smartgreenhouse.server.exception.NotFoundException;
import com.netcracker.edu.smartgreenhouse.server.repository.DeviceCommandRepository;
import com.netcracker.edu.smartgreenhouse.server.repository.DeviceRepository;
import com.netcracker.edu.smartgreenhouse.server.domain.CommandState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class DeviceCommandServiceImpl implements DeviceCommandService {
    private final DeviceRepository deviceRepository;
    private final DeviceCommandRepository deviceCommandRepository;

    @Autowired
    public DeviceCommandServiceImpl(DeviceRepository deviceRepository, DeviceCommandRepository deviceCommandRepository) {
        this.deviceRepository = deviceRepository;
        this.deviceCommandRepository = deviceCommandRepository;
    }

    private Device getDeviceInfo(UUID deviceId) {
        var device = deviceRepository.findById(deviceId);
        if (device.isPresent()) {
            return device.get();
        } else {
            throw new NotFoundException("Device not found");
        }
    }

    @Override
    public void addDeviceCommand(UUID deviceId, DeviceCommand deviceCommand) {
        var device = getDeviceInfo(deviceId);
        deviceCommand.setDevice(device);
        deviceCommand.setTimestamp(new Date());
        deviceCommand.setState(CommandState.NOT_EXECUTED);
        deviceCommandRepository.save(deviceCommand);
    }

    @Override
    public List<DeviceCommand> getDeviceCommands(UUID deviceId,
            CommandState commandState,Date fromDate, Date toDate) {
        getDeviceInfo(deviceId);

        var list = new ArrayList<DeviceCommand>();

        if (commandState == CommandState.NOT_EXECUTED) {
            deviceCommandRepository
                    .findByDevice_IdAndStateOrderByTimestamp(deviceId, commandState)
                    .forEach(list::add);
        } else {
            var today = new Date();
            if (toDate == null) {
                toDate = today;
            }
            if (fromDate == null) {
                fromDate = toDate.compareTo(today) < 0 ? toDate : today;
            }
            deviceCommandRepository
                    .findByDevice_IdAndStateAndTimestampBetweenOrderByTimestamp(
                            deviceId, commandState, fromDate, toDate)
                    .forEach(list::add);
        }

        return list;
    }
}
