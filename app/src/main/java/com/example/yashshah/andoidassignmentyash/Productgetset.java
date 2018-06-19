package com.example.yashshah.andoidassignmentyash;

import java.io.Serializable;

/**
 * Created by yashshah on 2017-11-29.
 */

public class Productgetset implements Serializable {


    private Long id;
    private String name;
    private String actualprice;
    private String sellingprice;
    private String productid;



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
    public  String getActualprice() {
        return actualprice;
    }

    public String setActualprice(String actualprice) {
        this.actualprice = actualprice;
        return actualprice;
    }

    public String getSellingprice() {
        return sellingprice;
    }

    public void setSellingprice(String sellingprice) {
        this.sellingprice = sellingprice;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }



    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

}
