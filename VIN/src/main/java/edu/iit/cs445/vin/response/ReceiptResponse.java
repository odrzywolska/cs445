package edu.iit.cs445.vin.response;

import java.util.Date;

public class ReceiptResponse {
    int id;
    Date date;
    int subscriber;
    String name;

    public ReceiptResponse() {
    }

    public ReceiptResponse(int id, Date date, int subscriber, String name) {
        this.id = id;
        this.date = date;
        this.subscriber = subscriber;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(int subscriber) {
        this.subscriber = subscriber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
