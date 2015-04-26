package edu.iit.cs445.vin.response;

import edu.iit.cs445.vin.model.Error;

import java.util.ArrayList;
import java.util.List;

public class IdErrorResponse {
    int id;
    List<Error> errors = new ArrayList<Error>();

    public IdErrorResponse() {
    }

    public IdErrorResponse(int id, List<Error> errors) {
        this.id = id;
        this.errors = errors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}
