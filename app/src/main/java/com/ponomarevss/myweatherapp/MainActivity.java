package com.ponomarevss.myweatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton settings = findViewById(R.id.settings_button);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        String instanceState;
        if (savedInstanceState == null) {
            instanceState = "Первый запуск! ";
        }
        else {
            instanceState = "Повторный запуск! ";
        }

        logInstanceState(instanceState + "MainActivity - onCreate()");
    }

    private void logInstanceState(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
        Log.d("log", s);
    }

    @Override
    protected void onStart() {
        super.onStart();
        logInstanceState("MainActivity - onStart()");
    }
    @Override
    protected void onResume() {
        super.onResume();
        logInstanceState("MainActivity - onResume()");
    }
    @Override
    protected void onPause() {
        super.onPause();
        logInstanceState("MainActivity - onPause()");
    }
    @Override
    protected void onStop() {
        super.onStop();
        logInstanceState("MainActivity - onStop()");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        logInstanceState("MainActivity - onRestart()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        logInstanceState("MainActivity - onDestroy()");
    }
/*
    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
        logInstanceState("Повторный запуск! - MainActivity - onRestoreInstanceState()");
    }
    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        logInstanceState("MainActivity - onSaveInstanceState()");
    }
*/
}
