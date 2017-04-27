package com.vadrevua.vcudining;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.*;

/**
 * Created by Team 02 on 4/6/2017.
 */

public class OurSQLiteHelper extends SQLiteOpenHelper {

    // Logcat tag
    public static final String LOG = "DatabaseHelper";

    // Database
    public SQLiteDatabase db;

    // Column names
    public static final String TABLE_FOODS = "foods";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_RESTNAME = "restname";
    public static final String COLUMN_FOODNAME = "foodname";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_CALMAX = "calmax";
    public static final String COLUMN_CALMIN = "calmin";
    public static final String COLUMN_FAV = "fav";

    public static String[] allColumns = { OurSQLiteHelper.COLUMN_ID,
            OurSQLiteHelper.COLUMN_RESTNAME, OurSQLiteHelper.COLUMN_FOODNAME,
            OurSQLiteHelper.COLUMN_PRICE, OurSQLiteHelper.COLUMN_CALMAX,
            OurSQLiteHelper.COLUMN_CALMIN, OurSQLiteHelper.COLUMN_FAV };


    private static final String DATABASE_NAME = "Restaurant_Items.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table " + TABLE_FOODS +
            "(" + COLUMN_ID + " integer primary key, " + COLUMN_RESTNAME +
            " text, " + COLUMN_FOODNAME + " text, " + COLUMN_PRICE + " real, " +
            COLUMN_CALMAX + " integer, " + COLUMN_CALMIN + " integer, " + COLUMN_FAV +
            " interger)";

    public OurSQLiteHelper(Context c) {

        super(c, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DATABASE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(OurSQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOODS);
        onCreate(db);
    }

    public long createFood(FoodItem fi) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_RESTNAME, fi.getRestname());
        values.put(COLUMN_FOODNAME, fi.getFoodname());
        values.put(COLUMN_PRICE, fi.getPrice());
        values.put(COLUMN_CALMAX, fi.getMaxcal());
        values.put(COLUMN_CALMIN, fi.getMincal());
        values.put(COLUMN_FAV, fi.getFav());

        // insert row
        long food_id = db.insert(TABLE_FOODS, null, values);

        fi.setId(food_id);

        return food_id;
    }

    public FoodItem getFood(long food_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_FOODS + " WHERE "
                + COLUMN_ID + " = " + food_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        FoodItem fi = new FoodItem();
        fi.setRestname((c.getString(c.getColumnIndex(COLUMN_RESTNAME))));
        fi.setFoodname(c.getString(c.getColumnIndex(COLUMN_FOODNAME)));
        fi.setPrice(c.getDouble(c.getColumnIndex(COLUMN_PRICE)));
        fi.setMaxcal(c.getInt(c.getColumnIndex(COLUMN_CALMAX)));
        fi.setMincal(c.getInt(c.getColumnIndex(COLUMN_CALMIN)));
        fi.setFav(c.getInt(c.getColumnIndex(COLUMN_FAV)));

        return fi;
    }

    public List<FoodItem> getAllFoods() {
        SQLiteDatabase db = this.getReadableDatabase();

        List<FoodItem> foods = new ArrayList<FoodItem>();

        Cursor cursor = db.query(OurSQLiteHelper.TABLE_FOODS,
                allColumns, null, null, null, null, null);

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

    public Cursor getAllFoodsCursor() {
        SQLiteDatabase db = this.getReadableDatabase();

        List<FoodItem> foods = new ArrayList<FoodItem>();

        Cursor cursor = db.query(OurSQLiteHelper.TABLE_FOODS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            FoodItem food = cursorToFood(cursor);
            foods.add(food);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return cursor;
    }

    private FoodItem cursorToFood(Cursor cursor) {
        FoodItem food = new FoodItem();
        food.setRestname(cursor.getString(1));
        food.setFoodname(cursor.getString(2));
        food.setPrice(cursor.getDouble(3));
        food.setMaxcal(cursor.getInt(4));
        food.setMincal(cursor.getInt(5));
        food.setFav(cursor.getInt(6));
        return food;
    }

}
