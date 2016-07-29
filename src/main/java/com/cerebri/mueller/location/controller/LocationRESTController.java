package com.cerebri.mueller.location.controller;  
  
import com.cerebri.mueller.location.dao.LocationDAO;
import com.cerebri.mueller.location.dao.LocationDAOImpl;
import com.cerebri.mueller.location.model.Location;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
  
 
@RestController  
public class LocationRESTController {  
	
	 @Autowired
	    private LocationDAO locationDAO;
	 
	 @Bean
	    public DataSource getDataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("org.postgresql.Driver");
	        dataSource.setUrl("jdbc:postgresql://localhost:5432/cerebri?searchpath=stores");
	        dataSource.setUsername("postgres");
	        dataSource.setPassword("admin");
	         
	        return dataSource;
	    }
	 
	 @Bean
	    public LocationDAO getContactDAO() {
	        return new LocationDAOImpl(getDataSource());
	    }
   
 @RequestMapping(value = "/locations", method = RequestMethod.GET,headers="Accept=application/json")  
 public List<Location> getLocations()  
 {  
  List<Location> locations = new ArrayList<Location>();  
  locations=createLocationList();  
  return locations;  
 }  
  
 //we dont need this below method at this time ..so we dont care..ee method nuvvu edina country id esthe list loo vethiki aa country ni return yesthyaedi ..mana vishayamlo eppudud avasarm ledu andukue comment cheyochu manaki eppuddu anni kavalo
// @RequestMapping(value = "/country/{id}", method = RequestMethod.GET,headers="Accept=application/json")  
// public Country getCountryById(@PathVariable int id)  
// {  
//  List<Country> listOfCountries = new ArrayList<Country>();  
//  listOfCountries=createCountryList();  
//  
//  for (Country country: listOfCountries) {  
//   if(country.getId()==id)  
//    return country;  
//  }  
//    
//  return null;  
// }  
  
// Utiliy method to create country list.  
 public List<Location> createLocationList()  
 {  
  List<Location> locations = locationDAO.list();  
  return locations;  
 }  
}  

