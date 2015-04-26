package edu.iit.cs445.vin.response;


import edu.iit.cs445.vin.model.Error;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {

    List<Error> errors = new ArrayList<Error>();

    public ErrorResponse() {
    }

    public ErrorResponse(List<Error> errors) {
        this.errors = errors;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}
