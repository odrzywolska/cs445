package edu.iit.cs445.vin.model;

import java.util.Date;
import java.util.List;

public class MonthlySelection {
    int id;
    String selection_month;
    SelectionType type;
    List<Wine> wines;
    Date create_date;

    public MonthlySelection() {
    }

    public MonthlySelection(int id, String selection_month, SelectionType type, List<Wine> wines, Date create_date) {
        this.id = id;
        this.selection_month = selection_month;
        this.type = type;
        this.wines = wines;
        this.create_date = create_date;
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

    public List<Wine> getWines() {
        return wines;
    }

    public void setWines(List<Wine> wines) {
        this.wines = wines;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
}
