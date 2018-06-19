package com.example.yashshah.andoidassignmentyash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by yashshah on 2017-04-21.
 */

public class Signup extends AppCompatActivity {
    private SignupHelper helper;

   private Button signup1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        helper = new SignupHelper(this);
       signup1 = (Button)findViewById(R.id.signupbutton);

        signup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                press();
            }
        });

    }

    public void press()
    {
        Logingetset logingetset = helper.pickupStudent();
        DatabaseLogin dao = new DatabaseLogin(this);
        dao.dbInsert(logingetset);
        dao.close();

        Toast.makeText(Signup.this, "User " + logingetset.getName()+ " saved!", Toast.LENGTH_LONG).show();
        finish();
    }

    }

