package com.company;

class MatchController{

    private MatchController(){}

    public static void playGame(){
        Match match1 = new Match();

        int score1 = match1.gameTurn(1);
        int score2 = match1.gameTurn(2);

        Scoreboard.appendScoreboard(match1);

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
