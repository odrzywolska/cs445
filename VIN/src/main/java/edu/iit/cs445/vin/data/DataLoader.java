package edu.iit.cs445.vin.data;

import edu.iit.cs445.vin.model.Admin;
import edu.iit.cs445.vin.model.MonthlySelection;
import edu.iit.cs445.vin.model.Receipt;
import edu.iit.cs445.vin.model.Subscriber;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class DataLoader {

    public static final String fileName = "sylwia-odrzywolska.ser";

    public static Data data = new Data();

    public static void load(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            data = mapper.readValue(new File(fileName), Data.class);
        } catch (Exception e) {
            //e.printStackTrace();
            data.nextID = new AtomicInteger(0);
            data.admins = new ArrayList<Admin>();
            data.monthlySelections = new ArrayList<MonthlySelection>();
            data.receipts = new ArrayList<Receipt>();
            data.subscribers = new ArrayList<Subscriber>();
        }
    }

    public static void save() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(fileName), data);
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

}
