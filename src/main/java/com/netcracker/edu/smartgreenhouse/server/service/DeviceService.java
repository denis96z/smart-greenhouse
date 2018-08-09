package com.netcracker.edu.smartgreenhouse.server.service;

import com.netcracker.edu.smartgreenhouse.server.domain.Device;
import org.springframework.security.access.annotation.Secured;

import java.util.List;
import java.util.UUID;

public interface DeviceService {
    @Secured("ROLE_ADMIN")
    void addDeviceInfo(Device device);

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    Device getDeviceInfo(UUID deviceId);

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    void editDeviceInfo(Device device);

    @Secured("ROLE_ADMIN")
    void deleteDeviceInfo(UUID deviceId);

    @Secured("ROLE_USER")
    List<Device> getDevicesByGreenhouse(UUID greenhouseId);
}
