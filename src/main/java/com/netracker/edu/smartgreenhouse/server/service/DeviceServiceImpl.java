package com.netracker.edu.smartgreenhouse.server.service;

import com.netracker.edu.smartgreenhouse.server.domain.Device;
import com.netracker.edu.smartgreenhouse.server.exception.NotImplementedException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Override
    public void addDeviceInfo(Device device) {
        throw new NotImplementedException();
    }

    @Override
    public Device getDeviceInfo(UUID deviceId) {
        throw new NotImplementedException();
    }

    @Override
    public void editDeviceInfo(Device device) {
        throw new NotImplementedException();
    }

    @Override
    public void deleteDeviceInfo(UUID deviceId) {
        throw new NotImplementedException();
    }

    @Override
    public List<Device> getDevicesByGreenhouse(UUID greenhouseId) {
        throw new NotImplementedException();
    }
}
