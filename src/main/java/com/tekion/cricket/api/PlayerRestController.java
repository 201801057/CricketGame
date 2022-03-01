package com.tekion.cricket.api;


import com.tekion.cricket.model.Player;
import com.tekion.cricket.services.dao.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("players")
public class PlayerRestController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("/")
    public List<Player> getAllPlayers(){
        return playerService.findAllPlayers();
    }

    @GetMapping("/{playerId}")
    public Optional<Player> getPlayerById(@PathVariable String playerId){
        return playerService.findByPlayerId(String.valueOf(playerId));
    }

    @DeleteMapping("/{playerId}")
    public void deleteByPlayerId(@PathVariable("playerId") String playerId){
        playerService.deleteByPlayerId(playerId);
    }


}
