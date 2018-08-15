package com.netcracker.edu.smartgreenhouse.server.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netcracker.edu.smartgreenhouse.server.domain.Person;
import com.netcracker.edu.smartgreenhouse.server.exception.AlreadyExistsException;
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
    private PersonService mockService;

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
    public void addPersonInfoReturnsForbiddenOnExistingPerson() throws Exception {
        var person = new Person();

        var objMapper = new ObjectMapper();
        var strPerson = objMapper.writeValueAsString(person);

        var errMsg = "Person already exists";
        Mockito.when(mockService.addPersonInfo(person))
                .thenThrow(new AlreadyExistsException(errMsg));

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/persons/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(strPerson))
                .andExpect(MockMvcResultMatchers
                        .status().isForbidden())
                .andExpect(MockMvcResultMatchers
                        .content().string(errMsg));
    }

    @Test
    public void getPersonInfoReturnsOkOnExistingPerson() throws Exception {
        var person = new Person();
        var personId = Long.valueOf(1);

        var objMapper = new ObjectMapper();
        var strPerson = objMapper.writeValueAsString(person);

        Mockito.when(mockService.getPersonInfo(personId)).thenReturn(person);
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
        Mockito.when(mockService.getPersonInfo(personId))
                .thenThrow(new NotFoundException(errMsg));

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/persons/" + personId))
                .andExpect(MockMvcResultMatchers
                        .status().isNotFound())
                .andExpect(MockMvcResultMatchers
                        .content().string(errMsg));
    }

    @Test
    public void editPersonInfoReturnsOkOnExistingPersonAndCorrectData() throws Exception {
        var person = new Person();
        person.setId(1L);

        var objMapper = new ObjectMapper();
        var strPerson = objMapper.writeValueAsString(person);

        Mockito.when(mockService.editPersonInfo(person)).thenReturn(person);
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/persons/" + person.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(strPerson))
                .andExpect(MockMvcResultMatchers
                        .status().isOk())
                .andExpect(MockMvcResultMatchers
                        .content().string(""));
    }

    @Test
    public void editPersonInfoReturnsNotFoundOnNonExistingPerson() throws Exception {
        var person = new Person();
        person.setId(1L);

        var objMapper = new ObjectMapper();
        var strPerson = objMapper.writeValueAsString(person);

        var errMsg = "Person not found";
        Mockito.when(mockService.editPersonInfo(person))
                .thenThrow(new NotFoundException(errMsg));

        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/persons/" + person.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(strPerson))
                .andExpect(MockMvcResultMatchers
                        .status().isNotFound())
                .andExpect(MockMvcResultMatchers
                        .content().string(errMsg));
    }

    @Test
    public void editPersonInfoReturnsBadRequestOnWrongData() throws Exception {
        var person = new Person();
        person.setId(1L);
        var strNonPerson = "";

        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/persons/" + person.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(strNonPerson))
                .andExpect(MockMvcResultMatchers
                        .status().isBadRequest())
                .andExpect(MockMvcResultMatchers
                        .content().string(""));
    }
}
