package edu.iit.cs445.vin.data;

import edu.iit.cs445.vin.model.Subscriber;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by odrzy_000 on 4/18/2015.
 */
public class SubscribersData {
    private static Collection<Subscriber> allSubs = new ArrayList<>();
    public static Collection<Subscriber> getSubs(){
        return allSubs;
    }
}
