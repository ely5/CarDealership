package UI;

import java.util.Scanner;

import model.Offer;
import service.CarService;
import service.OfferService;
import service.PaymentService;

public class EmployeeScreen {
	
	protected void Execution(Scanner s) {
		
		while(true) {
		System.out.println("Welcome. What operation would you like to perform?\r\n'a' = add a car\r\n"
				+ "'r' = remove a car\r\n"
				+ "'o' = view all offers\r\n"
				+ "'v' = view all payments\r\n");
		
			switch (s.nextLine().replaceAll("\\s", "")) {
				case "a":
					CarService.add(s);
					break;
				case "r":
					CarService.remove(s);
					break;
				case "o":
					OfferService.viewOffers();
					break;
				case "v":
					PaymentService.Execution(s);
					break;
			}
		}
	}
}
