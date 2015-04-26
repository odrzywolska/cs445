package edu.iit.cs445.vin.response;

import java.util.List;

public class DeliveriesResponse {

    List<DeliverToResponse> deliver_to;

    public DeliveriesResponse() {
    }

    public DeliveriesResponse(List<DeliverToResponse> deliver_to) {
        this.deliver_to = deliver_to;
    }

    public List<DeliverToResponse> getDeliver_to() {
        return deliver_to;
    }

    public void setDeliver_to(List<DeliverToResponse> deliver_to) {
        this.deliver_to = deliver_to;
    }
}
