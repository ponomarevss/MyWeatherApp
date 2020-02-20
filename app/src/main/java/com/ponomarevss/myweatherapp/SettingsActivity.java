package com.ponomarevss.myweatherapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class SettingsActivity extends AppCompatActivity {

    private ConstraintLayout settingsScreen;
    private ConstraintLayout setPlaceScreen;
    private int counter = 0;
    private TextView textCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        settingsScreen = findViewById(R.id.settings_screen);
        setPlaceScreen = findViewById(R.id.set_place);

        setScreensVisibility(View.VISIBLE, View.GONE);

        Button setPlaceButton = findViewById(R.id.set_place_button);
        setPlaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setScreensVisibility(View.GONE, View.VISIBLE);
            }
        });

        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setScreensVisibility(View.VISIBLE, View.GONE);
            }
        });

        String instanceState;
        if (savedInstanceState == null) {
            instanceState = "Первый запуск! ";
        }
        else {
            instanceState = "Повторный запуск! ";
        }
        logInstanceState(instanceState + "SettingsActivity - onCreate()");
        textCounter = findViewById(R.id.textCounter);
        textCounter.setText(((Integer)counter).toString());
        Button increment = findViewById(R.id.increment);
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                textCounter.setText(((Integer)counter).toString());
            }
        });


    }
    private void logInstanceState(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
        Log.d("log", s);
    }

    private void setScreensVisibility(int settings, int setPlace) {
        settingsScreen.setVisibility(settings);
        setPlaceScreen.setVisibility(setPlace);
    }
    @Override
    protected void onStart() {
        super.onStart();
        logInstanceState("SettingsActivity - onStart()");
    }
    @Override
    protected void onResume() {
        super.onResume();
        logInstanceState("SettingsActivity - onResume()");
    }
    @Override
    protected void onPause() {
        super.onPause();
        logInstanceState("SettingsActivity - onPause()");
    }
    @Override
    protected void onStop() {
        super.onStop();
        logInstanceState("SettingsActivity - onStop()");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        logInstanceState("SettingsActivity - onRestart()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        logInstanceState("SettingsActivity - onDestroy()");
    }
    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
        logInstanceState("Повторный запуск! - SettingsActivity - onRestoreInstanceState()");

        counter = saveInstanceState.getInt("Counter");
        textCounter.setText(((Integer)counter).toString());

    }
    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        logInstanceState("SettingsActivity - onSaveInstanceState()");

        saveInstanceState.putInt("Counter", counter);
    }
}
