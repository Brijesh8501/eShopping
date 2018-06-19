package com.example.yashshah.andoidassignmentyash;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by yashshah on 2017-04-26.
 */

public class Bill extends AppCompatActivity {

    private static final String TAG = "your value";
    String store;
    TextView oPrice,Discount,fPrice,t1,t2,t3;
    RadioButton r1,r2,r3;
    Button b1,b2,b3,proceed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bill);

        oPrice = (TextView)findViewById(R.id.textView7);
        Discount = (TextView)findViewById(R.id.textView8);
        fPrice = (TextView)findViewById(R.id.textView16);
        r1 = (RadioButton)findViewById(R.id.r1);
        r2 = (RadioButton)findViewById(R.id.r3);
        r3 = (RadioButton)findViewById(R.id.r2);
        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        b3 = (Button)findViewById(R.id.b3);
        proceed = (Button)findViewById(R.id.proceed);
        t1 = (TextView) findViewById(R.id.textView19);
        t2 = (TextView) findViewById(R.id.textView21);
        t3 = (TextView) findViewById(R.id.textView20);

        Bundle sum = getIntent().getExtras();
        String message = sum.getString("sum");
        final String message2 = sum.getString("fp");
        final String email = sum.getString("email");
        final String products = sum.getString("products");

        Log.d(TAG, "finalprice= " + message);
        Log.d(TAG, "finalprice= " + message2);
        Log.d(TAG, "finalprice= " + email);

        oPrice.setText(message);

        if(email == null)
        {
            Discount.setText("Only for Registered user");
            fPrice.setText(message);
        }
        else
        {
            Discount.setText("10%");
            fPrice.setText(message2);
        }

        t1.setText("Joseph's Inc.");
        t2.setText("Indigospirit ");
        t3.setText("Chapters");

       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent g1 = new Intent(Intent.ACTION_VIEW);
               g1.setData(Uri.parse("geo:0,0?q=39, 2721 Markham Road, Toronto, ON M1X 1M4" ));
               startActivity(g1);
           }
       });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent g1 = new Intent(Intent.ACTION_VIEW);
                g1.setData(Uri.parse("geo:0,0?q=Kennedy Commons, 20 William Kitchen Rd, Scarborough, ON M1P 5B7" ));
                startActivity(g1);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent g1 = new Intent(Intent.ACTION_VIEW);
                g1.setData(Uri.parse("geo:0,0?q=Scarborough Town Centre, 300 Borough Dr #238, Scarborough, ON M1P 4P5" ));
                startActivity(g1);
            }
        });


        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(r1.isChecked() == false && r2.isChecked() == false && r3.isChecked() == false)
                {
                    Toast.makeText(getApplicationContext(),"Please Select a store",Toast.LENGTH_SHORT).show();
                }
                if(r1.isChecked())
                {
                    store =  "Joseph's Inc.";
                }
                if(r2.isChecked())
                {
                    store = "Indigospirit";
                }
                if(r3.isChecked())
                {
                    store = "Chapters";
                }

                Log.d(TAG, "store= " + store);
                Intent toCheckout = new Intent(Bill.this,Checkout.class);
                Bundle extras = new Bundle();
                extras.putString("finalprice",fPrice.getText().toString());
                extras.putString("store",store);
                extras.putString("products",products);
                extras.putString("email",email);
                toCheckout.putExtras(extras);
                startActivity(toCheckout);







            }
        });



    }


    }
