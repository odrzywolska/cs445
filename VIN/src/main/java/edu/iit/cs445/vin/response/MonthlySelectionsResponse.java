package edu.iit.cs445.vin.response;

import java.util.List;

public class MonthlySelectionsResponse {
    List<MonthlySelectionResponse> monthly_selection;

    public MonthlySelectionsResponse() {
    }

    public MonthlySelectionsResponse(List<MonthlySelectionResponse> monthly_selection) {
        this.monthly_selection = monthly_selection;
    }

    public List<MonthlySelectionResponse> getMonthly_selection() {
        return monthly_selection;
    }

    public void setMonthly_selection(List<MonthlySelectionResponse> monthly_selection) {
        this.monthly_selection = monthly_selection;
    }
}
