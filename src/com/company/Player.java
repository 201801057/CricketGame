package com.company;


// ID, Type, Rating
class Player{
    private static int count = 0;
    private int playerID;
    private PlayerType type ;
    private int runs;
    private int wickets;
    private int noOfBallsPlayed;
    private int noOfFours;
    private int noOfSixes;
    private int noOfOvers;
    private int runsGiven;

    private int maidenOvers;
    private int rating;


    public Player(){
        count++;
        this.playerID = count;
        this.runs = 0;
        this.wickets = 0;
        this.noOfBallsPlayed = 0;
        this.noOfFours = 0;
        this.noOfSixes = 0;
        this.noOfOvers = 0;
        this.maidenOvers = 0;
        this.runsGiven = 0;
    }
    public Player(PlayerType type){
        count++;
        this.playerID = count;
        this.runs = 0;
        this.wickets = 0;
        this.noOfBallsPlayed = 0;
        this.noOfFours = 0;
        this.noOfSixes = 0;
        this.noOfOvers = 0;
        this.runsGiven = 0;
        this.maidenOvers = 0;
        this.type = type;
    }

    public int getPlayerID(){
        return  playerID;
    }
    public int getNoOfBallsPlayed() {
        return noOfBallsPlayed;
    }

    public void addNoOfBallsPlayed(int noOfBallsPlayed) {
        this.noOfBallsPlayed += noOfBallsPlayed;
    }

    public int getNoOfFours() {
        return noOfFours;
    }

    public void addNoOfFours(int noOfFours) {
        this.noOfFours += noOfFours;
    }

    public int getNoOfSixes() {
        return noOfSixes;
    }

    public void addNoOfSixes(int noOfSixes) {
        this.noOfSixes += noOfSixes;
    }

    public int getNoOfOvers() {
        return noOfOvers;
    }

    public void addNoOfOvers(int noOfOvers) {
        this.noOfOvers += noOfOvers;
    }

    public int getRunsGiven() {
        return runsGiven;
    }

    public void addRunsGiven(int runsGiven) {
        this.runsGiven += runsGiven;
    }

    public int getMaidenOvers() {
        return maidenOvers;
    }

    public void addMaidenOvers(int maidenOvers) {
        this.maidenOvers += maidenOvers;
    }

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

    public int getBoundaries(){
        return this.noOfFours + this.noOfSixes;
    }
}

