package com.netracker.edu.smartgreenhouse.server.service;

import com.netracker.edu.smartgreenhouse.server.domain.Person;
import com.netracker.edu.smartgreenhouse.server.exception.NotFoundException;
import com.netracker.edu.smartgreenhouse.server.repository.PersonRepository;
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
    public void addPersonInfo(Person person) {
        personRepository.save(person);
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
    public void editPersonInfo(Person person) {
        var newPerson = personRepository.findById(person.getId());
        if (newPerson.isPresent()) {
            personRepository.save(person);
        }
        throw new NotFoundException("Person not found");
    }

    @Override
    public void deletePersonInfo(@NotNull Long personId) {
        var person = personRepository.findById(personId);
        if (person.isPresent()) {
            personRepository.delete(person.get());
        } else {
            throw new NotFoundException("Person not found");
        }
    }
}