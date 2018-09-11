package com.netcracker.edu.smartgreenhouse.server.service;

import com.netcracker.edu.smartgreenhouse.server.exception.DataFormatException;
import com.netcracker.edu.smartgreenhouse.server.exception.NotFoundException;
import com.netcracker.edu.smartgreenhouse.server.domain.Greenhouse;
import com.netcracker.edu.smartgreenhouse.server.repository.GreenhouseRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GreenhouseServiceImpl implements GreenhouseService {
    private final GreenhouseRepository greenhouseRepository;

    @Autowired
    public GreenhouseServiceImpl(GreenhouseRepository greenhouseRepository) {
        this.greenhouseRepository = greenhouseRepository;
    }

    @Override
    public Greenhouse addGreenhouseInfo(@NotNull Greenhouse greenhouse) {
        if (greenhouse.getId() != null) {
            throw new DataFormatException("ID is expected to be null");
        }
        return greenhouseRepository.save(greenhouse);
    }

    @Override
    public Greenhouse getGreenhouseInfo(@NotNull UUID greenhouseId) {
        var greenhouse = greenhouseRepository.findById(greenhouseId);
        if (!greenhouse.isPresent()) {
            throw new NotFoundException("Greenhouse not found");
        }
        return greenhouse.get();
    }

    @Override
    public Greenhouse editGreenhouseInfo(@NotNull Greenhouse greenhouse) {
        var newGreenhouse = greenhouseRepository.findById(greenhouse.getId());
        if (!newGreenhouse.isPresent()) {
            throw new NotFoundException("Greenhouse not found");
        }
        return greenhouseRepository.save(greenhouse);
    }

    @Override
    public Greenhouse deleteGreenhouseInfo(@NotNull UUID greenhouseId) {
        var existing = greenhouseRepository.findById(greenhouseId);
        if (!existing.isPresent()) {
            throw new NotFoundException("Greenhouse not found");
        }

        var greenhouse = existing.get();
        greenhouseRepository.delete(greenhouse);
        return greenhouse;
    }

    @Override
    public List<Greenhouse> getGreenhousesByOwner(@NotNull Long ownerId) {
        var list = new ArrayList<Greenhouse>();
        greenhouseRepository.findByOwner_Id(ownerId).forEach(list::add);
        return list;
    }
}
