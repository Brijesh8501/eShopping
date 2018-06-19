package com.example.yashshah.andoidassignmentyash;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
/**
 * Created by yashshah on 2017-04-21.
 */

public class DatabaseLogin extends SQLiteOpenHelper {

    public  SQLiteDatabase db;
    public DatabaseLogin(Context context)
    {
        super(context, "C0682360_USERACCESS2", null,1);
    }
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE LoginData (id INTEGER PRIMARY KEY, name TEXT NOT NULL," +
                " email TEXT, password TEXT, phone TEXT, dob TEXT , address TEXT)";
        db.execSQL(sql);
        String sql1 = "CREATE TABLE CheckOutData (id INTEGER PRIMARY KEY, name TEXT NOT NULL," +
                " address TEXT , email TEXT,  phone TEXT, Products TEXT)";
        db.execSQL(sql1);

        String sql2 = "CREATE TABLE ProductInsert (id INTEGER PRIMARY KEY, name TEXT NOT NULL," +
                " productid TEXT, aprice TEXT, sprice TEXT)";
        db.execSQL(sql2);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int
            newVersion) {
        String sql = "DROP TABLE IF EXISTS LoginData"; db.execSQL(sql);
        onCreate(db);

    }

    public void dbInsert(Logingetset logingetset) {


        SQLiteDatabase db = getWritableDatabase();

        ContentValues signupData = new ContentValues();
        signupData.put("name", logingetset.getName());
        signupData.put("email", logingetset.getEmail());
        signupData.put("password", logingetset.getPassword());
        signupData.put("phone", logingetset.getPhone());
        signupData.put("dob", logingetset.getDob());
        signupData.put("address", logingetset.getAddress());

/* 0011: Finally call Insert Statement */
        db.insert("Logindata", null, signupData);
    }


    public void proInsert(Productgetset productgetset)
    {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues productData = new ContentValues();

        productData.put("name", productgetset.getName());
        productData.put("productid", productgetset.getProductid());
        productData.put("aprice", productgetset.getActualprice());
        productData.put("sprice", productgetset.getSellingprice());

        db.insert("ProductInsert",null, productData);


    }

    public void dbCheckoutInsert(Logingetset logingetset) {


        SQLiteDatabase db = getWritableDatabase();

        ContentValues signupData = new ContentValues();
        signupData.put("name", logingetset.getName());
        signupData.put("address", logingetset.getAddress());
        signupData.put("email", logingetset.getEmail());
        signupData.put("phone", logingetset.getPhone());
        signupData.put("products", logingetset.getProducts());




/* 0011: Finally call Insert Statement */
        db.insert("CheckOutData", null, signupData);
    }



    public List<Logingetset> searchUser() {

        String sql = "SELECT * FROM LoginData;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        List<Logingetset> userList = new ArrayList<Logingetset>();

        while (c.moveToNext()) {
            Logingetset logingetset = new Logingetset();


            //logingetset.setId(c.getLong(c.getColumnIndex("id")));
            logingetset.setName(c.getString(c.getColumnIndex("name")));
            //logingetset.setAddress(c.getString(c.getColumnIndex("address")));
            //logingetset.setDob(c.getString(c.getColumnIndex("dob")));
            //logingetset.setEmail(c.getString(c.getColumnIndex("email")));
            //logingetset.setPassword(c.getString(c.getColumnIndex("password")));

            userList.add(logingetset);
        }
        c.close();
        return userList;
    }


    public List<String> searchUser2() throws SQLException {
        Statement stmt = null;
        ResultSet rs = stmt.executeQuery("SELECT email FROM LoginData");
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        List<String> userList = new ArrayList<>();
// The column count starts from 1
        for (int i = 1; i <= columnCount; i++) {
            String name = rsmd.getColumnName(i);
            // Do stuff with name

            userList.add(name);
        }
        return userList;

    }


    public String getSinlgeEntry(String fetchemail)
    {
        String password = "";
        Cursor cursor = null;

        cursor = getReadableDatabase().query("LoginData",null,"email=?",new String[]{fetchemail},null,null,null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        password= cursor.getString(cursor.getColumnIndex("password"));
        cursor.close();
        return password;



    }


    public String getName(String fetchemail)
    {
        String name = "";
        Cursor cursor = null;

        cursor = getReadableDatabase().query("LoginData",null,"email=?",new String[]{fetchemail},null,null,null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        name= cursor.getString(cursor.getColumnIndex("name"));
        cursor.close();

        return name;
    }

    public String getAddress(String fetchemail)
    {
        String address = "";
        Cursor cursor = null;

        cursor = getReadableDatabase().query("LoginData",null,"email=?",new String[]{fetchemail},null,null,null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        address= cursor.getString(cursor.getColumnIndex("address"));
        cursor.close();

        return address;
    }

    public String getPhone(String fetchemail)
    {
        String phone = "";
        Cursor cursor = null;

        cursor = getReadableDatabase().query("LoginData",null,"email=?",new String[]{fetchemail},null,null,null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        phone= cursor.getString(cursor.getColumnIndex("phone"));
        cursor.close();

        return phone;
    }


    public String getProductName()
    {

        String name = "";
        String name2 = "";
        Cursor cursor = null;
        cursor = getReadableDatabase().query("ProductInsert",null,null,null,null,null,null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        name= cursor.getString(cursor.getColumnIndex("name"));
        name2= cursor.getString(cursor.getColumnIndex("productid"));
        cursor.close();

        return name;

        /*String sql = "SELECT * FROM ProductInsert;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query("ProductInsert", null,null,null,null,null,null);
        List<Productgetset> userList = new ArrayList<Productgetset>();

        while (c.moveToFirst()) {
            Productgetset productgetset = new Productgetset();


            //logingetset.setId(c.getLong(c.getColumnIndex("id")));
            productgetset.setName(c.getString(c.getColumnIndex("name")));
            productgetset.setActualprice(c.getString(c.getColumnIndex("aprice")));
            productgetset.setSellingprice(c.getString(c.getColumnIndex("sprice")));
            productgetset.setProductid(c.getString(c.getColumnIndex("productid")));

            //logingetset.setAddress(c.getString(c.getColumnIndex("address")));
            //logingetset.setDob(c.getString(c.getColumnIndex("dob")));
            //logingetset.setEmail(c.getString(c.getColumnIndex("email")));
            //logingetset.setPassword(c.getString(c.getColumnIndex("password")));

            userList.add(productgetset);
        }
        c.close();
        return userList;*/



    }

    public  DatabaseLogin open() throws SQLException
    {
        SQLiteDatabase db = getReadableDatabase();
        return this;
    }



    public ArrayList<String> getRecords(){
        ArrayList<String> data=new ArrayList<String>();
        Cursor cursor = db.query("ProductInsert", new String[]{"column names"},null, null, null, null, null);
        String fieldToAdd=null;
        while(cursor.moveToNext()){
            fieldToAdd=cursor.getString(0);
            data.add(fieldToAdd);
        }
        cursor.close();  // dont forget to close the cursor after operation done
        return data;
    }




}



