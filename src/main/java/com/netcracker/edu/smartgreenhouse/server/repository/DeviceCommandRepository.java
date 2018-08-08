package com.netcracker.edu.smartgreenhouse.server.repository;

import com.netcracker.edu.smartgreenhouse.server.domain.DeviceCommand;
import com.netcracker.edu.smartgreenhouse.server.domain.CommandState;
import com.netcracker.edu.smartgreenhouse.server.domain.DeviceCommand;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.UUID;

public interface DeviceCommandRepository extends CrudRepository<DeviceCommand, UUID> {
    Iterable<DeviceCommand> findByDevice_IdAndStateOrderByTimestamp(UUID deviceId, CommandState state);
    Iterable<DeviceCommand> findByDevice_IdAndStateAndTimestampBetweenOrderByTimestamp(UUID deviceId, CommandState state, Date fromDate, Date toDate);
}
