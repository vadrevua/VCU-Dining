package com.vadrevua.vcudining;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Team 02 on 4/20/2017.
 */

public class OurAdapter extends BaseAdapter implements ListAdapter {

    private ArrayList<FoodItem> list = new ArrayList<FoodItem>();
    private Context context;
    private boolean clicked = false;
    private DataSource ds;

    public OurAdapter(ArrayList<FoodItem> list, Context context) {
        this.list = list;
        this.context = context;
        ds = new DataSource(context);
        ds.open();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return list.get(pos).getId();
        //just return 0 if your list items do not have an Id variable.
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.itemlayout, parent, false);
        }

        //Handle TextView and display string from your list
        final TextView listItemText = (TextView)view.findViewById(R.id.foodItem);
        String s = list.get(position).toString();
        SpannableString ss = new SpannableString(s);
        int sizeOfFN = list.get(position).getFoodname().length();
        ss.setSpan(new RelativeSizeSpan(1.5f), 0, sizeOfFN, 0);
        listItemText.setText(ss);

        //Handle button and add onClickListeners
        Button favBtn = (Button)view.findViewById(R.id.favButton);

        favBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(list.get(position).getFav() == 0) {
                    list.get(position).setFav(1);
                    notifyDataSetChanged();
                    Toast.makeText(context, list.get(position).getFoodname() +
                            " added to favorites", Toast.LENGTH_LONG).show();
                    ds.changeFavorite(list.get(position).getId());
                }
                else {
                    list.get(position).setFav(0);
                    notifyDataSetChanged();
                    Toast.makeText(context, list.get(position).getFoodname() +
                            " removed from favorites", Toast.LENGTH_LONG).show();
                    ds.changeFavorite(list.get(position).getId());
                }
            }
        });

        return view;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
}
