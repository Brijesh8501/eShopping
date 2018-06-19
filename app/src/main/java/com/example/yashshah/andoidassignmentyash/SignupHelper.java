package com.example.yashshah.andoidassignmentyash;

import android.widget.EditText;


/**
 * Created by yashshah on 2017-04-21.
 */

 public class SignupHelper {
    private final EditText name;
    private final EditText password;
    private final EditText email;
    private final EditText dob;
    private final EditText phone;
    private final EditText address;
    private Logingetset logingetset;

    public SignupHelper(Signup activity) {
        name = (EditText) activity.findViewById(R.id.name);
        password = (EditText) activity.findViewById(R.id.aprice);
        email = (EditText) activity.findViewById(R.id.productid);
        dob = (EditText) activity.findViewById(R.id.dob);
        phone = (EditText)activity.findViewById(R.id.sprice);

        address = (EditText) activity.findViewById(R.id.address);

        logingetset = new Logingetset();

    }

    public Logingetset pickupStudent() {
        logingetset.setName(name.getText().toString());
        logingetset.setAddress(address.getText().toString());
        logingetset.setEmail(email.getText().toString());
        logingetset.setPhone(phone.getText().toString());
        logingetset.setDob(dob.getText().toString());
        logingetset.setPassword(password.getText().toString());


        return logingetset;
    }
}