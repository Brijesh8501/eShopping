package com.example.yashshah.andoidassignmentyash;

import java.io.Serializable;

/**
 * Created by yashshah on 2017-04-21.
 */

public class Logingetset implements Serializable {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String dob;
    private String address;
    private String products;
    private String creditnumber,exp1,exp2,cvv;


    @Override
    public String toString() {
        return getId() + "-" + getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public  String getAddress() {
        return address;
    }

    public String setAddress(String address) {
        this.address = address;
        return address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public String getProducts() {
        return products;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }





    public void setCreditNumber(String creditnumber) {
        this.creditnumber = creditnumber;
    }

    public void setExp1(String exp1) {
        this.exp1 = exp1;
    }
    public void setExp2(String exp2) {
        this.exp2 = exp2;
    }
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCreditnumber() {
        return creditnumber;
    }
    public String getExp1() {
        return exp1;
    }
    public String getExp2() {
        return exp2;
    }
    public String getCvv() {
        return cvv;
    }



}
