package com.pq.domain;

public class Order {

    private   Integer  id ;
    private   String ordername; //名称
    private   String orderdec; //描述

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public String getOrderdec() {
        return orderdec;
    }

    public void setOrderdec(String orderdec) {
        this.orderdec = orderdec;
    }

    public Order(Integer id, String ordername, String orderdec) {
        this.id = id;
        this.ordername = ordername;
        this.orderdec = orderdec;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ordername='" + ordername + '\'' +
                ", orderdec='" + orderdec + '\'' +
                '}';
    }
}
