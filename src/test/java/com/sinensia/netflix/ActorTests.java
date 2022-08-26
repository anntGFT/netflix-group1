package com.sinensia.netflix;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinensia.netflix.models.Actor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.is;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ActorTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testFindbyNameContains() throws Exception{
        mockMvc.perform(get("/actors/1")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.id",is(1)))
                        .andExpect(jsonPath("$.name",is(("Ama Qamata"))));

    }
    @Test

    void testGetAllActors() throws Exception{
        MvcResult result = mockMvc.perform(get("/actors").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }
    @Test
    void testCreateActor() throws Exception{
        Actor actor = new Actor();
        actor.setName("Stellio Kontos");
        mockMvc.perform(post("/actors/create")
                        .with(user("user").roles("USER"))
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(actor)))
                .andExpect(status().isOk());
    }
    @Test
    void testDeleteActor() throws Exception{
        mockMvc.perform(delete("/api/actor/delete/{id}",132).contentType(MediaType.APPLICATION_JSON)
                        .with(user("admin").roles("ADMIN"))
                        .with(csrf()))
                .andExpect(status().isOk());
    }
    @Test
    void testUpdateActor() throws Exception{
        Actor actor = new Actor();
        actor.setName("Papa John");
        mockMvc.perform(put("/api/Actor/update/{id}",133)
                        .with(user("admin").roles("ADMIN"))
                        .with(csrf())
                        .content(asJsonString(actor))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
