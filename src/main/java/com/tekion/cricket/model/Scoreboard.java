package com.tekion.cricket.model;


import com.tekion.cricket.model.Match;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Scoreboard {

    private static final ArrayList<Match> matchList = new ArrayList<>();

    public static List<Match> getScoreboard() {
        return matchList;
    }

    public static void appendScoreboard(Match match){
        matchList.add(match);
    }
}