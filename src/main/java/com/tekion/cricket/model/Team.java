package com.tekion.cricket.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
@Document(collection = "teams")
public class Team {

    @Id
    private String teamID;
    private ArrayList<Player> playersInfo = new ArrayList<>(11);
    private int totalScore;
    private int totalWickets;
    private int currPlayer;

    public Team(){
        this.totalScore = 0;
        int rating = 1;
        for(int i=0;i<6;i++){
            if(i < 2) rating  = 5;
            else if(i < 4) rating  = 4;
            else rating  = 3;


            Player p1 = new Player(PlayerType.BATSMEN, Integer.toString(i), rating);
            playersInfo.add(p1);
        }

        for(int i=0;i<=4;i++){
            if(i < 2) rating = 2;
            if(i < 4) rating = 1;
            Player p1 = new Player(PlayerType.BOWLER, Integer.toString(i), rating);
            playersInfo.add(p1);
        }
        this.currPlayer = 0;

    }

    public int getCurrPlayer(){
        return currPlayer;
    }

    public void addCurrPlayer(){
        currPlayer += 1;
    }

    public void setCurrPlayer(int currPlayer) {
        this.currPlayer = currPlayer;
    }

    public ArrayList<Player> getPlayersInfo() {
        return playersInfo;
    }

    public void setPlayersInfo(ArrayList<Player> info){
        playersInfo = info;
    }

    public String getTeamID() {
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

    @Override
    public String toString() {
        return "Team{" +
                "teamID=" + teamID +
                ", playersInfo=" + playersInfo +
                ", totalScore=" + totalScore +
                ", totalWickets=" + totalWickets +
                '}';
    }
}