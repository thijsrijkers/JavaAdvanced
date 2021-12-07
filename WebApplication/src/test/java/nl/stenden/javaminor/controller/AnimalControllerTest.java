package nl.stenden.javaminor.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.stenden.javaminor.Model.Animal;
import nl.stenden.javaminor.Model.Owner;
import nl.stenden.javaminor.config.TestApplicationControllerConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringJUnitWebConfig(classes = TestApplicationControllerConfig.class)
public class AnimalControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testGetAnimals() throws Exception {
        mockMvc.perform(get("/animals").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testGetAnimal() throws Exception {
        mockMvc.perform(get("/animals/1"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @DirtiesContext
    public void testDeleteAnimal() throws Exception {
        mockMvc.perform(delete("/animals/1"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testPostAnimal() throws Exception {
        Animal animal = new Animal();
        Owner owner = new Owner();
        owner.setId(1);
        owner.setName("tim");
        animal.setName("TestAnimal");
        animal.setOwner(owner);

        mockMvc.perform(post("/animals")
                        .content(new ObjectMapper().writeValueAsString(animal))
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

    }
}
