package com.company;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard {

    private static final ArrayList<Match> matchList = new ArrayList<>();

    private Scoreboard(){}

  //    CRUD Operations on Scoreboard

  //    getScoreboard will be a method which will be overloaded getScoreboard(matchID)
  // getScoreboard(matchID, playerID)
  public static List<Match> getScoreboard() {
        return matchList;
    }


    public static void appendScoreboard(Match match){
        matchList.add(match);
    }

    public static void getMatchByID(int id){
        matchList.get(id - 1).getBattingScoreboard();
        matchList.get(id - 1).getBowlingScoreboard();
    }

    public static void deleteScoreboard(){

    }

}
