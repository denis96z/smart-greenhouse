package com.netracker.edu.smartgreenhouse.server.service;

import com.netracker.edu.smartgreenhouse.server.domain.Greenhouse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GreenhouseServiceImpl implements GreenhouseService {
    @Override
    public List<Greenhouse> getGreenhouses(UUID userId) {
        throw new RuntimeException();
    }
}
