package model;

import java.util.Scanner;

import service.OfferService;

public class Offer {
	
	private int id;
	private User u; 
	private Car c;
	private double offer;
	
	public Offer(int id, User u, Car c, double offer){
		this.id = id;
		this.u = u;
		this.c = c;
		this.offer = offer;
	}
	
	public int getId() {
		return id;
	}
	
	public User getUser() {
		return u;
	}
	
	public Car getCar() {
		return c;
	}
	
	public double getOffer() {
		return offer;
	}
	
	public String toString() {
		return "Customer: " + u.getUsername() + "\tCar: " + c.getID() + 
				"\tMSRP: " + c.getPrice() + "\tOffer Price: $" + offer;

	}
}
