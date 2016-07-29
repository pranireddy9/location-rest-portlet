package com.cerebri.mueller.location.dao;

import com.cerebri.mueller.location.model.Location;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class LocationDAOImpl implements LocationDAO {

	private JdbcTemplate jdbcTemplate;
	
	
	 
    public LocationDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@Override
	public void saveOrUpdate(Location location) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int locationId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Location get(int locationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> list() {
		 String sql = "SELECT * FROM " + "\"Stores\"" + ".mueller_locations";
		    List<Location> listLocation = jdbcTemplate.query(sql, new RowMapper<Location>() {
		 
		        @Override
		        public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
		            Location location = new Location();
		 
		            location.setAddress(rs.getString("address"));
		            location.setBranchName(rs.getString("branch_name"));
		            location.setCategory(rs.getString("category"));
		            location.setLatitude(rs.getDouble("latitude"));
		            location.setLongitude(rs.getDouble("longitude"));
		            return location;
		        }
		 
		    });
		 
		    return listLocation;
	}

	@Override
	public List<Location> list(double lat, double lng) {

		//SELECT id, ( 3959 * acos( cos( radians(37) ) * cos( radians( lat ) ) * cos( radians( lng ) - radians(-122) ) + sin( radians(37) ) * sin( radians( lat ) ) ) ) AS distance FROM markers HAVING distance < 25 ORDER BY distance LIMIT 0 , 20;
		
		//SELECT address,branch_name,category,latitude,longitude, ( 3959 * acos( cos( radians(37) ) * cos( radians( lat ) ) * cos( radians( lng ) - radians(-122) ) + sin( radians(37) ) * sin( radians( lat ) ) ) ) AS distance FROM markers HAVING distance < 25 ORDER BY distance LIMIT 0 , 20;
		
		 String sql = "SELECT address,branch_name,category,latitude,longitude, ( 3959 * acos( cos( radians(37) ) * cos( radians( "+lat+" ) ) * cos( radians( "+lng+" ) - radians(-122) ) + sin( radians(37) ) * sin( radians( "+lat+" ) ) ) ) AS distance FROM " + "\"Stores\"" + ".mueller_locations HAVING distance < 25 ORDER BY distance LIMIT 0 , 20" ;
		    List<Location> listLocation = jdbcTemplate.query(sql, new RowMapper<Location>() {
		 
		        @Override
		        public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
		            Location location = new Location();
		 
		            location.setAddress(rs.getString("address"));
		            location.setBranchName(rs.getString("branch_name"));
		            location.setCategory(rs.getString("category"));
		            location.setLatitude(rs.getDouble("latitude"));
		            location.setLongitude(rs.getDouble("longitude"));
		            return location;
		        }
		 
		    });
		 
		    return listLocation;
	}

}
