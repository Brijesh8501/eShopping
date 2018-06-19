package com.example.yashshah.andoidassignmentyash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by yashshah on 2017-11-29.
 */

public class ProductDisplayNew extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5,t6,emailText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productdisplaynew);

        t1 = (TextView)findViewById(R.id.productname);
        t2 = (TextView)findViewById(R.id.actualprice);
        t3 = (TextView)findViewById(R.id.sellingprice);
        t4 = (TextView)findViewById(R.id.productid);


        DatabaseLogin dao = new DatabaseLogin(getApplicationContext());
        t1.setText((CharSequence) dao.getRecords());
        t2.setText((CharSequence) dao.getRecords());
        t3.setText((CharSequence) dao.getRecords());
        t4.setText((CharSequence) dao.getRecords());



        dao.close();



    }


}
