package com.ponomarevss.myweatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import static com.ponomarevss.myweatherapp.Constants.RESULT;
import static com.ponomarevss.myweatherapp.Constants.SETTINGS;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        //начальная видимость экранов
        final ConstraintLayout settingsScreen = findViewById(R.id.settings_screen);
        final ConstraintLayout placesScreen = findViewById(R.id.places_screen);
        settingsScreen.setVisibility(View.VISIBLE);
        placesScreen.setVisibility(View.GONE);

        //получаем парсел от MainActivity
        final Parcel parcel = (Parcel) getIntent().getExtras().getSerializable(SETTINGS);

        /*Экран настроек*/

        //заголовок перехода на экран задания места
        final TextView placesScreenButton = findViewById(R.id.places_screen_button);
        placesScreenButton.setText(parcel.getPlace());
        placesScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingsScreen.setVisibility(View.GONE);
                placesScreen.setVisibility(View.VISIBLE);
            }
        });

        //чекбоксы ветра, влажности и давления
        final CheckBox wind = findViewById(R.id.wind_checkbox);
        final CheckBox humidity = findViewById(R.id.humidity_checkbox);
        final CheckBox pressure = findViewById(R.id.pressure_checkbox);
        wind.setChecked(parcel.isWindVisible());
        humidity.setChecked(parcel.isHumidityVisible());
        pressure.setChecked(parcel.isPressureVisible());

        /*Экран задания места*/

        //значение текущего места
        final TextView placeSet = findViewById(R.id.place_set);
        placeSet.setText(parcel.getPlace());


        //кнопка определения места
        final Button locate = findViewById(R.id.locate_button);
        locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SettingsActivity.this, "Определяем место", Toast.LENGTH_SHORT).show();
            }
        });

        //кнопка возврата на экран настроек
        final ImageButton backToSettingsButton = findViewById(R.id.back_to_settings_button);
        backToSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingsScreen.setVisibility(View.VISIBLE);
                placesScreen.setVisibility(View.GONE);
            }
        });

        //создаем список городов
        final String[] cities = getResources().getStringArray(R.array.cities);
        LinearLayout citiesListLayout = findViewById(R.id.cities_list_layout);
        LayoutInflater inflater = getLayoutInflater();

        for (int i = 0; i < cities.length; i++) {
            final String city = cities[i];
            View view = inflater.inflate(R.layout.city_layout, citiesListLayout, false);
            TextView tv = view.findViewById(R.id.city_textview);
            tv.setText(city);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    placeSet.setText(city);
                    placesScreenButton.setText(city);
                }
            });
            citiesListLayout.addView(view);
        }

        //кнопка возврата на MainActivity
        final ImageButton backToMainButton = findViewById(R.id.back_to_main_button);
        backToMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Parcel parcelResult = new Parcel();
                parcelResult.setPlace(placeSet.getText().toString());
                parcelResult.setWindVisibility(wind.isChecked());
                parcelResult.setHumidityVisibility(humidity.isChecked());
                parcelResult.setPressureVisibility(pressure.isChecked());
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                intent.putExtra(RESULT, parcelResult);
                setResult(RESULT_OK, intent);
                finish();
            }
        });



/*
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
*/


    }
/*
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
*/
}
