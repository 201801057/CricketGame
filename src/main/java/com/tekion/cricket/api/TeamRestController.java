package com.tekion.cricket.api;

import com.tekion.cricket.model.Team;
import com.tekion.cricket.services.dao.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("teams")
public class TeamRestController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/")
    public List<Team> getAllTeams(){
        return teamService.findAllTeams();
    }

    @GetMapping("/{teamId}")
    public Optional<Team> getTeamById(@PathVariable String teamId){
        return teamService.findByTeamId(String.valueOf(teamId));
    }

    @DeleteMapping(value = "/{teamId}")
    public void deleteByTeamId(@PathVariable("teamId") String teamId){
        teamService.deleteByTeamId(teamId);
    }

}
