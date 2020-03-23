package com.ponomarevss.myweatherapp;

import java.io.Serializable;

public class Parcel implements Serializable {

    private String place;
    private boolean pressureVisibility;
    private boolean windVisibility;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public boolean isPressureVisible() {
        return pressureVisibility;
    }

    public void setPressureVisibility(boolean pressureVisibility) {
        this.pressureVisibility = pressureVisibility;
    }

    public boolean isWindVisible() {
        return windVisibility;
    }

    public void setWindVisibility(boolean windVisibility) {
        this.windVisibility = windVisibility;
    }
}
