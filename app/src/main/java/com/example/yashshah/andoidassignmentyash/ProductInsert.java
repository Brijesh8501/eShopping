package com.example.yashshah.andoidassignmentyash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by yashshah on 2017-11-29.
 */

public class ProductInsert extends AppCompatActivity {
    private ProductInsertHelper helper;
    private Button insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productinsert);

        helper = new ProductInsertHelper(this);

        insert = (Button)findViewById(R.id.insert);


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                press();
            }
        });

    }


    public void press()
    {

        Productgetset productgetset = helper.pickupStudent();
        DatabaseLogin dao = new DatabaseLogin(this);
        dao.proInsert(productgetset);
        dao.close();

        Toast.makeText(ProductInsert.this, "Product " + productgetset.getName()+ " Inserted!", Toast.LENGTH_LONG).show();
        finish();


    }




}
