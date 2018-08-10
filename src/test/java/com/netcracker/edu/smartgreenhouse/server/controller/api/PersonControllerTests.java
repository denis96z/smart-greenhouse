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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(PersonController.class)
@ContextConfiguration(classes = NoAuthConfig.class)
public class PersonControllerTests {
    @Autowired
    private MockMvc mvc;

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN", "USER"})
    public void addPersonInfo_validData() throws Exception {
        var person = new Person();
        person.setUsername("user");
        person.setPassword("password");

        mvc.perform(post("/api/persons/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsBytes(person)))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }
}
