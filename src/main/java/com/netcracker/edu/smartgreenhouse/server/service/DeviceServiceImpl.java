package com.netcracker.edu.smartgreenhouse.server.service;

import com.netcracker.edu.smartgreenhouse.server.domain.Device;
import com.netcracker.edu.smartgreenhouse.server.exception.DataFormatException;
import com.netcracker.edu.smartgreenhouse.server.exception.NotFoundException;
import com.netcracker.edu.smartgreenhouse.server.repository.DeviceRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public Device addDeviceInfo(@NotNull Device device) {
        if (device.getId() != null) {
            throw new DataFormatException("ID is expected to be null");
        }
        return deviceRepository.save(device);
    }

    @Override
    public Device getDeviceInfo(@NotNull UUID deviceId) {
        return tryFindDevice(deviceId);
    }

    @Override
    public Device editDeviceInfo(@NotNull Device device) {
        tryFindDevice(getDeviceId(device));
        return deviceRepository.save(device);
    }

    @Override
    public Device deleteDeviceInfo(@NotNull UUID deviceId) {
        var device = tryFindDevice(deviceId);
        deviceRepository.delete(device);
        return device;
    }

    @Override
    public List<Device> getDevicesByGreenhouse(@NotNull UUID greenhouseId) {
        var list = new ArrayList<Device>();
        deviceRepository.findByGreenhouse_Id(greenhouseId).forEach(list::add);
        return list;
    }

    private UUID getDeviceId(@NotNull Device device) {
        return Objects.requireNonNull(device.getId());
    }

    private Device tryFindDevice(@NotNull UUID deviceId) {
        var existing = deviceRepository.findById(deviceId);
        if (!existing.isPresent()) {
            throw new NotFoundException("Device not found");
        }
        return existing.get();
    }
}
