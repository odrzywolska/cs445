package edu.iit.cs445.vin.response;

import edu.iit.cs445.vin.model.Note;

import java.util.List;

public class NotesResponse {
    List<Note> notes;

    public NotesResponse() {
    }

    public NotesResponse(List<Note> notes) {
        this.notes = notes;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
