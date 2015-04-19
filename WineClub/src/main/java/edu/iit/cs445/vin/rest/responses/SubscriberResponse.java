package edu.iit.cs445.vin.rest.responses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by odrzy_000 on 4/18/2015.
 */
public class SubscriberResponse {
    int id;
    List<String> errors = new ArrayList<>();

    public SubscriberResponse() {
    }

    public SubscriberResponse(int id, List<String> errors) {
        this.id = id;
        this.errors = errors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
