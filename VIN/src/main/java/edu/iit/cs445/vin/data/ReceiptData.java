package edu.iit.cs445.vin.data;

import edu.iit.cs445.vin.model.Receipt;
import java.util.Collection;

public class ReceiptData {

    public static Collection<Receipt> getReceipts(){
        return DataLoader.data.receipts;
    }

    public static void load(){
        DataLoader.load();
    }

    public static void save() {
        DataLoader.save();
    }
}
