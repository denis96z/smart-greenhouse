package com.netcracker.edu.smartgreenhouse.server.service;

import com.netcracker.edu.smartgreenhouse.server.domain.Device;
import com.netcracker.edu.smartgreenhouse.server.domain.DeviceData;
import com.netcracker.edu.smartgreenhouse.server.exception.NotFoundException;
import com.netcracker.edu.smartgreenhouse.server.repository.DeviceDataRepository;
import com.netcracker.edu.smartgreenhouse.server.repository.DeviceRepository;
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

    private Device getDeviceInfo(UUID deviceId) {
        var device = deviceRepository.findById(deviceId);
        if (device.isPresent()) {
            return device.get();
        } else {
            throw new NotFoundException("Device not found");
        }
    }

    @Override
    public void addDeviceData(UUID deviceId, DeviceData deviceData) {
        var device = getDeviceInfo(deviceId);
        deviceData.setDevice(device);
        deviceData.setTimestamp(new Date());
        deviceDataRepository.save(deviceData);
    }

    @Override
    public List<DeviceData> getDeviceData(UUID deviceId, Date fromDate, Date toDate) {
        getDeviceInfo(deviceId);

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
