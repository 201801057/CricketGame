package com.tekion.cricket.services.dao;

import com.tekion.cricket.model.Match;
import com.tekion.cricket.services.repo.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Data Access Objects
@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private final MatchRepository matchRepository;

    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public List<Match> findAllMatches() {
        return matchRepository.findAll();
    }

    @Override
    public Optional<Match> findByMatchId(String matchId) {
        return matchRepository.findById(matchId);
    }

    @Override
    public void saveScoreboard(List<Match> matchList) {
        matchList.forEach(matchRepository::save);
    }

    @Override
    public void deleteMatchById(String matchId) {
        matchRepository.deleteById(matchId);
    }
}