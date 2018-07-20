package com.netracker.edu.smartgreenhouse.server.repository;

import com.netracker.edu.smartgreenhouse.server.domain.Greenhouse;
import org.springframework.data.repository.CrudRepository;

public interface GreenhouseRepository extends CrudRepository<Greenhouse, Long> {
}
