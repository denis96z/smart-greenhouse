package com.netracker.edu.smartgreenhouse.server.service;

import com.netracker.edu.smartgreenhouse.server.domain.Device;

import java.util.List;
import java.util.UUID;

public interface DeviceService {
    void addDeviceInfo(Device device);
    Device getDeviceInfo(UUID deviceId);
    void editDeviceInfo(Device device);
    void deleteDeviceInfo(UUID deviceId);
    List<Device> getDevicesByGreenhouse(UUID greenhouseId);
}
