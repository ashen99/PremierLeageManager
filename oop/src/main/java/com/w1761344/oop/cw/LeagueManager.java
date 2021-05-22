package com.w1761344.oop.cw;

import java.io.IOException;
import java.util.List;

public interface LeagueManager {

    void createClub();
    void deleteClub();
    void displayStats();
    void showTable();
    void addMatch();
    void saveFile();
    void saveFile2();
    void loadFile() throws IOException, ClassNotFoundException;
    void loadFile2() throws IOException, ClassNotFoundException;
    List<FootballClub> Pointsshow();
    List<FootballClub> goalsScored();
    List<FootballClub> winsShow();
    List<Match> matches();
    List<Match> randomMatch();
}
