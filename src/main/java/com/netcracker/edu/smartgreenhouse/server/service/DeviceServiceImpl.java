package com.netcracker.edu.smartgreenhouse.server.service;

import com.netcracker.edu.smartgreenhouse.server.domain.Device;
import com.netcracker.edu.smartgreenhouse.server.exception.NotFoundException;
import com.netcracker.edu.smartgreenhouse.server.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public void addDeviceInfo(Device device) {
        deviceRepository.save(device);
    }

    @Override
    public Device getDeviceInfo(UUID deviceId) {
        var device = deviceRepository.findById(deviceId);
        if (device.isPresent()) {
            return device.get();
        }
        throw new NotFoundException("Device not found");
    }

    @Override
    public void editDeviceInfo(Device device) {
        var newDevice = deviceRepository.findById(device.getId());
        if (newDevice.isPresent()) {
            deviceRepository.save(device);
        }
        throw new NotFoundException("Device not found");
    }

    @Override
    public void deleteDeviceInfo(UUID deviceId) {
        var device = deviceRepository.findById(deviceId);
        if (device.isPresent()) {
            deviceRepository.delete(device.get());
        } else {
            throw new NotFoundException("Device not found");
        }
    }

    @Override
    public List<Device> getDevicesByGreenhouse(UUID greenhouseId) {
        var list = new ArrayList<Device>();
        deviceRepository.findByGreenhouse_Id(greenhouseId).forEach(list::add);
        return list;
    }
}
