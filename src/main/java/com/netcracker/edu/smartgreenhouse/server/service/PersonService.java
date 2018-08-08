package com.netcracker.edu.smartgreenhouse.server.service;

import com.netcracker.edu.smartgreenhouse.server.domain.Person;
import com.netcracker.edu.smartgreenhouse.server.domain.Person;

public interface PersonService {
    void addPersonInfo(Person person);
    Person getPersonInfo(Long personId);
    void editPersonInfo(Person person);
    void deletePersonInfo(Long personId);
}
