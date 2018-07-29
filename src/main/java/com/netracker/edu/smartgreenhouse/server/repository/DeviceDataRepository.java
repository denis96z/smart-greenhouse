package com.netracker.edu.smartgreenhouse.server.repository;

import com.netracker.edu.smartgreenhouse.server.domain.DeviceData;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.UUID;

public interface DeviceDataRepository extends CrudRepository<DeviceData, UUID> {
    Iterable<DeviceData> findByDevice_IdAndTimestampBetweenOrderByTimestamp(UUID deviceId, Date fromDate, Date toDate);
}
