package edu.iit.cs445.vin.data;

import edu.iit.cs445.vin.model.Admin;
import java.util.Collection;

public class AdminData {

    public static Collection<Admin> getAdmins() {
        return DataLoader.data.admins;
    }

    public static void load(){
        DataLoader.load();
    }

    public static void save() {
        DataLoader.save();
    }

}
