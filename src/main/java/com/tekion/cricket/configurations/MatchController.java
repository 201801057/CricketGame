package com.tekion.cricket.configurations;


import com.tekion.cricket.model.Match;
import com.tekion.cricket.model.Scoreboard;
import org.springframework.stereotype.Component;

@Component
public class MatchController{


    public static void playGame(){
        Match match1 = new Match();

        int score1 = match1.gameTurn(1);
        Match.setZeroRunBallsCount(0);
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