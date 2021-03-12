package model;

public enum Membership {
	
	NON_USER(0),
	USER(1),
	CUSTOMER(2),
	EMPLOYEE(3);
	
	private int value;
	
	Membership(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
