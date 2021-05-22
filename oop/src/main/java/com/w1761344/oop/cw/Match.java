package com.w1761344.oop.cw;

import java.io.Serializable;

public class Match implements Comparable<Match>, Serializable {
    private static final long serialVersionUID = 1L;
    private String team1name;
    private String team2name;
    private int team1GoalsScored;
    private int team2GoalsScored;
    private Date date;
    private int year;
    private int month;
    private int day;

    public Match(String team1name, String team2name,int team1GoalsScored, int team2GoalsScored,Date date,int year,int month,int day) {
        this.team1name = team1name;
        this.team2name = team2name;
        this.team1GoalsScored = team1GoalsScored;
        this.team2GoalsScored = team2GoalsScored;
        this.date = date;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getTeam1name() {
        return team1name;
    }

    public void setTeam1name(String team1name) {
        this.team1name = team1name;
    }

    public String getTeam2name() {
        return team2name;
    }

    public void setTeam2name(String team2name) {
        this.team2name = team2name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTeam1GoalsScored() {
        return team1GoalsScored;
    }

    public void setTeam1GoalsScored(int team1GoalsScored) {
        this.team1GoalsScored = team1GoalsScored;
    }

    public int getTeam2GoalsScored() {
        return team2GoalsScored;
    }

    public void setTeam2GoalsScored(int team2GoalsScored) {
        this.team2GoalsScored = team2GoalsScored;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }


    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public int compareTo(Match comparematchdate){
        Date comparedate = ((Match)comparematchdate).getDate();
        if (this.getDate().getYear()-comparedate.getYear()==0){
            if (this.getDate().getMonth()-comparedate.getMonth()==0){
                return this.getDate().getDay()-comparedate.getDay();
            }else {
                return this.getDate().getMonth()-comparedate.getMonth();
            }
        }else {
            return this.getDate().getYear()-comparedate.getYear();
        }
    }

    @Override
    public String toString() {
        return "team1name='" + team1name + '\'' +
                ", team2name='" + team2name + '\'' +
                ", team1GoalsScored=" + team1GoalsScored +
                ", team2GoalsScored=" + team2GoalsScored
                 +" date: " +date + " year :"+year+" month :"+month+" day :"+day+
                '}';
    }


}
