package com.tekion.cricket.dto;

import com.tekion.cricket.model.Team;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class MatchDTO {
    Team team1 = new Team();
    Team team2 = new Team();

    @Id
    private String matchId;
    private static final int TOTAL_OVERS = 120;
    private static int zeroRunBallsCount;

}
