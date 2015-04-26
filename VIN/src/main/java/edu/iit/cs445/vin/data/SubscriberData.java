package edu.iit.cs445.vin.data;

import edu.iit.cs445.vin.model.Subscriber;
import java.util.Collection;

public class SubscriberData {

    public static Collection<Subscriber> getSubscribers(){
        return DataLoader.data.subscribers;
    }

    public static void load(){
        DataLoader.load();
    }

    public static void save() {
        DataLoader.save();
    }
}
