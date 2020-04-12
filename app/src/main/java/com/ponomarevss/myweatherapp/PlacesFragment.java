package com.ponomarevss.myweatherapp;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import static com.ponomarevss.myweatherapp.Constants.PARCEL;

public class PlacesFragment extends Fragment {

    private Parcel parcel;
    private TextView placeTextView;
    private CheckBox windCheckBox;
    private CheckBox humidityCheckBox;
    private CheckBox pressureCheckBox;

    public PlacesFragment() {
        // Required empty public constructor
    }

    static PlacesFragment newInstance(Parcel parcel) {
        PlacesFragment fragment = new PlacesFragment();
        Bundle args = new Bundle();
        args.putSerializable(PARCEL, parcel);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            parcel = (Parcel) getArguments().getSerializable(PARCEL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_places, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        placeTextView = view.findViewById(R.id.place_set);

        Activity activity = getActivity();
        if (activity == null) return;
        windCheckBox = activity.findViewById(R.id.wind_checkbox);
        humidityCheckBox = activity.findViewById(R.id.humidity_checkbox);
        pressureCheckBox = activity.findViewById(R.id.pressure_checkbox);


        //создаем список городов
        final String[] cities = getResources().getStringArray(R.array.cities);
        LinearLayout citiesListLayout = view.findViewById(R.id.cities_list_layout);
        LayoutInflater inflater = getLayoutInflater();

        for (final String city : cities) {
            View cityLayout = inflater.inflate(R.layout.city_layout, citiesListLayout, false);
            TextView tv = cityLayout.findViewById(R.id.city_textview);
            tv.setText(city);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    parcel.setPlace(city);
                    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        parcel.setWindChecked(windCheckBox.isChecked());
                        parcel.setHumidityChecked(humidityCheckBox.isChecked());
                        parcel.setPressureChecked(pressureCheckBox.isChecked());
                    }
                    toSettingsFragment();
                }
            });
            citiesListLayout.addView(cityLayout);
        }

        //кнопка определения места
        final Button locate = view.findViewById(R.id.locate_button);
        locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Определяем место", Toast.LENGTH_SHORT).show();
            }
        });

        //принять место
        final Button commitButton = view.findViewById(R.id.commit_button);
        commitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parcel.setPlace(placeTextView.getText().toString());
                toSettingsFragment();
            }
        });
    }

    private void toSettingsFragment() {
        SettingsFragment fragment = SettingsFragment.newInstance(parcel);
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager == null) return;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

}
