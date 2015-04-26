package edu.iit.cs445.vin.response;

import edu.iit.cs445.vin.model.Note;

import java.util.List;

public class WineResponse {
    int id;
    String label_name;
    List<Note> notes;

    public WineResponse() {
    }

    public WineResponse(int id, String label_name, List<Note> notes) {
        this.id = id;
        this.label_name = label_name;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel_name() {
        return label_name;
    }

    public void setLabel_name(String label_name) {
        this.label_name = label_name;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
