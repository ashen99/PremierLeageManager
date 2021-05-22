package com.w1761344.oop.cw;

public class SchoolFootballClub extends FootballClub {
    private static final long serialVersionUID = 1L;
    private String schoolName;



    public SchoolFootballClub(String schoolName,String clubName,String clubLocation,String nameOfOwner) {
        super(clubName,clubLocation,nameOfOwner);
        this.schoolName=schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }


    @Override
    public String toString() {
        return "SchoolFootballClub{" + super.toString()+
                "schoolName='" + schoolName + '\'' +
                '}';
    }
}