package edu.iit.cs445.vin.model;

/**
 * Created by odrzy_000 on 4/3/2015.
 */
public class GenericResponse {
    private boolean status;
    private String failureDescription;

    public GenericResponse(boolean s, String f) {
        this.status = s;
        this.failureDescription = f;
    }

    public void printResponse() {
        System.out.println("Status: " + this.status + "\tDescription: " + this.failureDescription);
    }

    public boolean isStatus() {
        return status;
    }

    public String getFailureDescription() {
        return failureDescription;
    }
}
