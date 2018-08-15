package com.netcracker.edu.smartgreenhouse.server.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netcracker.edu.smartgreenhouse.server.domain.Person;
import com.netcracker.edu.smartgreenhouse.server.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PersonController.class, secure = false)
public class PersonControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @Test
    public void addPerson() throws Exception {
        var person = new Person();

        when(personService.addPersonInfo(person)).thenReturn(person);

        var objMapper = new ObjectMapper();
        var strPerson = objMapper.writeValueAsString(person);

        mockMvc
                .perform(post("/api/persons/new").contentType(MediaType.APPLICATION_JSON).content(strPerson))
                .andExpect(status().isOk());
    }
}
