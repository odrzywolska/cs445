package edu.iit.cs445.vin.data;

import edu.iit.cs445.vin.model.Admin;
import edu.iit.cs445.vin.model.Subscriber;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by odrzy_000 on 4/18/2015.
 */
public class AdminData {
    private static Collection<Admin> allAdmins = new ArrayList<>();
    public static Collection<Admin> getAdmins(){
        return allAdmins;
    }
}
