package com.netracker.edu.smartgreenhouse.server.service;

import com.netracker.edu.smartgreenhouse.server.domain.Greenhouse;
import com.netracker.edu.smartgreenhouse.server.exception.NotFoundException;
import com.netracker.edu.smartgreenhouse.server.repository.GreenhouseRepository;
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
    public void addGreenhouseInfo(Greenhouse greenhouse) {
        greenhouseRepository.save(greenhouse);
    }

    @Override
    public Greenhouse getGreenhouseInfo(UUID greenhouseId) {
        var greenhouse = greenhouseRepository.findById(greenhouseId);
        if (greenhouse.isPresent()) {
            return greenhouse.get();
        }
        throw new NotFoundException("Greenhouse not found");
    }

    @Override
    public void editGreenhouseInfo(Greenhouse greenhouse) {
        var newGreenhouse = greenhouseRepository.findById(greenhouse.getId());
        if (newGreenhouse.isPresent()) {
            greenhouseRepository.save(greenhouse);
        }
        throw new NotFoundException("Greenhouse not found");
    }

    @Override
    public void deleteGreenhouseInfo(UUID greenhouseId) {
        var greenhouse = greenhouseRepository.findById(greenhouseId);
        if (greenhouse.isPresent()) {
            greenhouseRepository.delete(greenhouse.get());
        } else {
            throw new NotFoundException("Greenhouse not found");
        }
    }

    @Override
    public List<Greenhouse> getGreenhousesByOwner(Long personId) {
        var list = new ArrayList<Greenhouse>();
        greenhouseRepository.findByOwner_Id(personId).forEach(list::add);
        return list;
    }
}
