package com.ponomarevss.myweatherapp;

import java.io.Serializable;

public class Parcel implements Serializable {

    private String place;
    private boolean windChecked;
    private boolean humidityChecked;
    private boolean pressureChecked;

    public Parcel(String place, boolean windChecked, boolean humidityChecked, boolean pressureChecked) {
        this.place = place;
        this.windChecked = windChecked;
        this.humidityChecked = humidityChecked;
        this.pressureChecked = pressureChecked;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public boolean isWindChecked() {
        return windChecked;
    }

    public void setWindChecked(boolean windChecked) {
        this.windChecked = windChecked;
    }

    public boolean isHumidityChecked() {
        return humidityChecked;
    }

    public void setHumidityChecked(boolean humidityChecked) {
        this.humidityChecked = humidityChecked;
    }

    public boolean isPressureChecked() {
        return pressureChecked;
    }

    public void setPressureChecked(boolean pressureChecked) {
        this.pressureChecked = pressureChecked;
    }

}

