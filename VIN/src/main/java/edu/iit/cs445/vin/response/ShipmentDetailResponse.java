package edu.iit.cs445.vin.response;

import edu.iit.cs445.vin.model.DeliveryStatus;
import edu.iit.cs445.vin.model.SelectionType;
import edu.iit.cs445.vin.model.Wine;

import java.util.List;

public class ShipmentDetailResponse {
    String selection_month;
    DeliveryStatus status;
    SelectionType type;
    List<Wine> wines;

    public ShipmentDetailResponse() {
    }

    public ShipmentDetailResponse(String selection_month, DeliveryStatus status, SelectionType type, List<Wine> wines) {
        this.selection_month = selection_month;
        this.status = status;
        this.type = type;
        this.wines = wines;
    }

    public String getSelection_month() {
        return selection_month;
    }

    public void setSelection_month(String selection_month) {
        this.selection_month = selection_month;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
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
}

