package com.tekion.cricket.api;


import com.tekion.cricket.model.CricketGame;
import com.tekion.cricket.model.Match;
import com.tekion.cricket.model.Scoreboard;
import com.tekion.cricket.services.dao.MatchService;
import com.tekion.cricket.services.dao.PlayerService;
import com.tekion.cricket.services.dao.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/matches")
public class MatchRestController {

    @Autowired
    public MatchService matchService;

    @Autowired
    public PlayerService playerService;

    @Autowired
    public TeamService teamService;

    @GetMapping("/sayHi")
    public String getHi(){
        return "Hi how are you!!";
    }

    @GetMapping("/")
    public List<Match> getAllMatches(){
        return matchService.findAllMatches();
    }

    @GetMapping("/{matchId}")
    public Optional<Match> getMatchById(@PathVariable("matchId") String matchId){
        return matchService.findByMatchId(matchId);
    }

    @PostMapping("/startGame")
    public void startGame(){
        CricketGame.startGame();
        matchService.saveScoreboard(Scoreboard.getScoreboard());
        Scoreboard.getScoreboard().forEach(match -> {teamService.saveTeams(Arrays.asList(match.getTeam1(), match.getTeam2()));});

        for (Match m : Scoreboard.getScoreboard()){
            playerService.savePlayers(m.getTeam1().getPlayersInfo());
            playerService.savePlayers(m.getTeam2().getPlayersInfo());
        }
    }

    @DeleteMapping("/{matchId}")
    public void deleteMatchById(@PathVariable("matchId") String matchId){
        matchService.deleteMatchById(matchId);
    }
}