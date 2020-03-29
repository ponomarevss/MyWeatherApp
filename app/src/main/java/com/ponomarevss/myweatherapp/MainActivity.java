package com.ponomarevss.myweatherapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.ponomarevss.myweatherapp.Constants.RESULT;
import static com.ponomarevss.myweatherapp.Constants.SETTINGS;

public class MainActivity extends AppCompatActivity {

    public final static int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ImageButton settings = findViewById(R.id.settings_button);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView place = findViewById(R.id.place);
                LinearLayout wind = findViewById(R.id.wind_layout);
                LinearLayout humidity = findViewById(R.id.humidity_layout);
                LinearLayout pressure = findViewById(R.id.pressure_layout);
                Parcel parcel = new Parcel();
                parcel.setPlace(place.getText().toString());
                parcel.setWindVisibility(wind.getVisibility());
                parcel.setHumidityVisibility(humidity.getVisibility());
                parcel.setPressureVisibility(pressure.getVisibility());
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                intent.putExtra(SETTINGS, parcel);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        //создаем блок почасовой погоды
        final String[] hours = getResources().getStringArray(R.array.hours);
        LinearLayout hourlyLayout = findViewById(R.id.hourly_layout);
        LayoutInflater hoursInflater = getLayoutInflater();

        for (int i = 0; i < hours.length; i++) {
            final String hour = hours[i];
            View view = hoursInflater.inflate(R.layout.hour_layout, hourlyLayout, false);
            TextView hourTextView = view.findViewById(R.id.hour_value);
            hourTextView.setText(hour);
            hourlyLayout.addView(view);
        }

        //создаем блок трехдневного прогноза
        final String[] days = getResources().getStringArray(R.array.days);
        LinearLayout threeDaysForecastLayout = findViewById(R.id.three_days_forecast_layout);
        LayoutInflater daysInflater = getLayoutInflater();

        for (int i = 0; i < days.length; i++) {
            final String day = days[i];
            View view = daysInflater.inflate(R.layout.day_layout, threeDaysForecastLayout, false);
            TextView hourTextView = view.findViewById(R.id.day_text);
            hourTextView.setText(day);
            threeDaysForecastLayout.addView(view);
        }


        TextView moreInfo = findViewById(R.id.more_info);
        moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = getResources().getString(R.string.url);
                Uri uri = Uri.parse(url);
                Intent browser = new Intent(Intent.ACTION_VIEW, uri);
                ActivityInfo activityInfo = browser.resolveActivityInfo(getPackageManager(), browser.getFlags());
                if (activityInfo != null) {
                    startActivity(browser);
                }
            }
        });

        TextView lastPlaces = findViewById(R.id.last_places);
        lastPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Открываем коллекцию мест", Toast.LENGTH_SHORT).show();
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

        logInstanceState(instanceState + "MainActivity - onCreate()");
*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Parcel parcel = (Parcel) data.getExtras().getSerializable(RESULT);
            TextView place = findViewById(R.id.place);
            LinearLayout wind = findViewById(R.id.wind_layout);
            LinearLayout humidity = findViewById(R.id.humidity_layout);
            LinearLayout pressure = findViewById(R.id.pressure_layout);
            place.setText(parcel.getPlace());
            wind.setVisibility(parcel.getWindVisibility());
            humidity.setVisibility(parcel.getHumidityVisibility());
            pressure.setVisibility(parcel.getPressureVisibility());
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

/*
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
*/
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
