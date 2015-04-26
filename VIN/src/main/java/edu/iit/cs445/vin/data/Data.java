package edu.iit.cs445.vin.data;

import edu.iit.cs445.vin.model.Admin;
import edu.iit.cs445.vin.model.MonthlySelection;
import edu.iit.cs445.vin.model.Receipt;
import edu.iit.cs445.vin.model.Subscriber;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;


public class Data {

    public AtomicInteger nextID = new AtomicInteger(0);
    public Collection<Admin> admins = new ArrayList<Admin>();
    public Collection<MonthlySelection> monthlySelections = new ArrayList<MonthlySelection>();
    public Collection<Receipt> receipts = new ArrayList<Receipt>();
    public Collection<Subscriber> subscribers = new ArrayList<Subscriber>();

    public Data() {
    }

    public AtomicInteger getNextID() {
        return nextID;
    }

    public void setNextID(AtomicInteger nextID) {
        this.nextID = nextID;
    }

    public Collection<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(Collection<Admin> admins) {
        this.admins = admins;
    }

    public Collection<MonthlySelection> getMonthlySelections() {
        return monthlySelections;
    }

    public void setMonthlySelections(Collection<MonthlySelection> monthlySelections) {
        this.monthlySelections = monthlySelections;
    }

    public Collection<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(Collection<Receipt> receipts) {
        this.receipts = receipts;
    }

    public Collection<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Collection<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }
}
