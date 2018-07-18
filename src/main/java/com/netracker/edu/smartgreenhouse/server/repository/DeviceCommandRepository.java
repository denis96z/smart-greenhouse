package com.netracker.edu.smartgreenhouse.server.repository;

import com.netracker.edu.smartgreenhouse.server.model.DeviceCommand;
import org.springframework.data.repository.CrudRepository;

public interface DeviceCommandRepository extends CrudRepository<DeviceCommand, Long> {
}
