package com.netcracker.edu.smartgreenhouse.server.repository;

import com.netcracker.edu.smartgreenhouse.server.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
    Person findByUsername(String username);
}
