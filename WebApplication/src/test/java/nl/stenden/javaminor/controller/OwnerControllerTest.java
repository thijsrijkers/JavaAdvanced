package nl.stenden.javaminor.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.stenden.javaminor.Model.Owner;
import nl.stenden.javaminor.config.TestApplicationControllerConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitWebConfig(classes = TestApplicationControllerConfig.class)
public class OwnerControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void testGetOwners() throws Exception {
        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testGetOwner() throws Exception {
        mockMvc.perform(get("/owners/1"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testDeleteOwner() throws Exception {
        mockMvc.perform(delete("/owners/1"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testPostOwner() throws Exception {
        Owner owner = new Owner();
        owner.setName("TestOwner");

        mockMvc.perform(post("/Owners")
                        .content(new ObjectMapper().writeValueAsString(owner))
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

    }
}
