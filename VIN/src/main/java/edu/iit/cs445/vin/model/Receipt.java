package edu.iit.cs445.vin.model;

import java.util.Date;

public class Receipt {
    int id;
    String name;
    Date date;
    int subId;

    public Receipt() {
    }

    public Receipt(int id, String name, Date date, int subId) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.subId = subId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }
}
