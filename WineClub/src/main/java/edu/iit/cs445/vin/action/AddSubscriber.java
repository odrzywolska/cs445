package edu.iit.cs445.vin.action;

import edu.iit.cs445.vin.boundary.AddSubscriberRequest;
import edu.iit.cs445.vin.model.AddSubscriberResponse;
import edu.iit.cs445.vin.model.Address;
import edu.iit.cs445.vin.model.Subscriber;

import java.util.Collection;

public class AddSubscriber extends AddSubscriberRequest {
	private Address a;
	private Subscriber s;

	public AddSubscriber(String street, String city, String state, String zip,
						 String name, String email, String phone, String tw, String fb, String cc) {
		super(street, city, state, zip, name, email, phone, tw, fb, cc);
	}

	@Override
	public AddSubscriberResponse addAccount(Collection<Subscriber> subs) {
		a = new Address(this.street, this.city, this.state, this.zip);
		s = new Subscriber(this.name, this.email, this.phone, a, this.facebook, this.twitter, this.creditCard);
		
		if (addressInBannedState()) {
			return new AddSubscriberResponse(0, false, "Cannot ship to this state");
		}
		
		if (userHasAccount(subs, s)) {
			return new AddSubscriberResponse(0, false, "User already has an account");
		} else {
			subs.add(s);
			return new AddSubscriberResponse(s.getID(), true, "Congratulations, your account has been created");
		}
	}
	
	private boolean userHasAccount(Collection<Subscriber> subs, Subscriber sub) {
		for(Subscriber s:subs){
			if(s.isMatch(sub.getName()) || s.isMatch(sub.getEmail()) || s.isMatch(sub.getPhone())){
				return true;
			}
		}
		return false;
	}
	
	private boolean addressInBannedState() {
		return false;
	}
	
}
