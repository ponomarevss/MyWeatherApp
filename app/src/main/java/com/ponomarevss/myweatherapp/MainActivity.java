package com.ponomarevss.myweatherapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout mainScreen;
    private ConstraintLayout settingsScreen;
    private LinearLayout locationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainScreen = findViewById(R.id.main_screen);
        settingsScreen = findViewById(R.id.settings_screen);
        locationList = findViewById(R.id.location_list);

        settingsScreen.setVisibility(View.GONE);

        ImageButton settings = findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainScreen.setVisibility(View.GONE);
                settingsScreen.setVisibility(View.VISIBLE);
            }
        });

        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingsScreen.setVisibility(View.GONE);
                mainScreen.setVisibility(View.VISIBLE);
            }
        });

        Button setLocation = findViewById(R.id.set_location);
        setLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationList.setVisibility(View.VISIBLE);
                settingsScreen.setVisibility(View.GONE);
            }
        });
    }
}
