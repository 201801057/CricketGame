package com.tekion.cricket.model;

import com.tekion.cricket.configurations.MatchController;


public class CricketGame {

  public static void startGame() {
    final int TOTAL_MATCHES = 1;

    for (int i = 0; i < TOTAL_MATCHES; i++) MatchController.playGame();
    }
}