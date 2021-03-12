package db;

import java.sql.*;
import java.util.Optional;

import model.Offer;
import util.MyHashMap;

public class OfferDao implements Dao<Offer> {

    private OfferDao() {};
    
    @Override
    public int save(Offer o) {
       int key = -1;
       try { 	
        	String s = "insert into offer_table (offer_id, car_id, user_id, owed, price, offer) "
        			+ "values (?, ?, ?, ?, ?, ?)";
        	PreparedStatement ps = ConnectionService.connect().prepareStatement(s);
        	ps.setInt(1,o.getId());
        	ps.setInt(2,o.getCar().getID());
        	ps.setString(3,o.getUser().getUsername());
        	ps.setDouble(4,o.getCar().getOwed());
        	ps.setDouble(5,o.getCar().getPrice());
        	ps.setDouble(6,o.getOffer());
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
            return -1;
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
	public void update(Offer offer, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Offer offer) {
		// TODO Auto-generated method stub
		
	}

}
