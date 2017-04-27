package com.vadrevua.vcudining;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {
    private EditText restSearch;
    private DataSource ds;
    private FoodList fl;
    private final int MY_PERMISSION_ACCESS_COARSE_LOCATION = 1;
    private final int MY_PERMISSION_ACCESS_FINE_LOCATION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ds = new DataSource(getBaseContext());
        ds.open();

        if(!ds.databaseExists()) {
            FoodList fl = new FoodList();

            try {
                DataInputStream textFileStream = new DataInputStream(getAssets().open(String.format("Restaurant_List.txt")));
                fl.generateMenu(textFileStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

            ListIterator<FoodItem> li = null;
            li = fl.getList().listIterator();
            while (li.hasNext()) {
                ds.createFood(li.next());
            }
        }

        // Assume thisActivity is the current activity
        int permissionCheck1 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION);
        int permissionCheck2 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);

        if ( ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_COARSE_LOCATION ) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions( this, new String[] {  android.Manifest.permission.ACCESS_COARSE_LOCATION  },
                    MY_PERMISSION_ACCESS_COARSE_LOCATION );
            ActivityCompat.requestPermissions( this, new String[] {  android.Manifest.permission.ACCESS_FINE_LOCATION  },
                    MY_PERMISSION_ACCESS_FINE_LOCATION );
        }

        ds.close();

        restSearch = (EditText)findViewById(R.id.restaurantSearch);
        Button timingButton = (Button) findViewById(R.id.timingButton);
        Button browsingButton = (Button) findViewById(R.id.browseButton);
        Button settingsButton = (Button) findViewById(R.id.settingsButton);
        Button addButton = (Button) findViewById(R.id.addButton);
        Button favsButton = (Button) findViewById(R.id.favsButton);

        timingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, restTimings.class);
                startActivity(intent);
            }
        });
        browsingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String restSearchString = restSearch.getText().toString();
                if(restSearchString.equals("")){
                    Toast.makeText(getBaseContext(),"Type a restaurant into search bar", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent searchIntent = new Intent(MainActivity.this, updatedSearchActivity.class);
                    searchIntent.putExtra("searchVal", restSearchString);
                    startActivity(searchIntent);
                }
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(MainActivity.this, addressActivity.class);
                startActivity(searchIntent);
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        favsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, favoriteActivity.class);
                startActivity(intent);
            }
        });
    }
}