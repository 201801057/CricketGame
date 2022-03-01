package com.tekion.cricket.dto;

import com.tekion.cricket.model.PlayerType;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class PlayerDTO {
    @Id
    private String playerID;
    private PlayerType type ;
    private int runs;
    private int wickets;
    private int noOfBallsPlayed;
    private int noOfFours;
    private int noOfSixes;
    private int noOfOvers;
    private int runsGiven;
    private String name;

    private int maidenOvers;
    private int rating;
}
