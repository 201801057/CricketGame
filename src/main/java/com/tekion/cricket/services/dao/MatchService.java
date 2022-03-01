package com.tekion.cricket.services.dao;

import com.tekion.cricket.model.Match;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MatchService {

     List<Match> findAllMatches();

     Optional<Match> findByMatchId(String matchId);

     void saveScoreboard(List<Match> matchList);

     void deleteMatchById(String matchId);
}