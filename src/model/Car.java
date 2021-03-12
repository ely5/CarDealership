package model;

public class Car {
	private String make;
	private String model;
	private int year;
	private double price;
	private double owed;
	private int id;
	
	public Car()
	{
		id = 0;
		make = null;
		model = null;
		year = 0;
		price = 0;
		owed = 0;
	}
	
	public Car(int id, String make, String model, int year, double price, double owed)
	{
		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
		this.owed = owed;
	}
	
	public int getID() {
		return id;
	}
	
	public String getMake() {
		return make;
	}
	
	public String getModel() {
		return model;
	}
	
	public int getYear() {
		return year;
	}
	
	public double getPrice() {
		return price;
	}
	
	public double getOwed() {
		return owed;
	}
	
	public String toString() {
		return "ID: " + id + "\tMake: " + make + "\tModel: " + model + "\tYear: " + year + "\tPrice: $" + price;
	}
}
