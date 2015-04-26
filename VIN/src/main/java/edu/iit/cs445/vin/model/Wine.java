package edu.iit.cs445.vin.model;

import java.util.List;

public class Wine {
    int id;
    String label_name;
    List<Note> notes;
    String variety;
    String wine_type;
    String grape;
    String region;
    String country;
    String maker;
    int year;


    public Wine() {
    }

    public Wine(int id, String label_name, List<Note> notes) {
        this.id = id;
        this.label_name = label_name;
        this.notes = notes;
    }

    public Wine(int id, String label_name, List<Note> notes, String variety, String wine_type, String grape, String region, String country, String maker, int year) {
        this.id = id;
        this.label_name = label_name;
        this.notes = notes;
        this.variety = variety;
        this.wine_type = wine_type;
        this.grape = grape;
        this.region = region;
        this.country = country;
        this.maker = maker;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel_name() {
        return label_name;
    }

    public void setLabel_name(String label_name) {
        this.label_name = label_name;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getWine_type() {
        return wine_type;
    }

    public void setWine_type(String wine_type) {
        this.wine_type = wine_type;
    }

    public String getGrape() {
        return grape;
    }

    public void setGrape(String grape) {
        this.grape = grape;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
