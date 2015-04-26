package edu.iit.cs445.vin.response;

import edu.iit.cs445.vin.model.Address;
import edu.iit.cs445.vin.model.SelectionType;

public class DeliverToResponse {

    String name;
    String phone;
    String email;
    Address address;
    String dow;
    String tod;
    SelectionType type;

    public DeliverToResponse() {
    }

    public DeliverToResponse(String name, String phone, String email, Address address, String dow, String tod, SelectionType type) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dow = dow;
        this.tod = tod;
        this.type = type;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
