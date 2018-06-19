package com.example.yashshah.andoidassignmentyash;

import android.widget.EditText;

/**
 * Created by yashshah on 2017-11-29.
 */

public class ProductInsertHelper {

    private final EditText name;
    private final EditText productid;
    private final EditText actualprice;
    private final EditText sellingprice;

    private Productgetset productgetset;

    public ProductInsertHelper(ProductInsert activity) {
        name = (EditText) activity.findViewById(R.id.name);
        productid = (EditText) activity.findViewById(R.id.productid);
        actualprice = (EditText) activity.findViewById(R.id.aprice);
        sellingprice = (EditText) activity.findViewById(R.id.sprice);


        productgetset = new Productgetset();

    }

    public Productgetset pickupStudent() {
        productgetset.setName(name.getText().toString());
        productgetset.setProductid(productid.getText().toString());
        productgetset.setActualprice(actualprice.getText().toString());
        productgetset.setSellingprice(sellingprice.getText().toString());



        return productgetset;
    }
}
