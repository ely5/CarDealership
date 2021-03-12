package UI;

import java.util.Optional;
import java.util.Scanner;

import db.UserDao;
import model.Car;
import model.Membership;
import model.User;
import service.CarService;
import service.OfferService;
import service.PaymentService;
import service.UserService;

public class UserScreen {

	UserDao ud;

	UserService us = new UserService(ud);

	protected void Execution(Scanner s) {
		while (true) {
			System.out.print("\r\nDo you have an account? (y/n) ");
			String str = s.nextLine().replaceAll("\\s", "");
			if (str.equalsIgnoreCase("y")) {
				userLogin(s);
			}
			if (str.equalsIgnoreCase("n")) {
				createAccount(s);
			}
		}
	}

	private void userLogin(Scanner s) {
		while (true) {
			System.out.print("Please enter your username: ");
			String username = s.nextLine().replaceAll("\\s", "");
			System.out.print("Please enter your password: ");
			String password = s.nextLine().replaceAll("\\s", "");
				
			if (us.doesUsernameExist(username)){
				if ((UserService.getMap().get(username).getPassword()).equals(password)) {
					System.out.println("Successfully logged in!");
					if (UserService.getMap().get(username).getMembership().equals(Membership.CUSTOMER)) {
						customerScreen(s);
					}
					else {
						Membership m = obtainMemberShip(s);
						UserService.getMap().get(username).setMembership(m);
						Execution(s);
					}
				}
			}
			
			System.out.println("Invalid credentials.");
			break;
		}
	}

	private void createAccount(Scanner s) {
		boolean temp = true;
		while (temp) {
			System.out.print("Please create a username: ");
			String username = s.nextLine().replaceAll("\\s", "");

			if (us.doesUsernameExist(username)) {
				System.out.print("Username already taken.");
				continue;
			} else {
				System.out.print("Please create a password: ");
				String password = s.nextLine().replaceAll("\\s", "");
				User u = new User(username, password);
				System.out.println("Account created!");
				UserService.getMap().put(username, u);
				u.setMembership(Membership.USER);
				temp = false;
			}
		}
		System.out.println(UserService.getMap());
		userLogin(s);
	}

	private static Membership obtainMemberShip(Scanner s) {
		while (true) {
			System.out.print("Would you like to become a customer? (y/n) ");
			String str = s.nextLine().replaceAll("\\s", "");
			if (str.equalsIgnoreCase("y")) {
				return Membership.CUSTOMER;
			}
			if (str.equalsIgnoreCase("n")) {
				return Membership.USER;
			}
		}
	}

	private void customerScreen(Scanner s) {
		System.out.println(UserService.getMap());
		while(true) {
			System.out.println("Welcome. What operation would you like to perform?\r\n"
					+ "'v' = view cars\r\n"
					+ "'o' = make an offer\r\n"
					+ "'p' = payment history\r\n"
					+ "'e' = exit\r\n");
			
				switch (s.nextLine().replaceAll("\\s", "")) {
					case "v":
						System.out.print(CarService.getMap());
						break;
					case "o":
						System.out.print("Enter the ID number of the car you would like to make an offer for: ");
						Integer carID = (Integer)s.nextInt();
						Car choice = CarService.getMap().get(carID);
						break;
					case "p":
						System.out.print("payments");
						break;
					case "e":
						Execution(s);
				}
			}
	}

}