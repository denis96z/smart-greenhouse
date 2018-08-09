package com.netcracker.edu.smartgreenhouse.server.service;

import com.netcracker.edu.smartgreenhouse.server.domain.DeviceData;
import com.netcracker.edu.smartgreenhouse.server.domain.DeviceData;
import org.springframework.security.access.annotation.Secured;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface DeviceDataService {
    @Secured("ROLE_USER")
    List<DeviceData> getDeviceData(UUID deviceId, Date from, Date to);

    @Secured("ROLE_USER")
    void addDeviceData(UUID deviceId, DeviceData deviceData);
}
