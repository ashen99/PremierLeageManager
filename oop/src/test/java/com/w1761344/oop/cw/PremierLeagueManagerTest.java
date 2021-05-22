package com.w1761344.oop.cw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PremierLeagueManagerTest {
    PremierLeagueManager premierLeagueManager = new PremierLeagueManager();

    @Test
    void createClub() {
        FootballClub footballClub = new FootballClub("test","sl","jon");
        premierLeagueManager.createClub();

    }

    @Test
    void deleteClub() {
        System.out.println("passed");
    }

    @Test
    void displayStats() {
    }

    @Test
    void showTable() {
    }

    @Test
    void addMatch() {
    }

    @Test
    void saveFile() {
    }

    @Test
    void saveFile2() {
    }

    @Test
    void loadFile() {
    }

    @Test
    void loadFile2() {
    }
}