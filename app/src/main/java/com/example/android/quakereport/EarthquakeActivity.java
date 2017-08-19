/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.quakereport.adapter.EarthquakeAdapter;
import com.example.android.quakereport.dataobject.Earthquake;
import com.example.android.quakereport.utils.QueryUtils;

import java.util.ArrayList;
import java.util.Date;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(LOG_TAG, "onCreate - I");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
//        ArrayList<Earthquake> earthquakes = new ArrayList<>();
//        earthquakes.add(new Earthquake(Float.valueOf("7.5"), "San Francisco", new Date()));
//        earthquakes.add(new Earthquake(Float.valueOf("4.5"), "London", new Date()));
//        earthquakes.add(new Earthquake(Float.valueOf("3.2"), "Tokio", new Date()));
//        earthquakes.add(new Earthquake(Float.valueOf("7.0"), "México City", new Date()));
//        earthquakes.add(new Earthquake(Float.valueOf("3.9"), "Moscow", new Date()));
//        earthquakes.add(new Earthquake(Float.valueOf("4.8"), "Rio de Janeiro", new Date()));
//        earthquakes.add(new Earthquake(Float.valueOf("5.1"), "París", new Date()));

        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

        // Crear el adapter
        EarthquakeAdapter adaptador = new EarthquakeAdapter(this, earthquakes);

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adaptador);

        Log.v(LOG_TAG, "onCreate - F");
    }
}
