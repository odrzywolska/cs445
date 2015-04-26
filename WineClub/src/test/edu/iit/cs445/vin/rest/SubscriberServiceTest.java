package edu.iit.cs445.vin.rest;

import edu.iit.cs445.vin.data.SubscribersData;
import edu.iit.cs445.vin.model.Address;
import edu.iit.cs445.vin.model.Delivery;
import edu.iit.cs445.vin.model.Subscriber;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by odrzy_000 on 4/18/2015.
 */
public class SubscriberServiceTest {

    @Before
    public void setUp() throws Exception {
//create a bunch of subscribers to do tests on
        Address adr = new Address("111 N Main St","Chicago","IL","60611");
        Subscriber subA = new Subscriber("Abc Def", "abd@def.com","7735551111",adr);
        subA.addDelivery(new Delivery(subA));
        SubscribersData.getSubs().add(subA);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCreateSub() throws Exception {

    }

    @Test
    public void testUpdateSub() throws Exception {

    }

    @Test
    public void testGetSub() throws Exception {

    }

    @Test
    public void testGetShipments() throws Exception {

    }

    @Test
    public void testGetShip() throws Exception {

    }

    @Test
    public void testGetShipNote() throws Exception {

    }

    @Test
    public void testSetShipNote() throws Exception {

    }

    @Test
    public void testGetDelInfo() throws Exception {

    }

    @Test
    public void testGetDelInfo1() throws Exception {

    }
}