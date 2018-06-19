package com.example.yashshah.andoidassignmentyash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yashshah on 2017-04-21.
 */


public class Login extends AppCompatActivity {

    private Button login;
    private EditText email,password;
  //  private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);




        DatabaseLogin dao = new DatabaseLogin(this);
        try {
            dao.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        login = (Button)findViewById(R.id.loginbutton);
        email = (EditText)findViewById(R.id.emailtext);
        password = (EditText)findViewById(R.id.pwdtext);
       //listView = (ListView)findViewById(R.id.listview);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                searchuser();

            }
        });
    }


    private void searchuser()
    {
            String fetchemail = email.getText().toString();
            String fetchpwd = password.getText().toString();
            DatabaseLogin dao = new DatabaseLogin(getApplicationContext());
            //List<Logingetset> students = dao.searchUser();
            dao.close();


        /*ArrayAdapter<Logingetset> adapter = new
                ArrayAdapter<Logingetset>(this, android.R.layout.simple_list_item_1,students);*/


        String storedPassword=dao.getSinlgeEntry(fetchemail);

        if(fetchpwd.equals(storedPassword))
        {
            Intent intent = new Intent(Login.this,ProductDisplayNew.class);
            intent.putExtra("email",fetchemail);
            startActivity(intent);
            //Toast.makeText(Login.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
            //dialog.dismiss();
        }
        else
        {
            Toast.makeText(Login.this, "Wrong Email-id or Password", Toast.LENGTH_LONG).show();
        }


         // listView.setAdapter(adapter);



       /* if(students.contains())
        {
            Toast.makeText(Login.this, "User  saved!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(Login.this, "User Not saved!", Toast.LENGTH_SHORT).show();
        }*/
    }
}
