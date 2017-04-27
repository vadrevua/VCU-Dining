package com.vadrevua.vcudining;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import static java.security.AccessController.getContext;

public class favoriteActivity extends AppCompatActivity {

    DataSource ds;
    private TextView testLabel;
    private ListView list;
    private float distance = 0.0f;
    LocationManager locationManager;
    Location location;
    private ArrayList<FoodItem> condensedList;
    private ArrayList<FoodItem> foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        // Assume thisActivity is the current activity
        int permissionCheck1 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION);
        int permissionCheck2 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);

        if ( ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_COARSE_LOCATION ) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_FINE_LOCATION ) == PackageManager.PERMISSION_GRANTED) {
            locationManager = (LocationManager) favoriteActivity.this.getSystemService(Context.LOCATION_SERVICE);
            location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            Location newLocation = new Location("newlocation");
            newLocation.setLatitude(37.543783);
            newLocation.setLongitude(-77.448195);

            distance = Math.round(location.distanceTo(newLocation) * 0.0621371f) / 100.0f;

        }

        ds = new DataSource(getBaseContext());
        ds.open();

        foods = ds.getAllFoods();

        populateListView();

    }

    private void populateListView() {
        int viewId = (R.id.foodItem);
        condensedList = new ArrayList<FoodItem>();

        for(int i=0; i<foods.size(); i++){
            if(foods.get(i).getFav() == 1){
                condensedList.add(foods.get(i));
            }
        }

        OurAdapter adapter = new OurAdapter(condensedList,this);
        list = (ListView) findViewById(R.id.favsListView);
        list.setAdapter(adapter);

    }

}
