package com.company;

import java.util.ArrayList;

public class CricketGame {
  public static void main(String[] args) {
      final Integer TOTAL_MATCHES = 1;

      for(int i=0;i<TOTAL_MATCHES; i++)
        MatchController.playGame();

//      System.out.println(Scoreboard.getScoreboard().get(0).getTeam1().getTotalScore());

//      Scoreboard.getScoreboard().get(0).getBowlingScoreboard();
      Scoreboard.getMatchByID(1);
  }
}
