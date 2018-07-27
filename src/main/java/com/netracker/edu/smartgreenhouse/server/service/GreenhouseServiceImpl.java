package com.netracker.edu.smartgreenhouse.server.service;

import com.netracker.edu.smartgreenhouse.server.domain.Greenhouse;
import com.netracker.edu.smartgreenhouse.server.repository.GreenhouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GreenhouseServiceImpl implements GreenhouseService {
    private final GreenhouseRepository repository;

    @Autowired
    public GreenhouseServiceImpl(GreenhouseRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Greenhouse> getGreenhouses(UUID ownerId) {
        var list = new ArrayList<Greenhouse>();
        repository.findByOwner_Id(ownerId).forEach(list::add);
        return list;
    }
}
