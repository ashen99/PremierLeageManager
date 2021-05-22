package com.w1761344.oop.cw;

import java.io.Serializable;
import java.util.Objects;

public class SportsClub implements Serializable {
    private static final long serialVersionUID = 1L;
    private String clubName;
    private String clubLocation;
    private String nameOfOwner;

    public SportsClub(String clubName, String clubLocation,String nameOfOwner) {
        this.clubName = clubName;
        this.clubLocation = clubLocation;
        this.nameOfOwner = nameOfOwner;
    }

    public String getClubName() {
        return clubName;
    }

    public String getClubLocation() {
        return clubLocation;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsClub that = (SportsClub) o;
        return Objects.equals(clubName, that.clubName) &&
                Objects.equals(clubLocation, that.clubLocation) &&
                Objects.equals(nameOfOwner, that.nameOfOwner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clubName, clubLocation, nameOfOwner);
    }

}