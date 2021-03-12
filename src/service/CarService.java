package service;

import model.Car;
import model.User;
import util.MyHashMap;

import java.util.Scanner;

import db.CarDao;

public class CarService {

    CarDao cd;

    public CarService(CarDao cd) {
        this.cd = cd;
    }

    private static MyHashMap<Integer,Car> cars_map = new MyHashMap<>();
    
    public static MyHashMap<Integer,Car> getMap() {
    	return cars_map;
    }

    public boolean doesCarIDExist(int id) {
        // O(n) time complexity O(1) space complexity
        return findCarByID(id) != null;
    }

    public Object findCarByID(int id) {
        // O(n) time complexity O(1) space complexity
    	if (cars_map.get(id) == null)
    		return null;
    	else
    		return cars_map.get(id);
    }


    // TODO: Ensure duplicates do not exist, while minimizing calls to doesUsernameExist method.
    public boolean makeCar(int id, String make, String model, int year, double price, double owed) {

    	if (!doesCarIDExist(id)) {
            cars_map.put((Integer)id, new Car(id, make, model, year, price, owed));
            try {
            	cd.save(new Car(id, make, model, year, price, owed));
            }
            catch (Exception e){
            	System.out.println(e.getMessage());
            }
            return true;
               
        } else {
            System.out.println("Car already exists.");
        }
        return false;
    }
    
    public static void add(Scanner s){
    	System.out.print("Please enter the following information.\r\nID: ");
    	String id = s.nextLine().replaceAll("\\s", "");
    	System.out.print("Please enter the following information.\r\nID: ");
    	
    }
    
    public static void remove(Scanner s){
    	System.out.print("");
    }

}