package com.netracker.edu.smartgreenhouse.server.service;

import com.netracker.edu.smartgreenhouse.server.domain.DeviceData;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Transactional
public class DeviceDataServiceImpl implements DeviceDataService {
    @Override
    public List<DeviceData> getDeviceData(UUID deviceId, Date from, Date to) {
        throw new RuntimeException();
    }

    @Override
    public void addDeviceData(UUID deviceId, DeviceData deviceData) {
        throw new RuntimeException();
    }
}
