package edu.iit.cs445.vin.response;

import java.util.List;

public class ShipmentsResponse {

    List<ShipmentResponse> shipments;

    public ShipmentsResponse() {
    }

    public ShipmentsResponse(List<ShipmentResponse> shipments) {
        this.shipments = shipments;
    }

    public List<ShipmentResponse> getShipments() {
        return shipments;
    }

    public void setShipments(List<ShipmentResponse> shipments) {
        this.shipments = shipments;
    }
}
