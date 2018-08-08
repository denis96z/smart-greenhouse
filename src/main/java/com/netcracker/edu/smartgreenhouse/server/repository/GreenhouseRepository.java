package com.netcracker.edu.smartgreenhouse.server.repository;

import com.netcracker.edu.smartgreenhouse.server.domain.Greenhouse;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface GreenhouseRepository extends CrudRepository<Greenhouse, UUID> {
    Iterable<Greenhouse> findByOwner_Id(Long ownerId);
}
