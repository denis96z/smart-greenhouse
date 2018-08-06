package com.netracker.edu.smartgreenhouse.server.controller.api;

import com.netracker.edu.smartgreenhouse.server.domain.Person;
import com.netracker.edu.smartgreenhouse.server.exception.NotImplementedException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    @PostMapping("/new")
    public void addPersonInfo(@RequestBody Person person) {
        throw new NotImplementedException();
    }

    @GetMapping("{personId}")
    public void getPersonInfo(@PathVariable Long personId) {
        throw new NotImplementedException();
    }

    @PutMapping("{personId}")
    public void editPersonInfo(@PathVariable Long personId, @RequestBody Person person) {
        throw new NotImplementedException();
    }

    @DeleteMapping("{personId}")
    public void deletePersonInfo(@PathVariable Long personId) {
        throw new NotImplementedException();
    }
}
