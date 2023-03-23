package com.pollakesport.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pollakesport.backend.domain_model.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TeamEndpointTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givesaveTeam_whenCorrectInput_thenSuccess() throws Exception {
        Team team = new Team();
        team.setName("TEST");
        team.setMember0("Member0");
        team.setMember1("Member1");
        team.setMember2("Member2");
        team.setMember3("Member3");
        team.setMember4("Member4");

        ObjectMapper objectMapper = new ObjectMapper();

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/team")
                        .contentType("application/json")
                    .content(objectMapper.writeValueAsString(team)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void givenfindAllTeamName_whenGetRequest_thenCorrectDataReturned() throws Exception {
        String expcetedJson = "{\"team1\":\"TEST\"}" ;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/team/names"))
                .andExpect(status().isOk())
                .andExpect(content().json(expcetedJson))
                .andDo(print());

    }
}
