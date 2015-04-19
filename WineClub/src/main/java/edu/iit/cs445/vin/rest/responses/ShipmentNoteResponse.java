package edu.iit.cs445.vin.rest.responses;

import java.util.Date;

/**
 * Created by odrzy_000 on 4/18/2015.
 */
public class ShipmentNoteResponse {
    int id;
    Date date;
    String note;

    public ShipmentNoteResponse() {
    }

    public ShipmentNoteResponse(int id, Date date, String note) {
        this.id = id;
        this.date = date;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
