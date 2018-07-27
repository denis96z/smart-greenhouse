package com.netracker.edu.smartgreenhouse.server.service;

import com.netracker.edu.smartgreenhouse.server.domain.Greenhouse;

import java.util.List;
import java.util.UUID;

public interface GreenhouseService {
    List<Greenhouse> getGreenhouses(UUID ownerId);
}
