package edu.iit.cs445.vin.model;

public class Address {
    private String street, city, state, zip;
    
    public Address() {
        this.street = "123 Main ST, Apt 2F";
        this.city = "Anytown";
        this.state = "Anystate";
        this.zip = "12345";
    }
    
    public Address(String street, String city, String state, String zip) {
    	this.street = street;
    	this.city = city;
    	this.state = state;
    	this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
