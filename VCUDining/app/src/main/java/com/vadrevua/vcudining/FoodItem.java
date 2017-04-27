package com.vadrevua.vcudining;

import java.text.DecimalFormat;

/**
 * Created by Team 02 on 4/6/2017.
 */

//Food Item Class
public class FoodItem {

    private long id;
    private String restname;
    private String foodname;
    private double price;
    private int maxcal;
    private int mincal;
    private int fav;

    public FoodItem() {
        this.id = 0;
        this.restname = "N/A";
        this.foodname = "N/A";
        this.price = 0.0;
        this.maxcal = 0;
        this.mincal = 0;
        this.fav = 0;
    }

    public FoodItem(long id, String restname, String foodname, double price, int maxcal, int mincal, int fav) {
        this.id = id;
        this.restname = restname;
        this.foodname = foodname;
        this.price = price;
        this.maxcal = maxcal;
        this.mincal = mincal;
        this.fav = fav;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRestname() {
        return restname;
    }

    public void setRestname(String restname) {
        this.restname = restname;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxcal() {
        return maxcal;
    }

    public void setMaxcal(int maxcal) {
        this.maxcal = maxcal;
    }

    public int getMincal() {
        return mincal;
    }

    public void setMincal(int mincal) {
        this.mincal = mincal;
    }

    public int getFav() { return fav; }

    public void setFav(int fav) { this.fav = fav; }

    @Override
    public String toString() {
        String favorited = getFav() == 1 ? "Favorited" : "";
        String priceStr = String.format("%.2f", price);
        //if there is no calorie range, prints one calorie value. if two, prints value-value.
        if (mincal==maxcal) {
            //trying spannable string
            return foodname + "\n$" + priceStr + "\n" + mincal + " calories\n" + favorited;
        }
        else {
            return foodname + "\n$" + priceStr + "\n" + mincal + "-" + maxcal + " calories\n" + favorited;
        }

    }

}