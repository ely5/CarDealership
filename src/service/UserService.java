package service;

import db.UserDao;
import util.MyHashMap;
import model.Car;
import model.Membership;
import model.Offer;
import model.User;

public class UserService {

    UserDao ud;

    public UserService(UserDao ud) {
        this.ud = ud;
    }

    private static MyHashMap<String,User> users_map = new MyHashMap<>();
    
    public static MyHashMap<String,User> getMap() {
    	return users_map;
    }
    
    public boolean doesUsernameExist(String username) {
        return findUserByUsername(username) != null;
    }

    public User findUserByUsername(String username) {
    	return users_map.get(username);
    }

    // TODO: Ensure duplicates do not exist, while minimizing calls to doesUsernameExist method.
    public boolean makeUser(Membership member, String username, String password, Offer[] offers, Car[] owned) {

        if (!doesUsernameExist(username)) {
            users_map.put(username, new User(member, username, password, offers, owned));
           // ud.save(new User(member, username, password, offers, owned));
            return true;
               
        } else {
            System.out.println("user already exists");
        }
        return false;
    }

}