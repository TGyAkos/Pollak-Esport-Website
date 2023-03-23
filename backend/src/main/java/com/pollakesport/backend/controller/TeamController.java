package com.pollakesport.backend.controller;

import com.pollakesport.backend.domain_model.Team;
import com.pollakesport.backend.repository.TeamRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping
    public List<Team> findAllTeams() {
        return (List<Team>) teamRepository.findAll();
    }

    @GetMapping("/names")
    public JSONObject findAllTeamName() {
        Iterable<Team> allTeams = teamRepository.findAll();
        JSONObject jsonObject = new JSONObject();

        int counter = 0;
        for (Team team : allTeams) {
            jsonObject.put("team" + counter, team.getName());
            counter++;
        }
        return jsonObject;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> findTeamById(@PathVariable("id") UUID id) {
        Optional<Team> team = teamRepository.findById(id);

        if (team.isPresent()) {
            return ResponseEntity.ok().body(team.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Team saveTeam(@Validated @RequestBody Team team) {
        return teamRepository.save(team);
    }
}
