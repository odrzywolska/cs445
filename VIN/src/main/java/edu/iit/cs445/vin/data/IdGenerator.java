package edu.iit.cs445.vin.data;

public class IdGenerator {

    public synchronized static int newID() {
        //DataLoader.load();
        int id = DataLoader.data.nextID.getAndIncrement();
        //DataLoader.save();
        return id;
    }
}