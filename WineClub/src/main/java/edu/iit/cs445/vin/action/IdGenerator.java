package edu.iit.cs445.vin.action;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
	private static AtomicInteger nextID = new AtomicInteger();

	public static int newID() {
		return nextID.getAndIncrement();
	}

}
