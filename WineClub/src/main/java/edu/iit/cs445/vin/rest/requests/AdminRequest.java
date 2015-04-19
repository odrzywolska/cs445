package edu.iit.cs445.vin.rest.requests;

/**
 * Created by odrzy_000 on 4/18/2015.
 */
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
