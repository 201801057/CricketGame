package com.tekion.cricket.dto;

import com.tekion.cricket.model.Player;
import lombok.Data;
import org.springframework.data.annotation.Id;
import java.util.ArrayList;

@Data
public class TeamDTO {
    @Id
    private String teamID;
    private ArrayList<Player> playersInfo = new ArrayList<>(11);
    private int totalScore;
    private int totalWickets;
    private int currPlayer;
}
