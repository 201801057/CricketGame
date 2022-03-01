package com.tekion.cricket.services.dao;

import com.tekion.cricket.model.Match;
import com.tekion.cricket.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PlayerService {
    List<Player> findAllPlayers();

    Optional<Player> findByPlayerId(String playerId);

    void savePlayers(List<Player> playerList);

    void deleteByPlayerId(String playerId);
}
