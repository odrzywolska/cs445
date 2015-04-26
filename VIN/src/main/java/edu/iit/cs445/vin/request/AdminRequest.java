package edu.iit.cs445.vin.request;

public class AdminRequest {
    String name;

    public AdminRequest() {
    }

    public AdminRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
