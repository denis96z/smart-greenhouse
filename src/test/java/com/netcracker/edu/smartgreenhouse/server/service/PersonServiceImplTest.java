package com.netcracker.edu.smartgreenhouse.server.service;

import com.netcracker.edu.smartgreenhouse.server.domain.Person;
import com.netcracker.edu.smartgreenhouse.server.exception.AlreadyExistsException;
import com.netcracker.edu.smartgreenhouse.server.exception.NotFoundException;
import com.netcracker.edu.smartgreenhouse.server.repository.PersonRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class PersonServiceImplTest {
    private Person person;
    private PersonService personService;

    @Mock
    private PersonRepository mockPersonRepository;

    @Before
    public void setup() {
        person = new Person();
        personService = new PersonServiceImpl(mockPersonRepository);
    }

    @Test
    public void addPersonInfoAddsPersonInfoOnNonExistingPerson() {
        setPersonNotExists(); setPersonSaved();
        Assert.assertNotNull(personService.addPersonInfo(person));
    }

    @Test(expected = AlreadyExistsException.class)
    public void addPersonInfoThrowsExceptionOnExistingPerson() {
        setPersonExists();
        personService.addPersonInfo(person);
    }

    @Test
    public void getPersonInfoReturnsPersonInfoOnExistingPerson() {
        person.setId(1L);
        setPersonExists();
        var personId = getPersonId(person);
        Assert.assertNotNull(personService.getPersonInfo(personId));
    }

    @Test(expected = NotFoundException.class)
    public void getPersonInfoThrowsExceptionOnNonExistingPerson() {
        person.setId(1L);
        setPersonNotExists();
        var personId = getPersonId(person);
        personService.getPersonInfo(personId);
    }

    @Test
    public void editPersonInfoEditsPersonInfoOnExistingPerson() {
        person.setId(1L);
        setPersonExists(); setPersonSaved();
        Assert.assertNotNull(personService.editPersonInfo(person));
    }

    @Test(expected = NotFoundException.class)
    public void editPersonInfoThrowsExceptionOnNonExistingPerson() {
        person.setId(1L);
        setPersonNotExists();
        personService.editPersonInfo(person);
    }

    @Test
    public void deletePersonInfoDeletesPersonInfoOnExistingPerson() {
        person.setId(1L);
        setPersonExists();
        var personId = getPersonId(person);
        Assert.assertNotNull(personService.deletePersonInfo(personId));
    }

    @Test(expected = NotFoundException.class)
    public void deletePersonInfoThrowsExceptionOnNonExistingPerson() {
        person.setId(1L);
        setPersonNotExists();
        var personId = getPersonId(person);
        personService.deletePersonInfo(personId);
    }

    private Long getPersonId(Person person) {
        return Objects.requireNonNull(person.getId());
    }

    private void setPersonExists() {
        Mockito
                .when(mockPersonRepository.findById(person.getId()))
                .thenReturn(Optional.of(person));
    }

    private void setPersonNotExists() {
        Mockito
                .when(mockPersonRepository.findById(person.getId()))
                .thenReturn(Optional.empty());
    }

    private void setPersonSaved() {
        Mockito
                .when(mockPersonRepository.save(person))
                .thenReturn(person);
    }
}
