package com.netcracker.edu.smartgreenhouse.server.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netcracker.edu.smartgreenhouse.server.domain.Person;
import com.netcracker.edu.smartgreenhouse.server.exception.NotFoundException;
import com.netcracker.edu.smartgreenhouse.server.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PersonController.class, secure = false)
public class PersonControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @Test
    public void addPersonInfoReturnsOkOnCorrectData() throws Exception {
        var person = new Person();

        var objMapper = new ObjectMapper();
        var strPerson = objMapper.writeValueAsString(person);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/persons/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(strPerson))
                .andExpect(MockMvcResultMatchers
                        .status().isOk())
                .andExpect(MockMvcResultMatchers
                        .content().string(""));
    }

    @Test
    public void addPersonInfoReturnsBadRequestOnWrongData() throws Exception {
        var strNotPerson = "";

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/persons/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(strNotPerson))
                .andExpect(MockMvcResultMatchers
                        .status().isBadRequest())
                .andExpect(MockMvcResultMatchers
                        .content().string(""));
    }

    @Test
    public void getPersonInfoReturnsOkOnExistingPerson() throws Exception {
        var person = new Person();
        var personId = Long.valueOf(1);

        var objMapper = new ObjectMapper();
        var strPerson = objMapper.writeValueAsString(person);

        Mockito.when(personService.getPersonInfo(personId)).thenReturn(person);
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/persons/" + personId))
                .andExpect(MockMvcResultMatchers
                        .status().isOk())
                .andExpect(MockMvcResultMatchers
                        .content().string(strPerson));
    }

    @Test
    public void getPersonInfoReturnsNotFoundOnNonExistingPerson() throws Exception {
        var personId = Long.valueOf(1);

        var errMsg = "Person not found";
        Mockito.when(personService.getPersonInfo(personId))
                .thenThrow(new NotFoundException(errMsg));

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/persons/" + personId))
                .andExpect(MockMvcResultMatchers
                        .status().isNotFound())
                .andExpect(MockMvcResultMatchers
                        .content().string(errMsg));
    }
}
