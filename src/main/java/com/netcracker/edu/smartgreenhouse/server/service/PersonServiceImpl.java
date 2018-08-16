package com.netcracker.edu.smartgreenhouse.server.service;

import com.netcracker.edu.smartgreenhouse.server.domain.Person;
import com.netcracker.edu.smartgreenhouse.server.exception.AlreadyExistsException;
import com.netcracker.edu.smartgreenhouse.server.exception.NotFoundException;
import com.netcracker.edu.smartgreenhouse.server.repository.PersonRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person addPersonInfo(Person person) {
        var existing = personRepository.findById(person.getId());
        if (existing.isPresent()) {
            throw new AlreadyExistsException("Person already exists");
        }
        return personRepository.save(person);
    }

    @Override
    public Person getPersonInfo(@NotNull Long personId) {
        var person = personRepository.findById(personId);
        if (person.isPresent()) {
            return person.get();
        }
        throw new NotFoundException("Person not found");
    }

    @Override
    public Person editPersonInfo(Person person) {
        var existing = personRepository.findById(person.getId());
        if (existing.isPresent()) {
            personRepository.save(person);
            return person;
        }
        throw new NotFoundException("Person not found");
    }

    @Override
    public Person deletePersonInfo(@NotNull Long personId) {
        var existing = personRepository.findById(personId);
        if (existing.isPresent()) {
            var person = existing.get();
            personRepository.delete(person);
            return person;
        }
        throw new NotFoundException("Person not found");
    }
}
