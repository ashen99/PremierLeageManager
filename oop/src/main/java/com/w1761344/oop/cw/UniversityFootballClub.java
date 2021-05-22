package com.w1761344.oop.cw;

public class UniversityFootballClub extends FootballClub {
    private static final long serialVersionUID = 1L;
    private String uniName;


    public UniversityFootballClub(String uniName,String clubName,String clubLocation,String nameOfOwner) {
        super(clubName,clubLocation,nameOfOwner);
        this.uniName = uniName;

    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }


    @Override
    public String toString() {
        return "UniversityFootballClub{" + super.toString() +
                "uniName='" + uniName + '\'' +
                '}';
    }
}