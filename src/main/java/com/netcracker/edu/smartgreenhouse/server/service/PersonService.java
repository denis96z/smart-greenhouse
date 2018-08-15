package com.netcracker.edu.smartgreenhouse.server.service;

import com.netcracker.edu.smartgreenhouse.server.domain.Person;
import org.springframework.security.access.annotation.Secured;

public interface PersonService {
    @Secured("ROLE_ADMIN")
    Person addPersonInfo(Person person);

    @Secured("ROLE_USER")
    Person getPersonInfo(Long personId);

    @Secured("ROLE_ADMIN")
    Person editPersonInfo(Person person);

    @Secured("ROLE_ADMIN")
    Person deletePersonInfo(Long personId);
}
