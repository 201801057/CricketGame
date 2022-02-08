package com.company;

// Classes CricketGame, Player, Match, MatchController

// For every ball outcome is - 0 to 6 Runs or a Wicket

// Match controller to take 2 teams and uses the sequence of random function calls and prints the
// results. Run multiple times and print results
import java.util.ArrayList;


// Every Player will score runs and will take wickets
class Player{
  private int runs;
  private int wickets;

  public Player(){
      this.runs = 0;
      this.wickets = 0;
  }


//    Getter and Setters for Player Class
    public int getRuns() {
        return runs;
    }

    public void addRuns(int runs) {
        this.runs += runs;
    }

    public int getWickets() {
        return wickets;
    }

    public void addWickets(int wickets){
      this.wickets += wickets;
    }

}

class Match{
//    Initializing both the teams with 11 players

    private final ArrayList<Player> team1 = new ArrayList<Player>(11);
    private final ArrayList<Player> team2 = new ArrayList<Player>(11);
    private int overs = 0;
    private static final int TOTALOVERS = 120; // For making a 20 over game
    private int currTeam1Player = 0;
    private int currTeam2Player = 0;
    private ArrayList<Integer> scores = new ArrayList<Integer>();

    public Match(){
        for (int i=0;i<11;i++){
            Player p1 = new Player();
            team1.add(p1);
        }
        for (int i=0;i<11;i++){
            Player p1 = new Player();
            team2.add(p1);
        }
    }

//    Function to guess the outcome of the ball
    public int playBall(){
        return (int) Math.floor(Math.random() * 8);
    }

    public int gameTurn(int teamName){
        System.out.printf("%nCurrent Turn is of %d Team %n", teamName);
        int totalRuns = 0;
        int totalWickets = 0;
//        int overs = 0;

        for (overs = 0; overs < TOTALOVERS; overs++){

            int outcome = playBall();

//            Value 7 is for 'Wicket'
            if(outcome == 7){
                if(teamName == 1)
                currTeam1Player++;
                else currTeam2Player++;
/*
                if(teamName == 1)
                System.out.printf("The Player of Team 2 scored %d wicket%n", 1);
                else
                System.out.printf("The Player of Team 1 scored %d wicket%n", 1);
*/
                if( teamName == 1) {
                    team2.get(currTeam2Player).addWickets(1);
                } else
                    team1.get(currTeam2Player).addWickets(1);

                totalWickets++;

                if(teamName == 1 && currTeam1Player == 10){
                    System.out.printf("The Turn of Team 1 Ended %n");
                    break;
                }
                if(teamName == 2 && currTeam2Player == 10){
                    System.out.printf("The Turn of Team 2 Ended %n");
                    break;
                }

            }
            else{

        if (teamName == 1) {
        //  System.out.printf("The Player %d scored %d runs%n", currTeam1Player + 1, outcome);
          team1.get(currTeam1Player).addRuns(outcome);
        }
        else{
         //   System.out.printf("The Player %d scored %d runs%n", currTeam2Player + 1, outcome);
            team2.get(currTeam2Player).addRuns(outcome);
        }
                totalRuns += outcome;
        if(!scores.isEmpty() && totalRuns > scores.get(0)){
            System.out.printf("The score of Team %d is %d-%d %n", teamName, totalRuns, totalWickets);
            return totalRuns;
        }

            }
        }

        System.out.printf("The score of Team %d is %d-%d %n", teamName, totalRuns, totalWickets);
        scores.add(totalRuns);
        return totalRuns;

    }

}

class CricketGame{


    public static void playGame(){
        Match match1 = new Match();

        int score1 = match1.gameTurn(1);
        int score2 = match1.gameTurn(2);
//        System.out.println("The Cricket Game ended");

        if(score1 > score2){
            System.out.printf("%nTeam 1 Won the Match");
        }
        else if(score1 == score2){
            System.out.printf("%nThe Match is Tied");

        }
        else{
            System.out.printf("%nTeam 2 Won the Match");

        }
    }

}

// MatchController Class to start the game
class Main {
  public static void main(String[] args) {

//      CricketGame cg = new CricketGame();
      CricketGame.playGame();

  }
}
