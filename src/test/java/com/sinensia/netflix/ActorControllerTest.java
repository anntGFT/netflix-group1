package com.sinensia.netflix;
import com.sinensia.netflix.exceptions.ActorNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.Errors;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ActorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testFindbyNameContains() throws Exception{
        mockMvc.perform(get("/actors/name/Ama Qamata")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.[0].id",is(1)))
                        .andExpect(jsonPath("$.[0].name",is(("Ama Qamata"))));

    }
    @Test
    void testFindbyNameNotFound() throws ActorNotFoundException,Exception{
        try {
            assertThrows(ActorNotFoundException.class, (Executable)   mockMvc.perform(get("/actors/name/Ama Qamalata")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk()).andExpect(status().reason("null")));

        }catch(ActorNotFoundException Ae){

        }


    }
    @Test
    void testFindbyId() throws Exception{
        mockMvc.perform(get("/actors/name/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id",is(1280)))
                .andExpect(jsonPath("$.[0].name",is("Mack 10")))
                .andExpect(jsonPath("$.[1].id",is(	27467)))
                .andExpect(jsonPath("$.[1].name",is("B1A4")))
                .andExpect(jsonPath("$.[2].id",is(		28830)))
                .andExpect(jsonPath("$.[2].name",is("this documentary follows the plight of 18 Beluga whales kept in captivity for years.")));
    }
}
