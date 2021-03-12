package db;

import java.util.*;

import util.MyHashMap;

public interface Dao<T> {
	    
    Optional<T> get(long id);
	    
    MyHashMap getAll();
	    
    int save(T t);
	    
    void update(T t, String[] params);
	    
    void delete(T t);
}
