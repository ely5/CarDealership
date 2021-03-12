package service;

import db.OfferDao;
import model.Offer;
import model.User;
import util.MyHashMap;

public class OfferService {

	OfferDao od;

    public OfferService(OfferDao od) {
        this.od = od;
    }
    
	private static MyHashMap<Integer,Offer> offers_map = new MyHashMap<>();
    
    public static MyHashMap<Integer,Offer> getMap() {
    	return offers_map;
    }
	
	public static String viewOffers() {
		return offers_map.toString();
	}
	
	public boolean makeOffer(){
		return false;
	}
}
