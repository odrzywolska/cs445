package edu.iit.cs445.vin.rest.requests;

import edu.iit.cs445.vin.model.Address;

/**
 * Created by odrzy_000 on 4/18/2015.
 */
public class SubscriberRequest {
    private String name, email, phone, twitter, facebook;
    private Address address;

    public SubscriberRequest(){

    }


    public SubscriberRequest(String name, String email, String phone, String twitter, String facebook, Address address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.twitter = twitter;
        this.facebook = facebook;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubscriberRequest that = (SubscriberRequest) o;

        if (email != null ? !email.equals(that.email) : that.email != null)
            if (phone != null ? !phone.equals(that.phone) : that.phone != null)
                return false;
            else
                return true;
        else
            return true;
    }
}
