package UI;
import java.util.*;

import db.CarDao;
import model.Car;
import service.CarService;
import util.MyHashMap;

public class Login {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		CarDao cd = new CarDao();
		CarService cs = new CarService(cd);
		System.out.println(cs.makeCar(101, "Jeep", "Cherokee", 2008, 6000.99, 6000.99));
		System.out.println(cs.makeCar(110, "Nissan", "Altima", 2004, 16000.99, 16000.99));
		System.out.println(cs.makeCar(210, "Ford", "Escape", 2012, 15000.99, 15000.99));
		System.out.println(CarService.getMap());
		
		while(true) {
			System.out.print("Welcome! Press key 'u' for user or 'e' for employee: ");
			
			String choice = scan.nextLine().replaceAll("\\s","");
			if (choice.equalsIgnoreCase("u")){
				UserScreen us = new UserScreen();
				System.out.print("Welcome to the Car Dealership! Would you like to proceed? (y/n) ");
				String s = scan.nextLine().replaceAll("\\s","");
				if (s.equalsIgnoreCase("n")) { continue;}
				us.Execution(scan);
			}
			if (choice.equalsIgnoreCase("e")){
				EmployeeScreen es = new EmployeeScreen();
				System.out.print("Welcome, Car Dealership Employee. Would you like to proceed? (y/n) ");
				String s = scan.nextLine().replaceAll("\\s","");
				if (s.equalsIgnoreCase("n")) { continue;}
				es.Execution(scan);
			}
		}
	}
}
