package com.netracker.edu.smartgreenhouse.server.repository;

import com.netracker.edu.smartgreenhouse.server.domain.CommandState;
import com.netracker.edu.smartgreenhouse.server.domain.DeviceCommand;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.UUID;

public interface DeviceCommandRepository extends CrudRepository<DeviceCommand, UUID> {
    Iterable<DeviceCommand> findByDevice_IdAndTimestampBetweenOrderByTimestamp(UUID deviceId, Date fromDate, Date toDate);
    Iterable<DeviceCommand> findByDevice_IdAndStateOrderByTimestamp(UUID deviceId, CommandState commandState);
    Iterable<DeviceCommand> findByDevice_IdAndStateAndTimestampBetweenOrderByTimestamp(UUID deviceId, CommandState commandState, Date fromDate, Date toDate);
}
