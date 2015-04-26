package edu.iit.cs445.vin.request;

import edu.iit.cs445.vin.model.Address;

public class SubscriberRequest {

    String email, name, phone, facebook, twitter;
    Address address;

    public SubscriberRequest() {
    }

    public SubscriberRequest(String email, String name, String phone, String facebook, String twitter, Address address) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.facebook = facebook;
        this.twitter = twitter;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
