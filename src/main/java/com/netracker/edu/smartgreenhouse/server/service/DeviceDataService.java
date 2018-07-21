package com.netracker.edu.smartgreenhouse.server.service;

import com.netracker.edu.smartgreenhouse.server.domain.DeviceData;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface DeviceDataService {
    List<DeviceData> getDeviceData(UUID deviceId, Date from, Date to);
    void addDeviceData(UUID deviceId, DeviceData deviceData);
}
