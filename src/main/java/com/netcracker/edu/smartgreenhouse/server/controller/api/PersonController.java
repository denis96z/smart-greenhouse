package com.netcracker.edu.smartgreenhouse.server.controller.api;

import com.netcracker.edu.smartgreenhouse.server.domain.Person;
import com.netcracker.edu.smartgreenhouse.server.exception.NotFoundException;
import com.netcracker.edu.smartgreenhouse.server.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/new")
    public void addPersonInfo(@RequestBody Person person) {
        personService.addPersonInfo(person);
    }

    @GetMapping("{personId}")
    public Person getPersonInfo(@PathVariable Long personId) {
        return personService.getPersonInfo(personId);
    }

    @PutMapping("{personId}")
    public void editPersonInfo(@PathVariable Long personId, @RequestBody Person person) {
        person.setId(personId);
        personService.editPersonInfo(person);
    }

    @DeleteMapping("{personId}")
    public void deletePersonInfo(@PathVariable Long personId) {
        personService.deletePersonInfo(personId);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public String handleNotFoundException(NotFoundException exception) {
        return exception.getMessage();
    }
}
