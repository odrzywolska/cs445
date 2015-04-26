package edu.iit.cs445.vin.response;

import edu.iit.cs445.vin.model.SelectionType;

import java.util.Date;
import java.util.List;

public class MonthlySelectionDetailResponse {

    int id;
    String selection_month;
    SelectionType type;
    Date create_date;
    List<WineResponse> wineResponses;

    public MonthlySelectionDetailResponse() {
    }

    public MonthlySelectionDetailResponse(int id, String selection_month, SelectionType type, Date create_date, List<WineResponse> wineResponses) {
        this.id = id;
        this.selection_month = selection_month;
        this.type = type;
        this.create_date = create_date;
        this.wineResponses = wineResponses;
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

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public List<WineResponse> getWineResponses() {
        return wineResponses;
    }

    public void setWineResponses(List<WineResponse> wineResponses) {
        this.wineResponses = wineResponses;
    }
}
