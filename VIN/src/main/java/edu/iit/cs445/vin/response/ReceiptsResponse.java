package edu.iit.cs445.vin.response;

import java.util.List;

public class ReceiptsResponse {

    List<ReceiptResponse> receipts;

    public ReceiptsResponse() {
    }

    public ReceiptsResponse(List<ReceiptResponse> receipts) {
        this.receipts = receipts;
    }

    public List<ReceiptResponse> getReceipts() {
        return receipts;
    }

    public void setReceipts(List<ReceiptResponse> receipts) {
        this.receipts = receipts;
    }
}
