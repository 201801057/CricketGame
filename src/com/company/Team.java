package com.company;


// Total team ka score hoyega
// Team ke players ka information hoyega

import java.util.ArrayList;

public class Team {

    private int teamID;
    private final ArrayList<Player> playersInfo = new ArrayList<>(11);
    private int totalScore;
    private int totalWickets;

    public Team(){
        this.totalScore = 0;
        for(int i=0;i<6;i++){
            Player p1 = new Player(PlayerType.BATSMEN);
            playersInfo.add(p1);
        }
        for(int i=0;i<=4;i++){
            Player p1 = new Player(PlayerType.BOWLER);
            playersInfo.add(p1);
        }

    }

    public ArrayList<Player> getPlayersInfo() {
        return playersInfo;
    }

    public int getTeamID() {
        return teamID;
    }

    public int getTotalScore(){
        return totalScore;
    }

    public int getTotalWickets() {
        return totalWickets;
    }

    public void setTotalWickets(int totalWickets) {
        this.totalWickets = totalWickets;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}
