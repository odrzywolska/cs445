package edu.iit.cs445.vin.model;


import edu.iit.cs445.vin.action.IdGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Subscriber {
    private String name, email, phone, twitter, facebook;
    private Address address;
    private int ID;
	private List<Delivery> deliveryHistory = new ArrayList<Delivery>();
    private Delivery delivery;
	private Payment payment;
	private boolean active;

    public Subscriber() {
    	this.name = "Jane Doe";
    	this.email = "jane.doe@example.com";
    	this.phone = "1234567890";
    	this.address = new Address();
    	this.ID = IdGenerator.newID();
		this.delivery = new Delivery(this);
		this.payment = new Payment();
		this.active = true;
    }

    public Subscriber (String name, String email, String phone, Address address, String creditCardNum) {
    	this.name = name;
    	this.email = email;
    	this.phone = phone.replaceAll("[\\s\\-()]", ""); // drop all non-digit characters
    	this.address = address;
    	this.delivery = new Delivery(this);
    	this.ID = IdGenerator.newID();
		this.payment = new Payment(creditCardNum);
		this.active = true;
    }

    public Subscriber (String name, String email, String phone, Address address, String fb, String tw, String creditCardNum) {
    	this.name = name;
    	this.email = email;
    	this.phone = phone.replaceAll("[\\s\\-()]", ""); // drop all non-digit characters
    	this.address = address;
    	this.twitter = tw;
    	this.facebook = fb;
    	this.delivery = new Delivery(this);
    	this.ID = IdGenerator.newID();
		this.payment = new Payment(creditCardNum);
		this.active = true;
	}

    private boolean isMatchName(String kw) {
    	String regex = "(?i).*" + kw + ".*";
    	return this.name.matches(regex);
    }

    private boolean isMatchEmail(String kw) {
    	String regex = "(?i).*" + kw + ".*";
    	return this.email.matches(regex);
    }

    private boolean isMatchPhone(String kw) {
    	String s = kw.replaceAll("[\\s\\-()]", ""); // drop all non-digit characters from search string
    	String regex = "(?i).*" + s + ".*";
    	return this.phone.matches(regex);
    }

    public boolean isMatch(String kw) {
    	if (isMatchName(kw) || isMatchEmail(kw) || isMatchPhone(kw)) {
    		return true;
    	} else return false;
    }

	public Payment getPayment() {
		return payment;
	}

	public String getEmail(){
		return this.email;
	}

	public String getName(){
		return this.name;
	}

	public String getPhone() {
		return phone;
	}

	public int getID() {
    	return this.ID;
    }

	public boolean isActive() { return this.active; }

    public void updateInfo(String name, String email, String phone, Address address, String creditCardNum) {
    	this.name = name;
    	this.email = email;
    	this.phone = phone;
    	this.address = address;
		this.payment.updateCard(creditCardNum);
    }

	public void updateOrderPreference(MonthlySelectionType mst, int q){
		this.delivery.updateOrder(mst, q);
	}

	public void updateOrderOnce(MonthlySelectionType mst, int q){
		deliveryHistory.get(deliveryHistory.size()-1).updateOrder(mst, q);
	}

	public void updateDeliveryPreference(Date date){
		this.delivery.setDeliveryDate(date);
	}

	public void updateDeliveryOnce(Date date){
		deliveryHistory.get(deliveryHistory.size()-1).setDeliveryDate(date);
	}

	public List<Delivery> getDeliveryHistory(){
		return deliveryHistory;
	}

	public void addDelivery(Delivery newDelivery){
		deliveryHistory.add(newDelivery);
	}

	public void cancelSubscription(){
		this.active = false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Subscriber)) return false;

		Subscriber that = (Subscriber) o;

		if (ID != that.ID) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return ID;
	}
}
