package edu.iit.cs445.vin.request;

public class ReceiptRequest {
    String name;

    public ReceiptRequest() {
    }

    public ReceiptRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
