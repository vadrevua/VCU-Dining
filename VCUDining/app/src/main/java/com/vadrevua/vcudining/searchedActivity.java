package com.vadrevua.vcudining;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class searchedActivity extends AppCompatActivity {
    private SharedPreferences prefs;
    private TextView warning;
    private TextView cals;
    private TextView range;
    private TextView menuPrice1,menuPrice2,menuPrice3,menuPrice4,menuPrice5;
    private TextView menuItem1,menuItem2,menuItem3,menuItem4,menuItem5;
    private TextView searchingTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searched);
        //searchTV = (TextView) findViewById(R.id.searchedTextView);
        String data = getIntent().getExtras().getString("searchVal");
        //searchTV.setText("You searched for " + data);
        warning = (TextView) findViewById(R.id.warning);
        cals = (TextView) findViewById(R.id.cals);
        range = (TextView) findViewById(R.id.range);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        cals.setText("Your max calories is " + prefs.getString("calories1","1"));
        range.setText("Your search range is " + prefs.getString("searchRange","1") + " miles");
        if(prefs.getBoolean("allergies",true)) warning.setText("WARNING: Contains ");
        menuPrice1= (TextView) findViewById(R.id.menuPrice1);
        menuPrice2= (TextView) findViewById(R.id.menuPrice2);
        menuPrice3= (TextView) findViewById(R.id.menuPrice3);
        menuPrice4= (TextView) findViewById(R.id.menuPrice4);
        menuPrice5= (TextView) findViewById(R.id.menuPrice5);
        menuItem1= (TextView) findViewById(R.id.menuItem1);
        menuItem2= (TextView) findViewById(R.id.menuItem2);
        menuItem3= (TextView) findViewById(R.id.menuItem3);
        menuItem4= (TextView) findViewById(R.id.menuItem4);
        menuItem5= (TextView) findViewById(R.id.menuItem5);
        searchingTitle= (TextView) findViewById(R.id.searchingTitle);
        System.out.println(data);
      if (data.equals("Chili's") || (data.equals("Chilis"))|| data.equals("chilis")|| data.equals("chili's"))
       {
           searchingTitle.setText("Chili's Grill and Bar");
           menuItem1.setText("Triple Dipper");
           menuItem2.setText("California Grilled Chicken Flatbread");
           menuItem3.setText("Skillet Queso and Chips");
           menuItem4.setText("Signature Wings");
           menuItem5.setText("Loaded Boneless Wings");

           menuPrice1.setText("$11.39");
           menuPrice2.setText("$9.49");
           menuPrice3.setText("$5.79");
           menuPrice4.setText("$9.49");
           menuPrice5.setText("$9.59");
       }

        else if (data.equals("Chick-Fil-A") || data.equals("chick-fil-a") || data.equals("Chick-fil-a") || data.equals("Chick") || data.equals("chikfila"))
        {
            searchingTitle.setText("Chick-Fil-A");
            menuItem1.setText("Chick-Fil-A Chicken Deluxe Sandwich");
            menuItem2.setText("Chick-Fil-A Nuggets 8-pc Combo");
            menuItem3.setText("Chick-Fil-A Nuggets 12-pc Combo ");
            menuItem4.setText("Chick-Fil-A Chicken Sandwich");
            menuItem5.setText("Large Waffle Potato Fries");

            menuPrice1.setText("$3.65");
            menuPrice2.setText("$5.95");
            menuPrice3.setText("$8.59");
            menuPrice4.setText("$3.05");
            menuPrice5.setText("$1.85");
        }

        else if (data.equals("Einsteins Bros. Bagels")|| data.equals("Einstein's Bros. Bagels")|| data.equals("Einsteins") || data.equals("Einstein's"))

        {
            searchingTitle.setText("Einsteins Bros. Bagels");
            menuItem1.setText("Applewood Bacon and Cheddar Egg Sandwich");
            menuItem2.setText("Turkey-Sausage & Cheddar Egg Sandwich");
            menuItem3.setText("Cheddar Cheese Egg Sandwich");
            menuItem4.setText("Turkey, Bacon, and Avocado Sandwiches");
            menuItem5.setText("Cheese Pizza Bagel");

            menuPrice1.setText("$4.99");
            menuPrice2.setText("$4.99");
            menuPrice3.setText("$4.69");
            menuPrice4.setText("$6.99");
            menuPrice5.setText("$5.55");
        }

        else
        {
            searchingTitle.setText("Restaurant not found");
            menuItem1.setText("");
            menuItem2.setText("");
            menuItem3.setText("");
            menuItem4.setText("");
            menuItem5.setText("");

            menuPrice1.setText("");
            menuPrice2.setText("");
            menuPrice3.setText("");
            menuPrice4.setText("");
            menuPrice5.setText("");
        }

    }
}
