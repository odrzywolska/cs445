package edu.iit.cs445.vin.boundary;

import edu.iit.cs445.vin.model.AddSubscriberResponse;
import edu.iit.cs445.vin.model.Subscriber;

import java.util.Collection;

// Boundary class for a request to add a subscriber
public abstract class AddSubscriberRequest {
	protected String street, city, state, zip;
	protected String name, email, phone, twitter, facebook, creditCard;
	
	public AddSubscriberRequest(String street, String c, String state, String z, String n, String e, String p, String tw, String fb, String cc) {
		this.street = street;
		this.city = c;
		this.state = state;
		this.zip = z;
		this.name = n;
		this.email = e;
		this.phone = p;
		this.twitter = tw;
		this.facebook = fb;
		this.creditCard = cc;
	}
	
	public abstract AddSubscriberResponse addAccount(Collection<Subscriber> subs);
}
