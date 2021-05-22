package com.w1761344.oop;


import com.w1761344.oop.cw.PremierLeagueManager;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Scanner;


@SpringBootApplication
@RestController
public class OopcwApplication{
    private static PremierLeagueManager PleagueManager = new PremierLeagueManager();

    public static void main(String[] args) throws IOException {
        SpringApplication.run(OopcwApplication.class);

        System.out.println("=====welcome to premier league Manager=====\n");
        System.out.println("");
        Scanner sc = new Scanner(System.in);

        PleagueManager.loadFile();
        PleagueManager.loadFile2();

        menu:
        while (true) {
            System.out.println("Enter 'A' to add a club to the league:");
            System.out.println("Enter 'D' to delete a club from the league:");
            System.out.println("Enter 'P' to see statistics of a club:");
            System.out.println("Enter 'T' to display the Premier League table:");
            System.out.println("Enter 'M' to add a played match:");
            System.out.println("Enter 'S' to save to a file:");
            System.out.println("Enter 'G' to open GUI");
            System.out.println("Enter 'E' to Exit the programme:");

            String option = sc.next().toUpperCase();
            switch (option) {
                case ("A"):
                    PleagueManager.createClub();
                    break;

                case ("D"):
                    PleagueManager.deleteClub();
                    break;
                case ("P"):
                    PleagueManager.displayStats();
                    break;

                case ("T"):
                    PleagueManager.showTable();
                    break;

                case ("M"):
                    PleagueManager.addMatch();
                    break;

                case ("S"):
                    System.out.println("SAVED SUCCESSFUL");
                    PleagueManager.saveFile();
                    PleagueManager.saveFile2();
                    break;

                case ("G"):
                    Runtime runtime = Runtime.getRuntime();
                    runtime.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:4200");
                    break;

                case ("E"):
                    System.out.println("programme stopped");
                    break menu;

                default:
                    System.out.println("invalid input.enter again.");

            }
        }
    }


//    @Override
//    public void start(Stage primaryStage) throws IOException {}
}
