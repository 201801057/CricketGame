package com.tekion.cricket.services.dao;

import com.tekion.cricket.model.Team;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TeamService {

    List<Team> findAllTeams();

    Optional<Team> findByTeamId(String teamId);

    void saveTeams(List<Team> teamList);

    void deleteByTeamId(String teamId);
}
