package com.w1761344.oop.cw;

public class FootballClub extends SportsClub implements Comparable<FootballClub> {
    private static final long serialVersionUID = 1L;
    private int wins = 0;
    private int defeats= 0;
    private int draws = 0;
    private int numOfGoalsScored = 0;
    private int points = 0;
    private int numOfGoalsRecived = 0;
    private int numberOfMatches = 0;
    private int goalDifference= 0;


    public FootballClub( String clubName,String clubLocation,String nameOfOwner) {
        super(clubName,clubLocation,nameOfOwner);
    }

    public FootballClub(String clubName,String clubLocation,String nameOfOwner, int wins, int defeats, int draws, int numOfGoalsScored, int points, int numOfGoalsRecived, int numberOfMatches, int goalDifference){
        super(clubName,clubLocation,nameOfOwner);
        this.wins = wins;
        this.defeats = defeats;
        this.draws = draws ;
        this.numOfGoalsScored = numOfGoalsScored;
        this.points = points;
        this.numOfGoalsRecived = numOfGoalsRecived;
        this.numberOfMatches = numberOfMatches;
        this.goalDifference = goalDifference;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int gs,int gr) {
        wins++;
        points = points + 3;
        numberOfMatches++;
        goalDifference = goalDifference + (gs-gr);
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int gs,int gr) {
        defeats++;
        numberOfMatches++;
        goalDifference = goalDifference - (gr-gs);
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws() {
        draws++;
        points = points + 1;
        numberOfMatches++;
    }

    public int getNumOfGoalsScored() {
        return numOfGoalsScored;

    }

    public void setNumOfGoalsScored(int gs) {
        numOfGoalsScored = numOfGoalsScored + gs;

    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public int getNumOfGoalsRecived() {
        return numOfGoalsRecived;
    }

    public void setNumOfGoalsRecived(int gr) {
        numOfGoalsRecived = numOfGoalsRecived + gr;
    }

    public int getPoints() {
        return points;
    }

    public int getGoalDifference() {
        return goalDifference;
    }


    @Override
    public int compareTo(FootballClub comparefootballClub) {
        int comparepoint = ((FootballClub)comparefootballClub).getPoints();
        if (comparepoint-this.points==0){
            int comparegoalDifference = ((FootballClub)comparefootballClub).goalDifference;
            return comparegoalDifference-this.goalDifference;
        }else {
            return comparepoint-this.points;
        }
    }

    @Override
    public String toString() {
        return "FootballClub{" +
                "wins=" + wins +
                ", defeats=" + defeats +
                ", draws=" + draws +
                ", numOfGoalsScored=" + numOfGoalsScored +
                ", points=" + points +
                ", numOfGoalsRecived=" + numOfGoalsRecived +
                ", numberOfMatches=" + numberOfMatches +
                ", goalDifference=" + goalDifference +
                '}';
    }
}