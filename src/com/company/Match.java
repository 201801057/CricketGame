package com.company;

import java.util.ArrayList;
import static java.lang.Math.*;

class Match{

    Team t1 = new Team();
    Team t2 = new Team();

    private final ArrayList<Player> team1;
    private final ArrayList<Player> team2;
    private static int num = 1;
    private int matchID = num++;
    private static final int TOTAL_OVERS = 120; // Total number of balls
    private int currTeam1Player = 0;
    private int currTeam2Player = 0;
    private int zeroRunBallsCount = 0;

//    0,1,2,3,4,5 - Batsmen
//    6,7,8,9,10 - Bowlers


    public Match(){
        team1 = t1.getPlayersInfo();
        team2 = t2.getPlayersInfo();
    }

    public Team getTeam1() {
        return t1;
    }

    public Team getTeam2() {
        return t2;
    }

    public int playBall(){
        int outcome = (int) floor(random() * 100);

        if(outcome >= 0 && outcome <= 10) return 0;
        if(outcome >= 11 && outcome <= 40) return 1;
        if(outcome >= 41 && outcome <= 60) return 2;
        if(outcome >= 61 && outcome <= 70) return 3;
        if(outcome >= 71 && outcome <= 80) return 4;
        if(outcome >= 81 && outcome <= 85) return 5;
        if(outcome >= 86 && outcome <= 94) return 6;

        return 7;

    }

    private void checkMaidenOver(ArrayList<Player> teamObj, int cur){
        if(zeroRunBallsCount == 6){
            zeroRunBallsCount = 0;
            teamObj.get(cur).addMaidenOvers(1);
        }
    }

    private int wicketHelper(int teamName, int totalWickets){

        if(teamName == 1) currTeam1Player++;
        else currTeam2Player++;

        if(teamName == 1 && currTeam1Player == 10){
            System.out.printf("The Turn of Team 1 Ended %n");
            return totalWickets;
        }
        if(teamName == 2 && currTeam2Player == 10){
            System.out.printf("The Turn of Team 2 Ended %n");
            return totalWickets;

        }

        if( teamName == 1) {
            team2.get(currTeam2Player).addWickets(1);
            zeroRunBallsCount += 1;

            checkMaidenOver(team2, currTeam2Player);
            team1.get(currTeam1Player).addNoOfBallsPlayed(1);
        }
        else{
            team1.get(currTeam1Player).addWickets(1);
            zeroRunBallsCount += 1;

           checkMaidenOver(team1, currTeam1Player);
            team2.get(currTeam2Player).addNoOfBallsPlayed(1);
        }
        totalWickets++;

        return totalWickets;

    }

    private int runHelper(int teamName, int totalRuns, int outcome){

        if (teamName == 1) {
            team1.get(currTeam1Player).addRuns(outcome);
            team1.get(currTeam1Player).addNoOfBallsPlayed(1);

      if (outcome == 0) {
        zeroRunBallsCount += 1;
        checkMaidenOver(team2, currTeam2Player);
      }

            if(outcome == 4)
                team1.get(currTeam1Player).addNoOfFours(1);
            if(outcome == 6)
                team1.get(currTeam1Player).addNoOfSixes(1);

            team2.get(currTeam2Player).addNoOfOvers(1);
            team2.get(currTeam2Player).addRunsGiven(outcome);

        }
        else{
            team2.get(currTeam2Player).addRuns(outcome);
            team2.get(currTeam2Player).addNoOfBallsPlayed(1);

      if (outcome == 0) {
        zeroRunBallsCount += 1;
        checkMaidenOver(team1, currTeam1Player);
      }
            if(outcome == 4)
                team2.get(currTeam2Player).addNoOfFours(1);
            if(outcome == 6)
                team2.get(currTeam2Player).addNoOfSixes(1);

            team1.get(currTeam1Player).addNoOfOvers(1);
            team1.get(currTeam1Player).addRunsGiven(outcome);

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
            currTeam2Player = 6;
            currTeam1Player = 0;
        }
        else{
            currTeam1Player = 6;
            currTeam2Player = 0;
        }

        int overs = 0;
        int balls = 0;
        for (overs = 0; overs < TOTAL_OVERS; overs++){

            if(balls == 6){
                balls = 0;

                if ((teamName == 1)) {
                    currTeam2Player = (currTeam2Player + 1) % 5 + 6;
                }
                else {
                    currTeam1Player = (currTeam1Player + 1) % 5 + 6;
                }

            }

            balls++;
            int outcome = playBall();

            if(outcome == 7){

               totalWickets = wicketHelper(teamName, totalWickets);
            }
            else{
                totalRuns = runHelper(teamName, totalRuns,outcome);

                if(teamName == 2 && totalRuns > t1.getTotalScore() ){
                    System.out.printf("The score of Team %d is %d-%d %n", teamName, totalRuns, totalWickets);
                    return totalRuns;
                }
            }
        }

        System.out.printf("The score of Team %d is %d-%d %n", teamName, totalRuns, totalWickets);
    if (teamName == 1) {
      t1.setTotalScore(totalRuns);
      t1.setTotalWickets(totalWickets);
    }
    else {
      t2.setTotalScore(totalRuns);
      t2.setTotalWickets(totalWickets);
    }
        return totalRuns;
    }

    public void getBattingScoreboard(){
        System.out.printf("%nBatting Scoreboard For Team 1%n");
        System.out.printf("Player ID - No Of Balls Played - No Of Runs - No Of Boundaries%n");

        for(Player player : this.team1)
            System.out.printf("%d - %d - %d - %d (%d + %d)%n", player.getPlayerID(), player.getNoOfBallsPlayed(), player.getRuns(), player.getBoundaries(), player.getNoOfFours(), player.getNoOfSixes());

        System.out.printf("%nBatting Scoreboard For Team 2%n");
        System.out.printf("Player ID - No Of Balls Played - No Of Runs - No Of Boundaries%n");

        for(Player player : this.team2)
            System.out.printf("%d - %d - %d - %d (%d + %d)%n", player.getPlayerID(), player.getNoOfBallsPlayed(), player.getRuns(), player.getBoundaries(), player.getNoOfFours(), player.getNoOfSixes());
    }

    public void getBowlingScoreboard(){
        System.out.printf("%nBowling Scoreboard For Team 1%n");
        System.out.printf("Player ID - No Of Overs - No Of Runs Given - Wickets - Maiden Overs%n");

        for(Player player : this.team1)
            System.out.printf("%d - %d - %d - %d - %d%n", player.getPlayerID(), player.getNoOfOvers(), player.getRunsGiven(), player.getWickets(), player.getMaidenOvers());

        System.out.printf("%nBowling Scoreboard For Team 2%n");
        System.out.printf("Player ID - No Of Overs - No Of Runs Given - Wickets - Maiden Overs%n");

        for(Player player : this.team2)
            System.out.printf("%d - %d - %d - %d - %d%n", player.getPlayerID(), player.getNoOfOvers(), player.getRunsGiven(), player.getWickets(), player.getMaidenOvers());

    }
}
