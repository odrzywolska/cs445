package edu.iit.cs445.vin.model;

public class Delivery {
    String dow;
    String tod;
    SelectionType type = SelectionType.RW;

    public Delivery() {
    }

    public Delivery(String dow, String tod) {
        this.dow = dow;
        this.tod = tod;
    }

    public String getDow() {
        return dow;
    }

    public void setDow(String dow) {
        this.dow = dow;
    }

    public String getTod() {
        return tod;
    }

    public void setTod(String tod) {
        this.tod = tod;
    }

    public SelectionType getType() {
        return type;
    }

    public void setType(SelectionType type) {
        this.type = type;
    }
}
