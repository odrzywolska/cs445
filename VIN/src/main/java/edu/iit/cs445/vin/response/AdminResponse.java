package edu.iit.cs445.vin.response;

public class AdminResponse {
    int id;
    String name;

    public AdminResponse() {
    }

    public AdminResponse(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
