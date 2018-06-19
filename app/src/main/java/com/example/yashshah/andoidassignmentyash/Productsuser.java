package com.example.yashshah.andoidassignmentyash;

/**
 * Created by yashshah on 2017-04-24.
 */

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;


public class Productsuser extends Activity {

    //String extra = getIntent().getStringExtra("email");



    private static final String TAG = "your value";
    int sum = 0;
    String products = "";
    String message = "";
    String email2 = "";
    Bundle extras;
    ListView list;
    Button b1, b2;
    CheckBox c1, c2, c3;
    TextView t1,t2,t3,t4,t5,t6,t7;
    String[] itemname = {
            "Guy kawasaki",
            "Just Courage",
            "Life of Pi" };

    String[] price = {"10","15","20"};
    Integer[] imgid =
            {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3};

    String[] discount1 = {"","",""};
    String[] discount2 = {"Discount 10%","Discount 10%","Discount 10%"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        b1 = (Button)findViewById(R.id.button1);
        b2 = (Button)findViewById(R.id.button2);
        c1 = (CheckBox)findViewById(R.id.checkBox);
        c2 = (CheckBox)findViewById(R.id.checkBox2);
        c3 = (CheckBox)findViewById(R.id.checkBox3);

        list = (ListView) findViewById(R.id.list);
        t1 = (TextView)findViewById(R.id.user);
        t2 = (TextView)findViewById(R.id.textView17);

        CustomListAdapter user = new CustomListAdapter(this, itemname, imgid , price , discount2);
        CustomListAdapter guest = new CustomListAdapter(this, itemname, imgid , price , discount1);
        extras = getIntent().getExtras();

        if(extras != null)
        {
            message = extras.getString("email");
            t1.setText("Welcome :" +message);
            list.setAdapter(user);
            email2 = message;
        }
        else
        {
            t1.setText("Welcome Guest");
            list.setAdapter(guest);
            email2 = null;
        }











       /* list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem= itemname[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

            }
        });*/



        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                if(c1.isChecked())
                {
                    sum=sum+10;
                    products = products + "Guy kawasaki";
                }
                if(c2.isChecked())
                {
                    sum=sum+15;
                    products = products + ",Just Courage";
                }
                if(c3.isChecked())
                {
                    sum=sum+20;
                    products = products + ",Life of Pi";
                }

                String sum2 = Integer.toString(sum);


                int discountPrice = ((sum*10)/100);
                int finalprice = sum - discountPrice;

                Log.d(TAG, "discount value = " + discountPrice);
                Log.d(TAG, "finalprice= " + finalprice);

                Intent tobill = new Intent(Productsuser.this,Bill.class);
                Bundle extras = new Bundle();
                extras.putString("sum",sum2);
                extras.putString("email",email2);
                extras.putString("products",products);
                extras.putString("fp", String.valueOf(finalprice));
                tobill.putExtras(extras);
                startActivity(tobill);


            }
        });



        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setData(Uri.parse("sms: 6476698329"));
                startActivity(intentSms);


            }
        });



    }



}