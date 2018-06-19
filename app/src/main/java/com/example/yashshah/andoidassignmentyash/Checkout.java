package com.example.yashshah.andoidassignmentyash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by yashshah on 2017-04-26.
 */

public class Checkout extends AppCompatActivity
{
    private Checkout helper1;
    String name;
    String address;;
    String phone;
    String email,total,store,products;
    EditText credit,exp1,exp2,cvv,nameEdit,addressEdit,phoneEdit,emailEdit;
    Button confirm;
    private Logingetset logingetset = new Logingetset();
    TextView t1,t2,t3,t4,t5,t6,emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout);


        Bundle sum = getIntent().getExtras();
        total = sum.getString("finalprice");
        store = sum.getString("store");
        products = sum.getString("products");
        email = sum.getString("email");


        t1 = (TextView)findViewById(R.id.name1);
        t2 = (TextView)findViewById(R.id.address1);
        t3 = (TextView)findViewById(R.id.phone1);
        t4 = (TextView)findViewById(R.id.products1);
        t5 = (TextView)findViewById(R.id.total1);
        t6 = (TextView)findViewById(R.id.store1);
        emailText = (TextView)findViewById(R.id.emailText);
        credit = (EditText)findViewById(R.id.editText);
        exp1 = (EditText)findViewById(R.id.editText2);
        exp2 = (EditText)findViewById(R.id.editText3);
        cvv = (EditText)findViewById(R.id.editText4);
        nameEdit = (EditText)findViewById(R.id.nameEdit);
        addressEdit = (EditText)findViewById(R.id.addressEdit);
        phoneEdit = (EditText)findViewById(R.id.phoneEdit);
         emailEdit = (EditText)findViewById(R.id.emailEdit);
        confirm = (Button)findViewById(R.id.confirm);


        t5.setText(total);
        t6.setText(store);
        t4.setText(products);

        DatabaseLogin dao = new DatabaseLogin(getApplicationContext());
        if(email != null)
        {
            name = dao.getName(email);
            address = dao.getAddress(email);
            phone = dao.getPhone(email);
            t1.setText(name);
            t2.setText(address);
            t3.setText(phone);
            emailText.setText(email);
            nameEdit.setVisibility(View.INVISIBLE);
            addressEdit.setVisibility(View.INVISIBLE);
            phoneEdit.setVisibility(View.INVISIBLE);
            emailEdit.setVisibility(View.INVISIBLE);
        }
        else
        {
            t1.setVisibility(View.INVISIBLE);
            t2.setVisibility(View.INVISIBLE);
            t3.setVisibility(View.INVISIBLE);
            emailText.setVisibility(View.INVISIBLE);
        }




        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                press();

            }
        });

    }


    public Logingetset pickupStudent() {
        logingetset.setName(name);
        logingetset.setAddress(address);
        logingetset.setEmail(email);
        logingetset.setPhone(phone);
        logingetset.setProducts(products);



        return logingetset;
    }

    public Logingetset pickupStudent2() {
        logingetset.setName(nameEdit.getText().toString());
        logingetset.setAddress(addressEdit.getText().toString());
        logingetset.setEmail(emailEdit.getText().toString());
        logingetset.setPhone(phoneEdit.getText().toString());
        logingetset.setProducts(products);




        return logingetset;
    }

    public void press()
    {

        Logingetset logingetset = pickupStudent();
        Logingetset logingetset2 = pickupStudent2();
        DatabaseLogin dao = new DatabaseLogin(this);
        if(email != null)
        {
            dao.dbCheckoutInsert(logingetset);
        }
        else
        {
            dao.dbCheckoutInsert(logingetset2);
        }
        dao.close();

        Toast.makeText(Checkout.this, "Order " + logingetset.getName()+ " saved!", Toast.LENGTH_LONG).show();

    }


}
