package com.netcracker.edu.smartgreenhouse.server.service;

import com.netcracker.edu.smartgreenhouse.server.domain.Person;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.access.annotation.Secured;

public interface PersonService {
    @Secured("ROLE_ADMIN")
    Person addPersonInfo(@NotNull Person person);

    @Secured("ROLE_USER")
    Person getPersonInfo(@NotNull Long personId);

    @Secured("ROLE_ADMIN")
    Person editPersonInfo(@NotNull Person person);

    @Secured("ROLE_ADMIN")
    Person deletePersonInfo(@NotNull Long personId);
}
