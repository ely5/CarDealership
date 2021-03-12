package model;

import java.util.Arrays;
import java.util.Objects;

public class User {
	private Membership membership;
	private String username;
	private String password;
	private Offer[] offers;
	private Car[] owned;
	
	public User(Membership member, String username, String password, Offer[] offers, Car[] owned) {
		this.membership = member;
		this.username = username;
		this.password = password;
		this.offers = offers;
		this.owned = owned;
	}

	public User(String username, String password) {
		this.membership = Membership.NON_USER;
		this.username = username;
		this.password = password;
		this.offers = null;
		this.owned = null;
	}

	public User() {}
	public Membership getMembership() {
		return membership;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if (username.length() > 0) {
			this.username = username;
		}
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password.length() > 0) {
			this.password = password;
		}
	}

	public Offer[] getOffers() {
		return offers;
	}

	public void setOffers(Offer[] offers) {
		this.offers = offers;
	}

	public Car[] getOwned() {
		return owned;
	}

	public void setOwned(Car[] owned) {
		this.owned = owned;
	}


	public String toString(){
		return "User: " + username + ", Membership: " + membership.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return membership == user.getMembership() && Objects.equals(username, user.username) 
				&& Objects.equals(password, user.password) && Arrays.equals(offers, user.offers) && Arrays.equals(owned, user.owned);
	}

	@Override
	public int hashCode() {
		return 31 * username.hashCode();
	}
}

