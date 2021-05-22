package com.w1761344.oop.cw;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class PremierLeagueManager implements LeagueManager {
    private static ArrayList<FootballClub> listOfClubs = new ArrayList<>();   //creating a arraylist to add football clubs
    private static ArrayList<Match> matchlist = new ArrayList<>();            //creating a arraylist to add played matches with details.



    @Override
    public void createClub() {    //creating a club
        Scanner sc = new Scanner(System.in);
        System.out.println("===Adding a club to the league===");
        System.out.println(" ");
        String regex = "^[a-zA-Z]+$";

        System.out.println("Enter the club name: ");  //entering the club name
        String cName= sc.next().toLowerCase();
        while (true){  //validating user inputs. user cant enter numbers.
            if (cName.matches(regex)){
                break;
            }
            else {
                System.out.println("Invalid input.");
                System.out.println("Enter the club name: ");
                cName= sc.next();
            }

        }
        System.out.println(" ");

        System.out.println("Enter the location of the club: ");  //location of the club
        String cLocation= sc.next().toLowerCase();
        while (true){  //validating user inputs. user cant enter numbers.
            if (cLocation.matches(regex)){
                break;
            }
            else {
                System.out.println("Invalid input.");
                System.out.println("Enter the club location: ");
                cLocation= sc.next();
            }

        }
        System.out.println(" ");

        System.out.println("Enter the Owner of the club: ");  //owner of the club.
        String owner = sc.next().toLowerCase();
        while (true){  //validating user inputs. user cant enter numbers.
            if (owner.matches(regex)){
                break;
            }
            else {
                System.out.println("Invalid input.");
                System.out.println("Enter the Owner of the club: ");
                owner= sc.next();
            }
        }
        System.out.println(" ");

        while (true) {     //checking if the name is already in the list
            int num = 0;   //if this num got increase the club already exsists.
            for (FootballClub club : listOfClubs) {
                if (cName.equals(club.getClubName())) {
                    System.out.println("this club already exists.");
                    System.out.println("Enter the club name: ");
                    cName = sc.next();
                    num++;
                }
            }
            if (num == 0) {
                break;
            }
        }

        FootballClub ftballclub = new FootballClub(cName,cLocation,owner);  //creating a new object for footballclub
        if (listOfClubs.contains(ftballclub)) {
            System.out.println("this club is already created.");
        } else {
            listOfClubs.add(ftballclub);
        }
    }

    @Override
    public void deleteClub() {   //deleting a club
        System.out.println("===to delete a club enter the club name below===");

        if (listOfClubs.isEmpty()){    //checking if the arraylist is empty
            System.out.println("there are no clubs to remove. add some clubs.");
        }
        else {
            int indexOfClub = indexOfClubs("Club name");
            listOfClubs.remove(indexOfClub);    //removing the club from the list
            System.out.println("Club deleted");
        }
    }
    @Override
    public void displayStats() {  //displaying the statistics of a club

        if (!listOfClubs.isEmpty()){  //checking if the club is empty
            int indexOfClub  = indexOfClubs("===Displaying the statistics of the club===\n");  //getting the index of the club
            System.out.println(" ");
            System.out.println("Name :"+listOfClubs.get(indexOfClub).getClubName());
            System.out.println("location :"+listOfClubs.get(indexOfClub).getClubLocation());
            System.out.println("owner :"+listOfClubs.get(indexOfClub).getNameOfOwner());
            System.out.println("wins :"+listOfClubs.get(indexOfClub).getWins());
            System.out.println("defeats :"+listOfClubs.get(indexOfClub).getDefeats());
            System.out.println("draws :"+listOfClubs.get(indexOfClub).getDraws());
            System.out.println("goals scored :"+listOfClubs.get(indexOfClub).getNumOfGoalsScored());
            System.out.println("goals recived :"+listOfClubs.get(indexOfClub).getNumOfGoalsRecived());
            System.out.println("number of matches :"+listOfClubs.get(indexOfClub).getNumberOfMatches());
            System.out.println("points :"+listOfClubs.get(indexOfClub).getPoints());
            System.out.println("Goals difference :"+listOfClubs.get(indexOfClub).getGoalDifference());
            System.out.println(" ");
        }
        else {
            System.out.println("There are no Clubs.");
        }
    }


    @Override
    public void showTable() {   //displaying all the clubs that are in premier league
        Collections.sort(listOfClubs);
        if (!listOfClubs.isEmpty()) {   //checking if the arraylist is empty
            for (FootballClub footballClub : listOfClubs) {
                System.out.println("========================");
                System.out.println("club name  : " + footballClub.getClubName());
                System.out.println("club location  : " + footballClub.getClubLocation());
                System.out.println("goals scored  : " + footballClub.getNumOfGoalsScored());
                System.out.println("goals recived  : " + footballClub.getNumOfGoalsRecived());
                System.out.println("points  : " + footballClub.getPoints());
                System.out.println("wins  : " + footballClub.getWins());
                System.out.println("defeats  : " + footballClub.getDefeats());

            }
        }
        else {
            System.out.println("There are no clubs in premier League. \n");
        }
    }

    @Override
    public void addMatch() {   //adding a match to preamier league manualy
        Scanner sc = new Scanner(System.in);
        if (listOfClubs.size()>1){      //checking whether there are at least two clubs.
            System.out.println("====ADDING A PLAYED MATCH===\n");

            System.out.println("====setting the match date===");  //getting the date
            int year;
            LocalDate currentDate = LocalDate.now();
            first:
            while (true) {   //validating the year
                try {
                    System.out.println("YEAR    : ");
                    year = sc.nextInt();
                    second:
                    while (true) {
                        if (year <= currentDate.getYear()) {
                            break second;
                        } else {
                            System.out.println("you can't add a future year. Try again!");
                            System.out.println("YEAR   : ");
                            year = sc.nextInt();
                        }
                    }
                    break first;
                } catch (Exception e) {
                    sc.next();
                    System.out.println("You need to enter valid year");
                    continue;
                }
            }

            //validating the month
            int month;
            mnth:
            while (true) {
                try {
                    System.out.println("MONTH   : ");
                    month = sc.nextInt();
                    twoW:
                    while (true) {
                        if (month >= 1 && month <= 12) {
                            break twoW;
                        } else {
                            System.out.println("Enter a valid month.");
                            System.out.println("MONTH   : ");
                            month = sc.nextInt();
                        }
                    }
                    break mnth;
                } catch (Exception e) {
                    sc.next();
                    System.out.println("you need to enter a valid month.");
                    continue ;
                }
            }

            //validating the date
            int day;
            dayy:
            while (true) {
                System.out.println("DAY     : ");
                day = sc.nextInt();
                try {
                    wOne:
                    while (true) {
                        if (day >= 1 && day <= 31) {
                            break wOne;
                        } else {
                            System.out.println("Enter a valid date.");
                            System.out.println("DAY   : ");
                            day = sc.nextInt();
                        }
                    }
                    break dayy;
                } catch (Exception e) {
                    sc.next();
                    System.out.println("you need to enter a valid day");
                    continue ;
                }
            }

            Date date = new Date(year,month,day);  //creating a new date
            System.out.println(date);
            System.out.println(" ");


            int indexOfTeam1 = indexOfClubs("Team One ");  //getting the index of team 1
            int indexOfTeam2 = 0;
            while (true){
                indexOfTeam2 = indexOfClubs("Team two ");  //getting the index of team2
                if (indexOfTeam1 == indexOfTeam2){                 //checking whether two clubs are the same.
                    System.out.println("club name already entered.");
                    continue;
                }
                else{
                    break;
                }
            }
            String cname1 = listOfClubs.get(indexOfTeam1).getClubName();   //getting the name of first team into a string
            String cname2 = listOfClubs.get(indexOfTeam2).getClubName();   //getting the name of second team into a string

            System.out.println("Goals of Team one : ");      //getting the number of goals scored by team 1
            int gs1 = sc.nextInt();

            System.out.println("Goals of Team two : ");      //getting the number of goals scored by team 2
            int gs2 = sc.nextInt();

            Match match = new Match(cname1,cname2,gs1,gs2,date,year,month,day);  //creating a new match object
            matchlist.add(match);                                //adding the match into match arraylist

            if (gs1 == gs2){                  //checking if the match was a draw
                listOfClubs.get(indexOfTeam1).setDraws();     //setting match results
                listOfClubs.get(indexOfTeam2).setDraws();
                listOfClubs.get(indexOfTeam1).setNumOfGoalsScored(gs1);
                listOfClubs.get(indexOfTeam2).setNumOfGoalsScored(gs2);
                listOfClubs.get(indexOfTeam1).setNumOfGoalsRecived(gs2);
                listOfClubs.get(indexOfTeam2).setNumOfGoalsRecived(gs1);
            }
            else if(gs1 > gs2){             //checking if the team 1 won
                listOfClubs.get(indexOfTeam1).setWins(gs1,gs2);
                listOfClubs.get(indexOfTeam2).setDefeats(gs2,gs1);
                listOfClubs.get(indexOfTeam1).setNumOfGoalsScored(gs1);
                listOfClubs.get(indexOfTeam2).setNumOfGoalsScored(gs2);
                listOfClubs.get(indexOfTeam1).setNumOfGoalsRecived(gs2);
                listOfClubs.get(indexOfTeam2).setNumOfGoalsRecived(gs1);
            }
            else {                      //if the team 2 won
                listOfClubs.get(indexOfTeam2).setWins(gs2,gs1);
                listOfClubs.get(indexOfTeam1).setDefeats(gs1,gs2);
                listOfClubs.get(indexOfTeam1).setNumOfGoalsScored(gs1);
                listOfClubs.get(indexOfTeam2).setNumOfGoalsScored(gs2);
                listOfClubs.get(indexOfTeam1).setNumOfGoalsRecived(gs2);
                listOfClubs.get(indexOfTeam2).setNumOfGoalsRecived(gs1);
            }
        }
        else if (listOfClubs.isEmpty()){    //checking if the list is empty
            System.out.println("there are no clubs.");
        }
        else {   //checking if there is only one club
            System.out.println("there is only one club");
        }
    }

    private int indexOfClubs(String clubname) {   //getting the index of the entered club
        Scanner sc = new Scanner(System.in);
        int num = 0;      //using this to break from the loop
        int indexofclub = 0;  //getting index of the club to a int
        System.out.println(clubname);
        String regex = "^[a-zA-Z]+$";
        first:
        while (true) {
            System.out.println("Enter the club name: ");
            String cname = sc.next().toLowerCase();
            second:
            while (true){
                if (cname.matches(regex)){     //validating the input
                    break;
                }else {
                    System.out.println("Invalid Input");
                    System.out.println("Enter the club name: ");
                    cname = sc.next();
                }

            }
            for (FootballClub footballClub : listOfClubs) {      //if the club is in the list it will break
                if (footballClub.getClubName().equals(cname)) {
                    indexofclub = listOfClubs.indexOf(footballClub);
                    num++;
                }
            }
            if (num > 0){
                break;
            } else {
                System.out.println("Club not found");
                continue;
            }
        }
        return indexofclub;  //getting the index of entered club as a int
    }



    @Override
    public void saveFile() {   //saving list of clubs to a text file
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("allclubs.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (FootballClub club : listOfClubs) {
                objectOutputStream.writeObject(club);
            }
            objectOutputStream.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void saveFile2() {   //saving list of clubs to a text file
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("allmatch.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (Match match : matchlist) {
                objectOutputStream.writeObject(match);
            }
            objectOutputStream.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadFile() throws IOException {   //loading from the club list txt file
        try {
            FileInputStream fileInputStream = new FileInputStream("allclubs.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            for (; ; ) {
                try {
                    listOfClubs.add((FootballClub) objectInputStream.readObject());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println();
        } catch (EOFException e) {
            System.out.println();
        }
    }

    @Override
    public void loadFile2() throws IOException {   //loading from the club list txt file
        try {
            FileInputStream fileInputStream = new FileInputStream("allmatch.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            for (; ; ) {
                try {
                    matchlist.add((Match) objectInputStream.readObject());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println();
        } catch (EOFException e) {
            System.out.println();
        }
    }

    //creating a method to return arraylist listed according to points to send arraylist to angular
    @Override
    public List<FootballClub> Pointsshow(){
        Collections.sort(listOfClubs, Comparator.comparingInt(FootballClub::getPoints).reversed());
        return listOfClubs;
    }

    //creating a method to return arraylist listed according to goals scored to send arraylist to angular
    @Override
    public List<FootballClub> goalsScored(){
        Collections.sort(listOfClubs, Comparator.comparingInt(FootballClub::getNumOfGoalsScored).reversed());
        return listOfClubs;
    }

    //creating a method to return arraylist listed according to highest wins to send arraylist to angular
    @Override
    public List<FootballClub> winsShow(){
        Collections.sort(listOfClubs, Comparator.comparingInt(FootballClub::getWins).reversed());
        return listOfClubs;
    }

    //creating a method to return match arraylist to send arraylist to angular
    @Override
    public List<Match> matches(){
        Collections.sort(matchlist);
        return matchlist;
    }

    //generating a random match
    @Override
    public List<Match> randomMatch(){

        ArrayList<Match> randomMatches = new ArrayList<>();
        randomMatches.clear();
        //getting random 2 clubs by generating two numbers as indexes.
        Random randNum = new Random();
        Set<Integer> set = new LinkedHashSet<Integer>();
        while (set.size() < 2) {
            set.add(randNum.nextInt(listOfClubs.size()));
        }

        //converting linkedHashset into a arraylist to get indexes into integers.
        ArrayList<Integer> elements = new ArrayList<>(set);
        int team1 = elements.get(0);
        int team2 = elements.get(1);


        //goals scored by team one
        Random rand = new Random();
        int team1gs = rand.nextInt(50);

        //goals scored by team two
        int team2gs = rand.nextInt(50);

        System.out.println("match added\n");

        //checking who won the match or whether its is draw match
        if (team1gs == team2gs){
            listOfClubs.get(team1).setDraws();
            listOfClubs.get(team2).setDraws();
            listOfClubs.get(team1).setNumOfGoalsScored(team1gs);
            listOfClubs.get(team2).setNumOfGoalsScored(team2gs);
            listOfClubs.get(team1).setNumOfGoalsRecived(team2gs);
            listOfClubs.get(team2).setNumOfGoalsRecived(team1gs);
            System.out.println("match was drawn"+"\n");
        }
        else if(team1gs > team2gs){  //if the team 1 won
            listOfClubs.get(team1).setWins(team1gs,team1gs);
            listOfClubs.get(team2).setDefeats(team2gs,team1gs);
            listOfClubs.get(team1).setNumOfGoalsScored(team1gs);
            listOfClubs.get(team2).setNumOfGoalsScored(team2gs);
            listOfClubs.get(team1).setNumOfGoalsRecived(team2gs);
            listOfClubs.get(team2).setNumOfGoalsRecived(team1gs);
            System.out.println("match was won by "+listOfClubs.get(team1).getClubName()+"\n");
        }
        else {  //if the team 2 won
            listOfClubs.get(team2).setWins(team2gs,team1gs);
            listOfClubs.get(team1).setDefeats(team1gs,team2gs);
            listOfClubs.get(team1).setNumOfGoalsScored(team1gs);
            listOfClubs.get(team2).setNumOfGoalsScored(team2gs);
            listOfClubs.get(team1).setNumOfGoalsRecived(team2gs);
            listOfClubs.get(team2).setNumOfGoalsRecived(team1gs);
            System.out.println("match was won by "+listOfClubs.get(team2).getClubName()+"\n");
        }

        //adding the date when generated a random match.
        LocalDate currentDate = LocalDate.now();
        Date date = new Date(currentDate.getYear(),currentDate.getMonthValue(),currentDate.getDayOfMonth());

        //creating a new match and adding it into a new list.
        Match match = new Match(listOfClubs.get(team1).getClubName(),listOfClubs.get(team2).getClubName(),team1gs,team2gs,date,currentDate.getYear(),currentDate.getMonthValue(),currentDate.getDayOfMonth());
        matchlist.add(match);
        randomMatches.add(match);

        System.out.println("===Match summary===");   //displaying match summary in the console
        System.out.println("Team 1 = "+listOfClubs.get(team1).getClubName()+ "|| goals scored : "+team1gs);
        System.out.println("Team 2 = "+listOfClubs.get(team2).getClubName()+ "|| goals scored : "+team2gs);
        System.out.println("Match date = "+currentDate+"\n");
        Collections.sort(matchlist);

        return randomMatches;
    }


}