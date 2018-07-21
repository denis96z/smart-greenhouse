package com.netracker.edu.smartgreenhouse.server.service;

import com.netracker.edu.smartgreenhouse.server.domain.DeviceData;
import com.netracker.edu.smartgreenhouse.server.repository.DeviceDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class DeviceDataServiceImpl implements DeviceDataService {
    @Override
    public List<DeviceData> getDeviceData(UUID deviceId, Date fromDate, Date toDate) {
        throw new RuntimeException();
    }

    @Override
    public void addDeviceData(UUID deviceId, DeviceData deviceData) {
        throw new RuntimeException();
    }
}
