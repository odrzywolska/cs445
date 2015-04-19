package edu.iit.cs445.vin.rest.responses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by odrzy_000 on 4/18/2015.
 */
public class GenericResponse {
    List<String> errors = new ArrayList<>();

    public GenericResponse() {
    }

    public GenericResponse(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
