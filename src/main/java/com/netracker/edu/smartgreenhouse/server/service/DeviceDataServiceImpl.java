package com.netracker.edu.smartgreenhouse.server.service;

import com.netracker.edu.smartgreenhouse.server.domain.DeviceData;
import com.netracker.edu.smartgreenhouse.server.exception.NotFoundException;
import com.netracker.edu.smartgreenhouse.server.repository.DeviceDataRepository;
import com.netracker.edu.smartgreenhouse.server.repository.DeviceRepository;
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
    private final DeviceRepository deviceRepository;
    private final DeviceDataRepository deviceDataRepository;

    @Autowired
    public DeviceDataServiceImpl(DeviceRepository deviceRepository, DeviceDataRepository deviceDataRepository) {
        this.deviceRepository = deviceRepository;
        this.deviceDataRepository = deviceDataRepository;
    }

    @Override
    public void addDeviceData(UUID deviceId, DeviceData deviceData) {
        var device = deviceRepository.findById(deviceId);
        if (device.isPresent()) {
            deviceData.setDevice(device.get());
            deviceData.setTimestamp(new Date());
            deviceDataRepository.save(deviceData);
        } else {
            throw new NotFoundException("Device not found");
        }
    }

    @Override
    public List<DeviceData> getDeviceData(UUID deviceId, Date fromDate, Date toDate) {
        var today = new Date();
        if (toDate == null) {
            toDate = today;
        }
        if (fromDate == null) {
            fromDate = toDate.compareTo(today) < 0 ? toDate : today;
        }

        var list = new ArrayList<DeviceData>();
        deviceDataRepository.findByDevice_IdAndTimestampBetweenOrderByTimestamp(deviceId, fromDate, toDate).forEach(list::add);
        return list;
    }
}
