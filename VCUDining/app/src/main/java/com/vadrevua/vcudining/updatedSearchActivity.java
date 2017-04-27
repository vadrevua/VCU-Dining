package com.vadrevua.vcudining;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class updatedSearchActivity extends AppCompatActivity {
    private SharedPreferences prefs;
    private TextView searchingTitle, menuText;
    private FoodList restaurant;
    private FoodItem foodItem;
    private ListView list;
    private DataSource ds;
    private long[] foodid;
    private Button button;
    private String restname;
    boolean checker = true;
    private ArrayList<FoodItem> foods;
    private ArrayList<FoodItem> condensedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updated_search);
        String data = getIntent().getExtras().getString("searchVal");
        String changedData = data.toLowerCase();
        ds = new DataSource(getBaseContext());
        ds.open();

        foodid = new long[1000];

        foods = ds.getAllFoods();

        ListIterator<FoodItem> li = null;
        li = foods.listIterator();
        String output = "";
        final Spinner sp = (Spinner) findViewById(R.id.sort_spinner);
        ArrayAdapter<CharSequence> ad = ArrayAdapter.createFromResource(this,
                R.array.spinner_array, android.R.layout.simple_spinner_item);
        sp.setAdapter(ad);

        final FoodList restFoods = new FoodList();
        String restName = "";
        if (data.equals("iHop")||data.equals("IHOP")||data.equals("Ihop")||data.equals("ihop")) {
            restName = "iHop";
            while (li.hasNext()) {
                FoodItem food = li.next();
                if (food.getRestname().equals("iHop")) {
                    restFoods.add(food);
                }
            }
            populateListView("iHop");
            restname = "iHop";

        } else if (data.equals("Wendy's")||data.equals("wendys")||data.equals("Wendys")||data.equals("wendy's")||data.equals("WENDY'S")) {
            restName = "Wendy's";
            while (li.hasNext()) {
                FoodItem food = li.next();
                if (food.getRestname().equals("Wendy's")) {
                    restFoods.add(food);
                }
            }
            populateListView("Wendy's");
            restname = "Wendy's";
        }
        else if (data.equals("Einstein Bros. Bagels")||data.equals("Einstein")||data.equals("einstein")||data.equals("bagels")||data.equals("bagel bros")||data.equals("einstein bros bagels")||data.equals("Einstein bros. bagels")||data.equals("Einstein bros bagels")){
            restName = "Einstein Bros. Bagels";
            while (li.hasNext()) {
                FoodItem food = li.next();
                if (food.getRestname().equals("Einstein Bros. Bagels - MCV")) {
                    restFoods.add(food);
                }
            }
            populateListView("Einstein Bros. Bagels - MCV");
                    restname = "Einstein Bros. Bagels - MCV";

        }
        else if (data.equals("Jonah's")||data.equals("jonah's")||data.equals("Jonahs")||data.equals("jonahs")){
            restName = "Jonah's";
            while (li.hasNext()) {
                FoodItem food = li.next();
                if (food.getRestname().equals("Jonah's")) {
                    restFoods.add(food);
                }
            }
            populateListView("Jonah's");
                    restname = "Jonah's";

        }
        else if (data.equals("Bleecker St.")||data.equals("bleeker st.")||data.equals("Bleeker St")||data.equals("bleeker st")||data.equals("Bleeker")||data.equals("bleeker")||data.equals("Bleeker Street")){
            restName = "Bleecker St.";
            while (li.hasNext()) {
                FoodItem food = li.next();
                if (food.getRestname().equals("Bleecker St.")) {
                    restFoods.add(food);
                }
            }
            populateListView("Bleecker St.");
                    restname = "Bleecker St.";

        }
        else if (data.equals("Croutons Salads & Wraps")||data.equals("Croutons")||data.equals("croutons")){
            restName = "Croutons Salads & Wraps";
            while (li.hasNext()) {
                FoodItem food = li.next();
                if (food.getRestname().equals("Croutons Salads & Wraps")) {
                    restFoods.add(food);
                }
            }
            populateListView("Croutons Salads & Wraps");
                    restname = "Croutons Salads & Wraps";

        }
        else if (data.equals("Raising Canes")||data.equals("raising canes")||data.equals("Raising canes")||data.equals("Canes")||data.equals("canes")||data.equals("Canes chicken")||data.equals("Canes fried chicken")||data.equals("fried chicken")){
            restName = "Raising Canes";
            while (li.hasNext()) {
                FoodItem food = li.next();
                if (food.getRestname().equals("Raising Canes")) {
                    restFoods.add(food);
                }
            }
            populateListView("Raising Canes");
                    restname = "Raising Canes";

        }
        else if (data.equals("Starbucks")||data.equals("starbucks")||data.equals("coffee")||data.equals("Coffee")||data.equals("Cofee")||data.equals("Starbucks coffee")
                ||data.equals("Starbucks at Cabell")||data.equals("starbucks at cabell")||data.equals("Cabell Starbucks")||data.equals("Starbucks at Jonahs")){
            restName = "Starbucks";
            while (li.hasNext()) {
                FoodItem food = li.next();
                if (food.getRestname().equals("Starbucks")) {
                    restFoods.add(food);
                }
            }
            populateListView("Starbucks");
                    restname = "Starbucks";

        }
        else if (data.equals("Panda Express")||data.equals("Panda express")||data.equals("Panda")||data.equals("panda")){
            restName = "Panda Express";
            while (li.hasNext()) {
                FoodItem food = li.next();
                if (food.getRestname().equals("Panda Express")) {
                    restFoods.add(food);
                }
            }
            populateListView("Panda Express");
                    restname = "Panda Express";

        }
        else if (data.equals("Subway")||data.equals("subway")){
            restName = "Subway";
            while (li.hasNext()) {
                FoodItem food = li.next();
                if (food.getRestname().equals("Subway")) {
                    restFoods.add(food);
                }
            }
            populateListView("Subway");
                    restname = "Subway";

        }
        else if (data.equals("Freshii")||data.equals("freshii")||data.equals("Freshy")||data.equals("freshy")||data.equals("freshi")||data.equals("Freshi")){
            restName = "Freshii";
            while (li.hasNext()) {
                FoodItem food = li.next();
                if (food.getRestname().equals("Freshii")) {
                    restFoods.add(food);
                }
            }
            populateListView("Freshii");
                    restname = "Freshii";

        }
        else if (data.equals("Taco Bell")||data.equals("Taco bell")||data.equals("Tacos")||data.equals("tacos")||data.equals("Taco")||data.equals("taco")){
            restName = "Taco Bell";
            while (li.hasNext()) {
                FoodItem food = li.next();
                if (food.getRestname().equals("Taco Bell")) {
                    restFoods.add(food);
                }
            }
            populateListView("Taco Bell");
                    restname = "Taco Bell";

        }
        else if (data.equals("Pizza Hut")||data.equals("Pizza hut")||data.equals("Pizza")||data.equals("pizza")||data.equals("Dominos")||data.equals("Papa Johns")){
            restName = "Pizza Hut";
            while (li.hasNext()) {
                FoodItem food = li.next();
                if (food.getRestname().equals("Pizza Hut")) {
                    restFoods.add(food);
                }
            }
            populateListView("Pizza Hut");
                    restname = "Pizza Hut";

        }
        else if (data.equals("Chick-fil-A")||data.equals("Chickfila")||data.equals("Chick-fil-a")||data.equals("chick-fil-a")||data.equals("chickfila")||data.equals("Chick-Fil-A")){
            restName = "Chick-fil-A";
            while (li.hasNext()) {
                FoodItem food = li.next();
                if (food.getRestname().equals("Chick-fil-A")) {
                    restFoods.add(food);
                }
            }
            populateListView("Chick-fil-A");
                    restname = "Chick-fil-A";

        }
        else if (data.equals("Chili's")||data.equals("Chilis")||data.equals("chili's")||data.equals("chilis")||data.equals("Bars")){
            restName = "Chili's";
            while (li.hasNext()) {
                FoodItem food = li.next();
                if (food.getRestname().equals("Chick-fil-A")) {
                    restFoods.add(food);
                }
            }
            populateListView("Chili's");
                    restname = "Chili's";

        }
        else if (data.equals("Market 810 2 Go")||data.equals("Market 810 2 go")||data.equals("market 810")||data.equals("Tiny Schaefer")||data.equals("market 810 2 go")||data.equals("Schaefer 2 go")||data.equals("Schaefer to go")){
            restName = "Market 810 2 Go";
            while (li.hasNext()) {
                FoodItem food = li.next();
                if (food.getRestname().equals("Market 810 2 Go")) {
                    restFoods.add(food);
                }
            }
            populateListView("Market 810 2 Go");
                    restname = "Market 810 2 Go";

        }

        else if (data.equals("Market 810")||data.equals("market 810")||data.equals("Schaefer")||data.equals("Dining hall")||data.equals("schaefer")||data.equals("Buffet")){
            restName = "Market 810";
            while (li.hasNext()) {
                FoodItem food = li.next();
                if (food.getRestname().equals("Market 810")) {
                    restFoods.add(food);
                }
            }
            populateListView("Market 810");
                    restname = "Market 810";

        }

        else if (data.equals("Cary Street Market and Deli")||data.equals("Cary St Market and Deli")||data.equals("Cary St. Market and Deli")||data.equals("Cary")||data.equals("Cary St.")||data.equals("Market and Deli")|data.equals("Cary Street")|data.equals("cary street")){
            restName = "Cary Street Market and Deli";
            while (li.hasNext()) {
                FoodItem food = li.next();
                if (food.getRestname().equals("Cary Street Market and Deli")) {
                    restFoods.add(food);
                }
            }
            populateListView("Cary Street Market and Deli");
                    restname = "Cary Street Market and Deli";

        }


        else {
          checker = false;
            restName = "Restaurant name not found";
        }


        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                String item = sp.getSelectedItem().toString();
                if (checker) {
                    switch (item) {
                        case "Sort Items":
                            quickSortPrices(0, condensedList.size() - 1);
                            populateListView(restname);
                            break;
                        case "Alphabetical":
                            quickSortNames(0, condensedList.size() - 1);
                            populateListView(restname);
                            break;
                        case "Price":
                            quickSortPrices(0, condensedList.size() - 1);
                            populateListView(restname);
                            break;
                        case "Calories":
                            quickSortCalories(0, condensedList.size() - 1);
                            populateListView(restname);
                            break;
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        //menuText = (TextView) findViewById(R.id.menuTextView);
        searchingTitle = (TextView) findViewById(R.id.restTitle);
        searchingTitle.setText(restName);
        //TODO Implement condensedList text
//        LinkedList<Restaurant.FoodItem> foodItemLinkedList = restaurant.getMenu();
//        String adder;
//        for(int i = 0; i < foodItemLinkedList.size(); i++){
//            adder = adder + "\n" + foodItemLinkedList.get(i).toString();
//        }
//        menuText.setText(adder);
//

        ds.close();
    }

    private void populateListView(String restName) {
        int viewId = (R.id.foodItem);
        condensedList = new ArrayList<FoodItem>();

        for(int i=0; i<foods.size(); i++){
            if(foods.get(i).getRestname().equals(restName)){
                condensedList.add(foods.get(i));
                foodid[i] = foods.get(i).getId();
            }
        }

        OurAdapter adapter = new OurAdapter(condensedList,this);
        list = (ListView) findViewById(R.id.restListView);
        list.setAdapter(adapter);

    }

    private void quickSortPrices(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        double pivot = condensedList.get(lowerIndex+(higherIndex-lowerIndex)/2).getPrice();
        // Divide into two arrays
        while (i <= j) {
            /*
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (condensedList.get(i).getPrice() < pivot) {
                i++;
            }
            while (condensedList.get(j).getPrice() > pivot) {
                j--;
            }
            if (i <= j) {
                exchange(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSortPrices(lowerIndex, j);
        if (i < higherIndex)
            quickSortPrices(i, higherIndex);
    }

    private void quickSortCalories(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = condensedList.get(lowerIndex+(higherIndex-lowerIndex)/2).getMaxcal();


        // Divide into two arrays
        while (i <= j) {
            /*
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (condensedList.get(i).getMaxcal() < pivot) {
                i++;
            }
            while (condensedList.get(j).getMaxcal() > pivot) {
                j--;
            }
            if (i <= j) {
                exchange(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSortCalories(lowerIndex, j);
        if (i < higherIndex)
            quickSortCalories(i, higherIndex);
    }

    private void quickSortNames(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        String pivot = condensedList.get(lowerIndex+(higherIndex-lowerIndex)/2).getFoodname();


        // Divide into two arrays
        while (i <= j) {
            /*
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (condensedList.get(i).getFoodname().compareTo(pivot) < 0) {
                i++;
            }
            while (condensedList.get(j).getFoodname().compareTo(pivot) > 0) {
                j--;
            }
            if (i <= j) {
                exchange(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSortNames(lowerIndex, j);
        if (i < higherIndex)
            quickSortNames(i, higherIndex);
    }

    private void exchange(int i, int j) {
        long temp0 = condensedList.get(i).getId();
        condensedList.get(i).setId(condensedList.get(j).getId());
        condensedList.get(j).setId(temp0);
        int temp1 = condensedList.get(i).getMaxcal();
        condensedList.get(i).setMaxcal(condensedList.get(j).getMaxcal());
        condensedList.get(j).setMaxcal(temp1);
        double temp2 = condensedList.get(i).getPrice();
        condensedList.get(i).setPrice(condensedList.get(j).getPrice());
        condensedList.get(j).setPrice(temp2);
        String temp3 = condensedList.get(i).getRestname();
        condensedList.get(i).setRestname(condensedList.get(j).getRestname());
        condensedList.get(j).setRestname(temp3);
        String temp4 = condensedList.get(i).getFoodname();
        condensedList.get(i).setFoodname(condensedList.get(j).getFoodname());
        condensedList.get(j).setFoodname(temp4);
        int temp5 = condensedList.get(i).getMincal();
        condensedList.get(i).setMincal(condensedList.get(j).getMincal());
        condensedList.get(j).setMincal(temp5);
    }

}

