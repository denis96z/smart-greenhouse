package com.netracker.edu.smartgreenhouse.server.service;

import com.netracker.edu.smartgreenhouse.server.domain.DeviceData;
import com.netracker.edu.smartgreenhouse.server.repository.DeviceDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class DeviceDataServiceImpl implements DeviceDataService {
    private final DeviceDataRepository deviceDataRepository;

    @Autowired
    public DeviceDataServiceImpl(DeviceDataRepository deviceDataRepository) {
        this.deviceDataRepository = deviceDataRepository;
    }

    @Override
    public List<DeviceData> getDeviceData(UUID deviceId, Date fromDate, Date toDate) {
        var list = new ArrayList<DeviceData>();
        deviceDataRepository.findByDeviceIdAndDatesBetween(deviceId, fromDate, toDate).forEach(list::add);
        return list;
    }

    @Override
    public void addDeviceData(UUID deviceId, DeviceData deviceData) {
        throw new RuntimeException();
    }
}