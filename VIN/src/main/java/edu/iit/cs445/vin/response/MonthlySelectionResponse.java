package edu.iit.cs445.vin.response;

import edu.iit.cs445.vin.model.SelectionType;

public class MonthlySelectionResponse {
    int id;
    String selection_month;
    SelectionType type;

    public MonthlySelectionResponse() {
    }

    public MonthlySelectionResponse(int id, String selection_month, SelectionType type) {
        this.id = id;
        this.selection_month = selection_month;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSelection_month() {
        return selection_month;
    }

    public void setSelection_month(String selection_month) {
        this.selection_month = selection_month;
    }

    public SelectionType getType() {
        return type;
    }

    public void setType(SelectionType type) {
        this.type = type;
    }
}
