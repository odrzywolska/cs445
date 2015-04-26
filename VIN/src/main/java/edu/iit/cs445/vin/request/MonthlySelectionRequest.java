package edu.iit.cs445.vin.request;

import edu.iit.cs445.vin.model.SelectionType;
import edu.iit.cs445.vin.model.Wine;

import java.util.List;

public class MonthlySelectionRequest {
    SelectionType type;
    String selection_month;
    List<Wine> wines;

    public MonthlySelectionRequest() {
    }

    public MonthlySelectionRequest(SelectionType type, String selection_month, List<Wine> wines) {
        this.type = type;
        this.selection_month = selection_month;
        this.wines = wines;
    }

    public SelectionType getType() {
        return type;
    }

    public void setType(SelectionType type) {
        this.type = type;
    }

    public String getSelection_month() {
        return selection_month;
    }

    public void setSelection_month(String selection_month) {
        this.selection_month = selection_month;
    }

    public List<Wine> getWines() {
        return wines;
    }

    public void setWines(List<Wine> wines) {
        this.wines = wines;
    }
}
