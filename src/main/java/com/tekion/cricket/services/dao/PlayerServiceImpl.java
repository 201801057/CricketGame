package com.tekion.cricket.services.dao;

import com.tekion.cricket.model.Player;
import com.tekion.cricket.services.repo.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> findAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Optional<Player> findByPlayerId(String playerId) {
        return playerRepository.findById(playerId);
    }

    @Override
    public void savePlayers(List<Player> playerList) {
        playerList.forEach(player -> playerRepository.save(player));

    }

    @Override
    public void deleteByPlayerId(String playerId) {
        playerRepository.deleteById(playerId);
    }
}
