package com.netracker.edu.smartgreenhouse.server.repository;

import com.netracker.edu.smartgreenhouse.server.model.Device;
import org.springframework.data.repository.CrudRepository;

public interface DeniceRepository extends CrudRepository<Device, Long> {
}
