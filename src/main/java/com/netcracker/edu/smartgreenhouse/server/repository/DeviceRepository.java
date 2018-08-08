package com.netcracker.edu.smartgreenhouse.server.repository;

import com.netcracker.edu.smartgreenhouse.server.domain.Device;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DeviceRepository extends CrudRepository<Device, UUID> {
    Iterable<Device> findByGreenhouse_Id(UUID greenhouseId);
}
