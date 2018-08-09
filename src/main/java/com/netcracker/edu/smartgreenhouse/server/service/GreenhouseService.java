package com.netcracker.edu.smartgreenhouse.server.service;

import com.netcracker.edu.smartgreenhouse.server.domain.Greenhouse;
import org.springframework.security.access.annotation.Secured;

import java.util.List;
import java.util.UUID;

public interface GreenhouseService {
    @Secured("ROLE_ADMIN")
    void addGreenhouseInfo(Greenhouse greenhouse);

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    Greenhouse getGreenhouseInfo(UUID greenhouseId);

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    void editGreenhouseInfo(Greenhouse greenhouse);

    @Secured("ROLE_ADMIN")
    void deleteGreenhouseInfo(UUID greenhouseId);

    @Secured("ROLE_USER")
    List<Greenhouse> getGreenhousesByOwner(Long ownerId);
}
