package edu.iit.cs445.vin.model;

import java.util.List;

public class Shipment {

    int id;
    String month;
    String year;
    DeliveryStatus deliveryStatus;
    SelectionType selectionType;
    List<Wine> wines;
    String deliveryDay;
    String deliveryTime;
    List<Note> notes;

    public Shipment() {
    }

    public Shipment(int id, String month, String year, DeliveryStatus deliveryStatus, SelectionType selectionType, List<Wine> wines, String deliveryDay, String deliveryTime) {
        this.id = id;
        this.month = month;
        this.year = year;
        this.deliveryStatus = deliveryStatus;
        this.selectionType = selectionType;
        this.wines = wines;
        this.deliveryDay = deliveryDay;
        this.deliveryTime = deliveryTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public SelectionType getSelectionType() {
        return selectionType;
    }

    public void setSelectionType(SelectionType selectionType) {
        this.selectionType = selectionType;
    }

    public List<Wine> getWines() {
        return wines;
    }

    public void setWines(List<Wine> wines) {
        this.wines = wines;
    }

    public String getDeliveryDay() {
        return deliveryDay;
    }

    public void setDeliveryDay(String deliveryDay) {
        this.deliveryDay = deliveryDay;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}

