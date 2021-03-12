package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import model.Car;
import util.MyHashMap;

public class CarDao implements Dao<Car>{
    
	@Override
	public Optional<Car> get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyHashMap<Integer,Car> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Car c) {
		int key = -1;
        try {
        	String s = "insert into car_lot (car_id, make, model, car_year, price, owed) values "
        			+ "(?, ?, ?, ?, ?, ?)";
        	PreparedStatement ps = ConnectionService.connect().prepareStatement(s,Statement.RETURN_GENERATED_KEYS);
        	ps.setInt(1,c.getID());
        	ps.setString(2,c.getMake());
        	ps.setString(3,c.getModel());
        	ps.setInt(4,c.getYear());
        	ps.setDouble(5,c.getPrice());
        	ps.setDouble(6,c.getOwed());
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
	public void update(Car t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Car t) {
		// TODO Auto-generated method stub
		
	}
}
