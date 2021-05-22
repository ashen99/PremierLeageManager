package com.w1761344.oop.cw;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class RunApp {

    PremierLeagueManager premierLeagueManager= new PremierLeagueManager();

    @GetMapping("/pointsTable")
    public List<FootballClub> getClubs() {
        return premierLeagueManager.Pointsshow();
    }

    @GetMapping("/goalsTable")
    public List<FootballClub> getGoalScored(){
        return premierLeagueManager.goalsScored();
    }

    @GetMapping("/winsTable")
    public List<FootballClub> getWins(){
        return premierLeagueManager.winsShow();
    }

    @GetMapping("/matches")
    public List<Match> getmatches(){
        return premierLeagueManager.matches();
    }

    @GetMapping("/randomMatch")
    public List<Match> randMatch(){
        return premierLeagueManager.randomMatch();
    }

}
