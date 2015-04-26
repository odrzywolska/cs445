package edu.iit.cs445.vin.data;

import edu.iit.cs445.vin.model.*;
import org.junit.Before;
import org.junit.Test;

import java.io.FileOutputStream;
import java.util.*;

import static org.junit.Assert.*;

public class DataLoaderTest {

    @Before
    public void setUp() throws Exception {
        //create an empty file
        FileOutputStream output = new FileOutputStream(DataLoader.fileName, false);
        output.close();
    }

    @Test
    public void testLoadData() throws Exception {

        DataLoader.load();
        Collection<Admin> admins = AdminData.getAdmins();
        Collection<MonthlySelection> monthlySelections = MonthlySelectionData.getMonthlySelections();
        Collection<Receipt> receipts = ReceiptData.getReceipts();
        Collection<Subscriber> subscribers = SubscriberData.getSubscribers();

        Admin admin = new Admin(IdGenerator.newID(), "Admin");
        MonthlySelection monthlySelection = new MonthlySelection(IdGenerator.newID(), "Jan", SelectionType.RW,
                Arrays.asList(new Wine(IdGenerator.newID(), "TestWine",
                        Arrays.asList(new Note(IdGenerator.newID(), new Date(0), "Test Message")))), new Date(0));
        Subscriber subscriber = new Subscriber("test@test.com", "TestName", "555-1234", "testFacebook", "testTwitter",
                new Address("123 Main St", "Anytown", "IL", "12345"));
        Receipt receipt = new Receipt(IdGenerator.newID(), "Some Name", new Date(0), subscriber.getId());

        admins.add(admin);
        monthlySelections.add(monthlySelection);
        subscribers.add(subscriber);
        receipts.add(receipt);

        DataLoader.save();

        admins.clear();
        monthlySelections.clear();
        receipts.clear();
        subscribers.clear();

        DataLoader.load();

        List<Admin> admins1 = (List<Admin>) AdminData.getAdmins();
        List<MonthlySelection> monthlySelections1 = (List<MonthlySelection>) MonthlySelectionData.getMonthlySelections();
        List<Receipt> receipts1 = (List<Receipt>) ReceiptData.getReceipts();
        List<Subscriber> subscribers1 = (List<Subscriber>) SubscriberData.getSubscribers();

        assertEquals(admins1.get(0).getId(), admin.getId());
        assertEquals(monthlySelections1.get(0).getId(), monthlySelection.getId());
        assertEquals(receipts1.get(0).getId(), receipt.getId());
        assertEquals(subscribers1.get(0).getId(), subscriber.getId());

    }


}