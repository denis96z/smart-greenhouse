package com.netcracker.edu.smartgreenhouse.server.service;

import com.netcracker.edu.smartgreenhouse.server.domain.Greenhouse;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.access.annotation.Secured;

import java.util.List;
import java.util.UUID;

public interface GreenhouseService {
    @Secured("ROLE_ADMIN")
    Greenhouse addGreenhouseInfo(@NotNull Greenhouse greenhouse);

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    Greenhouse getGreenhouseInfo(@NotNull UUID greenhouseId);

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    Greenhouse editGreenhouseInfo(@NotNull Greenhouse greenhouse);

    @Secured("ROLE_ADMIN")
    Greenhouse deleteGreenhouseInfo(@NotNull UUID greenhouseId);

    @Secured("ROLE_USER")
    List<Greenhouse> getGreenhousesByOwner(@NotNull Long ownerId);
}
