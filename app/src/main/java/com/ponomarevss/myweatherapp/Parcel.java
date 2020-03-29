package com.ponomarevss.myweatherapp;

import android.view.View;

import java.io.Serializable;

public class Parcel implements Serializable {

    private String place;
    private boolean windVisible;
    private boolean humidityVisible;
    private boolean pressureVisible;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getWindVisibility() {
        return getVisibility(windVisible);
    }

    public boolean isWindVisible() {
        return windVisible;
    }

    public void setWindVisibility(int windVisibility) {
        windVisible = windVisibility == View.VISIBLE;
    }

    public void setWindVisibility(boolean isWindVisible) {
        windVisible = isWindVisible;
    }

    public int getHumidityVisibility() {
        return getVisibility(humidityVisible);
    }

    public boolean isHumidityVisible() {
        return humidityVisible;
    }

    public void setHumidityVisibility(int humidityVisibility) {
        humidityVisible = humidityVisibility == View.VISIBLE;
    }

    public void setHumidityVisibility(boolean isHumidityVisible) {
        humidityVisible = isHumidityVisible;
    }

    public int getPressureVisibility() {
        return getVisibility(pressureVisible);
    }

    public boolean isPressureVisible() {
        return pressureVisible;
    }

    public void setPressureVisibility(int pressureVisibility) {
        pressureVisible = pressureVisibility == View.VISIBLE;
    }

    public void setPressureVisibility(boolean isPressureVisible) {
        pressureVisible = isPressureVisible;
    }

    private int getVisibility(Boolean isVisible) {
        int visibility = View.GONE;
        if (isVisible) visibility = View.VISIBLE;
        return visibility;
    }
}

/*
* сеттеры: передать в парсел инт от вью, передать в парсел булинь от чекбокса
* геттеры: получить из парсела инт для вью, получить из парсела булинь для чекбокса
* */
