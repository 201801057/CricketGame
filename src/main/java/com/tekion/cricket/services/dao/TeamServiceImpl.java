package com.tekion.cricket.services.dao;


import com.tekion.cricket.model.Team;
import com.tekion.cricket.services.repo.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Team> findAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Optional<Team> findByTeamId(String teamId) {
        return teamRepository.findById(teamId);
    }

    @Override
    public void saveTeams(List<Team> teamList) {
        teamList.forEach(team -> teamRepository.save(team));

    }

    @Override
    public void deleteByTeamId(String teamId) {
        teamRepository.deleteById(teamId);
    }
}
