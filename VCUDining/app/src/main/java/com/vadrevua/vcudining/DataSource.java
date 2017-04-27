package com.vadrevua.vcudining;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.vadrevua.vcudining.OurSQLiteHelper;
import java.io.*;

import android.database.sqlite.SQLiteException;
import android.os.CancellationSignal;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Team 02 on 4/7/2017.
 */

public class DataSource {

    private SQLiteDatabase database;
    private OurSQLiteHelper sqlh;

    public DataSource(Context context) {
        sqlh = new OurSQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = sqlh.getWritableDatabase();
    }

    public void close() {
        sqlh.close();
    }

    public long createFood(FoodItem fi) {

        ContentValues values = new ContentValues();
        values.put(OurSQLiteHelper.COLUMN_RESTNAME, fi.getRestname());
        values.put(OurSQLiteHelper.COLUMN_FOODNAME, fi.getFoodname());
        values.put(OurSQLiteHelper.COLUMN_PRICE, fi.getPrice());
        values.put(OurSQLiteHelper.COLUMN_CALMAX, fi.getMaxcal());
        values.put(OurSQLiteHelper.COLUMN_CALMIN, fi.getMincal());
        values.put(OurSQLiteHelper.COLUMN_FAV, fi.getFav());

        // insert row
        long food_id = database.insert(OurSQLiteHelper.TABLE_FOODS, null, values);

        return food_id;
    }

    public FoodItem getFood(long food_id) {
        sqlh.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + OurSQLiteHelper.TABLE_FOODS + " WHERE "
                + OurSQLiteHelper.COLUMN_ID + " = " + food_id;

        Log.e(OurSQLiteHelper.LOG, selectQuery);

        Cursor c = database.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        FoodItem fi = new FoodItem();
        fi.setRestname(c.getString(c.getColumnIndex(OurSQLiteHelper.COLUMN_RESTNAME)));
        fi.setFoodname(c.getString(c.getColumnIndex(OurSQLiteHelper.COLUMN_FOODNAME)));
        fi.setPrice(c.getDouble(c.getColumnIndex(OurSQLiteHelper.COLUMN_PRICE)));
        fi.setMaxcal(c.getInt(c.getColumnIndex(OurSQLiteHelper.COLUMN_CALMAX)));
        fi.setMincal(c.getInt(c.getColumnIndex(OurSQLiteHelper.COLUMN_CALMIN)));
        fi.setFav(c.getInt(c.getColumnIndex(OurSQLiteHelper.COLUMN_FAV)));

        return fi;
    }

    public ArrayList<FoodItem> getAllFoods() {

        ArrayList<FoodItem> foods = new ArrayList<FoodItem>();

        Cursor cursor = database.query(OurSQLiteHelper.TABLE_FOODS,
                OurSQLiteHelper.allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            FoodItem food = cursorToFood(cursor);
            foods.add(food);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return foods;
    }

    public Cursor getAllFoodsCursor(){

        List<FoodItem> foods = new ArrayList<FoodItem>();

        Cursor cursor = database.query(OurSQLiteHelper.TABLE_FOODS,
                OurSQLiteHelper.allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            FoodItem food = cursorToFood(cursor);
            foods.add(food);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        //TODO: Find a way to close Cursor
        //cursor.close();
        return cursor;
    }

    private FoodItem cursorToFood(Cursor cursor) {
        FoodItem food = new FoodItem();
        food.setId(cursor.getInt(0));
        food.setRestname(cursor.getString(1));
        food.setFoodname(cursor.getString(2));
        food.setPrice(cursor.getDouble(3));
        food.setMaxcal(cursor.getInt(4));
        food.setMincal(cursor.getInt(5));
        food.setFav(cursor.getInt(6));
        return food;
    }

    public void changeFavorite (long food_id){

        String selectQuery = "SELECT  * FROM " + OurSQLiteHelper.TABLE_FOODS + " WHERE "
                + OurSQLiteHelper.COLUMN_ID + " = '" + food_id + "'";

        Log.e(OurSQLiteHelper.LOG, selectQuery);

        Cursor c = database.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        ContentValues values = new ContentValues();

        if(c.getInt(c.getColumnIndex(OurSQLiteHelper.COLUMN_FAV)) == 0)
            values.put(OurSQLiteHelper.COLUMN_FAV,1);
        else values.put(OurSQLiteHelper.COLUMN_FAV,0);

        database.update(OurSQLiteHelper.TABLE_FOODS, values, OurSQLiteHelper.COLUMN_ID +" = '"+ food_id + "'", null);

    }

    public void deleteFood(FoodItem food) {
        long id = food.getId();
        database.delete(OurSQLiteHelper.TABLE_FOODS, OurSQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public void deleteAll() {
        Cursor cursor = database.query(OurSQLiteHelper.TABLE_FOODS,
                OurSQLiteHelper.allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            FoodItem food = cursorToFood(cursor);
            deleteFood(food);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
    }

    public boolean databaseExists() {
        Cursor cursor = database.rawQuery("SELECT  * FROM " + OurSQLiteHelper.TABLE_FOODS + " WHERE "
                + OurSQLiteHelper.COLUMN_ID + " = " + 20, null);
        if(cursor.getCount() <= 0) {
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public Cursor rawQuery(String x, String[] y){
        Cursor c = database.rawQuery(x,y);
        return c;
    }

}
