package com.vadrevua.vcudining;

/**
 * Created by Team 02 on 4/2/2017.
 */
import android.content.Context;
import android.content.res.AssetManager;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ListIterator;

import java.util.*;
import java.io.*;

import static java.security.AccessController.getContext;

public class FoodList {

    private LinkedList<FoodItem> menu;

    public FoodList(){
        menu = new LinkedList<FoodItem>();
    }

    public void generateMenu(DataInputStream dis) {
        Scanner in = new Scanner(dis);
        in.useDelimiter("\\s*:\\s*|\\s*\n\\s*");

        while(in.hasNextLine()) {

            String restName = in.next();
            String itemName = in.next();
            double itemPrice = in.nextDouble();
            int itemMinCal = in.nextInt();
            int itemMaxCal = in.nextInt();
            int favNum = in.nextInt();
            FoodItem foo = new FoodItem(0, restName,itemName,itemPrice,itemMaxCal,itemMinCal,favNum);
            menu.add(foo);

        }

    }

    public FoodItem add(FoodItem foo) {
        menu.add(foo);
        return foo;
    }

    public void sortByCalories() {

        if (menu == null || menu.size() == 0) {
            return;
        }
        quickSortCalories(0, menu.size() - 1);
    }

    private void quickSortCalories(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = menu.get(lowerIndex+(higherIndex-lowerIndex)/2).getMaxcal();


        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (menu.get(i).getMaxcal() < pivot) {
                i++;
            }
            while (menu.get(j).getMaxcal() > pivot) {
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

    private void exchange(int i, int j) {
        int temp1 = menu.get(i).getMaxcal();
        menu.get(i).setMaxcal(menu.get(j).getMaxcal());
        menu.get(j).setMaxcal(temp1);
        double temp2 = menu.get(i).getPrice();
        menu.get(i).setPrice(menu.get(j).getPrice());
        menu.get(j).setPrice(temp2);
        String temp3 = menu.get(i).getRestname();
        menu.get(i).setRestname(menu.get(j).getRestname());
        menu.get(j).setRestname(temp3);
        String temp4 = menu.get(i).getFoodname();
        menu.get(i).setFoodname(menu.get(j).getFoodname());
        menu.get(j).setFoodname(temp4);
        int temp5 = menu.get(i).getMincal();
        menu.get(i).setMincal(menu.get(j).getMincal());
        menu.get(j).setMincal(temp5);
    }

    public String printMenu() {
        String output = "";
        ListIterator<FoodItem> li = null;
        li = menu.listIterator();
        while(li.hasNext()) {
            output += li.next() + "\n";
        }
        return output;
    }

    public void sortByPrice() {

        if (menu == null || menu.size() == 0) {
            return;
        }
        quickSortPrices(0, menu.size() - 1);
    }

    private void quickSortPrices(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        double pivot = menu.get(lowerIndex+(higherIndex-lowerIndex)/2).getPrice();
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (menu.get(i).getPrice() < pivot) {
                i++;
            }
            while (menu.get(j).getPrice() > pivot) {
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


    public LinkedList<FoodItem> getList() {
        return menu;
    }

    //TODO: fix database

}