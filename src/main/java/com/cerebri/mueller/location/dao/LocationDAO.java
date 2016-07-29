package com.cerebri.mueller.location.dao;


import com.cerebri.mueller.location.model.Location;

import java.util.List;


public interface LocationDAO {
     
	
    public void saveOrUpdate(Location location);
     
    public void delete(int locationId);
     
    public Location get(int locationId);
     
    public List<Location> list();
    
    public List<Location> list(double latitude , double longitude);
}

