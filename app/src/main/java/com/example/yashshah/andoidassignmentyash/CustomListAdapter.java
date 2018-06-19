package com.example.yashshah.andoidassignmentyash;

/**
 * Created by yashshah on 2017-04-24.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;
import org.w3c.dom.Text;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final String[] price;
    private final String[] discount1;
    private final Integer[] imgid;
    private int discount = 10;



    public CustomListAdapter(Activity context, String[] itemname, Integer[] imgid ,String[] price,String[] discount1) {
        super(context, R.layout.mylist, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
        this.price=price;
        this.discount1=discount1;
    }
    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);
        TextView pricetxt = (TextView) rowView.findViewById(R.id.textView5);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);
        extratxt.setText(discount1[position]);
        pricetxt.setText("Price: $" +price[position]);
        return rowView;

    };
}

