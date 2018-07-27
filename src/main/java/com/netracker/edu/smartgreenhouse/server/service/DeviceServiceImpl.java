package com.netracker.edu.smartgreenhouse.server.service;

import com.netracker.edu.smartgreenhouse.server.domain.Device;
import com.netracker.edu.smartgreenhouse.server.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository repository;

    @Autowired
    public DeviceServiceImpl(DeviceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Device> getDevices(UUID greenhouseId) {
        var list = new ArrayList<Device>();
        repository.findByGreenhouse_Id(greenhouseId).forEach(list::add);
        return list;
    }
}
