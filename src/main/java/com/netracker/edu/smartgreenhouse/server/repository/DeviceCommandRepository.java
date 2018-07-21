package com.netracker.edu.smartgreenhouse.server.repository;

import com.netracker.edu.smartgreenhouse.server.domain.DeviceCommand;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DeviceCommandRepository extends CrudRepository<DeviceCommand, UUID> {
}
