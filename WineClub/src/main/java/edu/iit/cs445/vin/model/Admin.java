package edu.iit.cs445.vin.model;

import edu.iit.cs445.vin.action.IdGenerator;

/**
 * Created by odrzy_000 on 4/18/2015.
 */
public class Admin {
    private String name;
    private int id;

    public Admin() {
        this.name = "Default Admin";
        this.id = IdGenerator.newID();
    }

    public Admin(String name){
        this.name = name;
        this.id = IdGenerator.newID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
