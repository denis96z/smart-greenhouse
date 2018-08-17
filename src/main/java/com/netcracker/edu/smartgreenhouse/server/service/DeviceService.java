package com.netcracker.edu.smartgreenhouse.server.service;

import com.netcracker.edu.smartgreenhouse.server.domain.Device;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.access.annotation.Secured;

import java.util.List;
import java.util.UUID;

public interface DeviceService {
    @Secured("ROLE_ADMIN")
    Device addDeviceInfo(@NotNull Device device);

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    Device getDeviceInfo(@NotNull UUID deviceId);

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    Device editDeviceInfo(@NotNull Device device);

    @Secured("ROLE_ADMIN")
    Device deleteDeviceInfo(@NotNull UUID deviceId);

    @Secured("ROLE_USER")
    List<Device> getDevicesByGreenhouse(@NotNull UUID greenhouseId);
}
