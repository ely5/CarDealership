package db;

import java.sql.*;
import java.util.Optional;

import model.User;
import util.MyHashMap;

public class UserDao implements Dao<User> {

	private static UserDao userDao;
    public UserDao() {};
    
    static UserDao getInstance(){
        if(userDao == null){
            userDao = new UserDao();
        }
        return userDao;
    }
    
    @Override
    public int save(User u) {
    	int key = -1;
        try {
        	String s = "insert into user_table (membership, username, password) "
        			+ "values (?, ?, ?)";
        	PreparedStatement ps = ConnectionService.connect().prepareStatement(s);
        	ps.setObject(1,u.getMembership().getValue());
        	ps.setString(2,u.getUsername());
        	ps.setString(3,u.getPassword());
        	ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) {
                key = rs.getInt(1);
            }
            ps.close();
            return key;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return key;
        }
    }

	@Override
	public Optional get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyHashMap getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User u, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User u) {
		// TODO Auto-generated method stub
		
	}

}
