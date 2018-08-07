package com.netracker.edu.smartgreenhouse.server.service;

import com.netracker.edu.smartgreenhouse.server.domain.Greenhouse;

import java.util.List;
import java.util.UUID;

public interface GreenhouseService {
    void addGreenhouseInfo(Greenhouse greenhouse);
    Greenhouse getGreenhouseInfo(UUID greenhouseId);
    void editGreenhouseInfo(Greenhouse greenhouse);
    void deleteGreenhouseInfo(UUID greenhouseId);
    List<Greenhouse> getGreenhousesByOwner(Long personId);
}
