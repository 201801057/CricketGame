package com.tekion.cricket.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import static java.lang.Math.floor;
import static java.lang.Math.random;


@Document(collection = "matches")
@Component
@Data
public class Match{

    Team team1 = new Team();
    Team team2 = new Team();

    @Id
    private String matchId;
    private static final int TOTAL_OVERS = 120;
    private static int zeroRunBallsCount;


    public Match(){
        team1.setCurrPlayer(0);
        team2.setCurrPlayer(0);

    }

    @Override
    public String toString() {
        return "Match{" +
                "matchID=" + matchId +
                ", team1.getPlayersInfo()=" + team1.getPlayersInfo() +
                ", team2.getPlayersInfo()=" + team2.getPlayersInfo() +
                '}';
    }

    public int playBall(int rating){

        int outcome = (int) floor(random() * 100);

        if(outcome >= 0 && outcome <= 10) return 0;
        if(outcome >= 11 && outcome <= 40) return 1;
        if(outcome >= 41 && outcome <= 60) return 2;
        if(outcome >= 61 && outcome <= 70) return 3;
        if(outcome >= 71 && outcome <= 80) return 4;
        if(outcome >= 81 && outcome <= 90) return 6;
        if(outcome >= 91 && outcome <= 91+rating) return 5;

        return 7;

    }

    private void checkMaidenOver(ArrayList<Player> teamObj, int cur){
        if(zeroRunBallsCount == 6){
            zeroRunBallsCount = 0;
            teamObj.get(cur).addMaidenOvers(1);
        }
    }

    private int wicketHelper(int teamName, int totalWickets){

        if(teamName == 1) team1.addCurrPlayer();
        else team2.addCurrPlayer();

        if(teamName == 1 && team1.getCurrPlayer() == 10){
            System.out.printf("The Turn of Team 1 Ended %n");
            return totalWickets;
        }
        if(teamName == 2 && team2.getCurrPlayer() == 10){
            System.out.printf("The Turn of Team 2 Ended %n");
            return totalWickets;

        }

        if( teamName == 1) {
            team2.getPlayersInfo().get(team2.getCurrPlayer()).addWickets(1);
            zeroRunBallsCount += 1;

            checkMaidenOver(team2.getPlayersInfo(), team2.getCurrPlayer());
            team1.getPlayersInfo().get(team1.getCurrPlayer()).addNoOfBallsPlayed(1);
        }
        else{
            team1.getPlayersInfo().get(team1.getCurrPlayer()).addWickets(1);
            zeroRunBallsCount += 1;

            checkMaidenOver(team1.getPlayersInfo(), team1.getCurrPlayer());
            team2.getPlayersInfo().get(team2.getCurrPlayer()).addNoOfBallsPlayed(1);
        }
        totalWickets++;

        return totalWickets;

    }

    private int runHelper(int teamName, int totalRuns, int outcome){

        if (teamName == 1) {
            team1.getPlayersInfo().get(team1.getCurrPlayer()).addRuns(outcome);
            team1.getPlayersInfo().get(team1.getCurrPlayer()).addNoOfBallsPlayed(1);

            if (outcome == 0) {
                zeroRunBallsCount += 1;
                checkMaidenOver(team2.getPlayersInfo(), team2.getCurrPlayer());
            }

            if(outcome == 4)
                team1.getPlayersInfo().get(team1.getCurrPlayer()).addNoOfFours(1);
            if(outcome == 6)
                team1.getPlayersInfo().get(team1.getCurrPlayer()).addNoOfSixes(1);

            team2.getPlayersInfo().get(team2.getCurrPlayer()).addNoOfOvers(1);
            team2.getPlayersInfo().get(team2.getCurrPlayer()).addRunsGiven(outcome);

        }
        else{
            team2.getPlayersInfo().get(team2.getCurrPlayer()).addRuns(outcome);
            team2.getPlayersInfo().get(team2.getCurrPlayer()).addNoOfBallsPlayed(1);

            if (outcome == 0) {
                zeroRunBallsCount += 1;
                checkMaidenOver(team1.getPlayersInfo(), team1.getCurrPlayer());
            }
            if(outcome == 4)
                team2.getPlayersInfo().get(team2.getCurrPlayer()).addNoOfFours(1);
            if(outcome == 6)
                team2.getPlayersInfo().get(team2.getCurrPlayer()).addNoOfSixes(1);

            team1.getPlayersInfo().get(team1.getCurrPlayer()).addNoOfOvers(1);
            team1.getPlayersInfo().get(team1.getCurrPlayer()).addRunsGiven(outcome);

        }
        totalRuns += outcome;
        return totalRuns;

    }

    public int gameTurn(int teamName){
        zeroRunBallsCount = 0;
        System.out.printf("%nCurrent Turn is of %d Team %n", teamName);
        int totalRuns = 0;
        int totalWickets = 0;

        if(teamName == 1){
            team2.setCurrPlayer(6) ;
            team1.setCurrPlayer(0);
        }
        else{
            team1.setCurrPlayer(6);
            team2.setCurrPlayer(0);
        }

        int overs = 0;
        int balls = 0;
        for (overs = 0; overs < TOTAL_OVERS; overs++){

            if(balls == 6){
                balls = 0;

                if ((teamName == 1)) {
                    team2.setCurrPlayer((team2.getCurrPlayer() + 1) % 5 + 6);
                }
                else {
                    team1.setCurrPlayer((team1.getCurrPlayer() + 1) % 5 + 6) ;
                }

            }

            balls++;

            int outcome = 0;
            if(teamName == 1) outcome = playBall(team1.getPlayersInfo().get(team1.getCurrPlayer()).getRating());
            else outcome = playBall(team2.getPlayersInfo().get(team2.getCurrPlayer()).getRating());

            if(outcome == 7){

                totalWickets = wicketHelper(teamName, totalWickets);
            }
            else{
                totalRuns = runHelper(teamName, totalRuns,outcome);

                if(teamName == 2 && totalRuns > team1.getTotalScore() ){
                    System.out.printf("The score of Team %d is %d-%d %n", teamName, totalRuns, totalWickets);
                    return totalRuns;
                }
            }
        }

        System.out.printf("The score of Team %d is %d-%d %n", teamName, totalRuns, totalWickets);
        if (teamName == 1) {
            team1.setTotalScore(totalRuns);
            team1.setTotalWickets(totalWickets);
        }
        else {
            team2.setTotalScore(totalRuns);
            team2.setTotalWickets(totalWickets);
        }
        return totalRuns;
    }

    public static void setZeroRunBallsCount(int zeroRunBallsCount) {
        Match.zeroRunBallsCount = zeroRunBallsCount;
    }
}