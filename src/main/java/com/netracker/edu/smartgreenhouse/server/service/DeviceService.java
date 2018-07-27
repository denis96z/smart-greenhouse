package com.netracker.edu.smartgreenhouse.server.service;

import com.netracker.edu.smartgreenhouse.server.domain.Device;

import java.util.List;
import java.util.UUID;

public interface DeviceService {
    List<Device> getDevices(UUID greenhouseId);
}
