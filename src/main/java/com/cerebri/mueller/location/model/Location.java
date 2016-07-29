package com.cerebri.mueller.location.model;

import java.io.Serializable;

public class Location implements Serializable {

	private static final long serialVersionUID = 1L;
	private String branchName;
	private double longitude;
	private double latitude;
	private String category;
	private String address;
	private String city;
	private String state;
	private String postal;
	private String country;
	private String phone;
	private String email;
	private String imageurl;

	public Location() {
		super();
	}

	public Location(String branchName, double longitude, double latitude,
			String category, String address, String city, String state,
			String postal, String country, String phone, String email,
			String imageurl) {
		super();
		this.branchName = branchName;
		this.longitude = longitude;
		this.latitude = latitude;
		this.category = category;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postal = postal;
		this.country = country;
		this.phone = phone;
		this.email = email;
		this.imageurl = imageurl;

	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double distanceTo(Location loc) {
		double earthRadius = 3958.75;
		double dLat = Math.toRadians(latitude - loc.latitude);
		double dLng = Math.toRadians(longitude - loc.longitude);
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
				+ Math.cos(Math.toRadians(latitude))
				* Math.cos(Math.toRadians(latitude)) * Math.sin(dLng / 2)
				* Math.sin(dLng / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double dist = earthRadius * c;
		return dist * 1609;
	}

	public String toString() {
		return address + " (" + latitude + ", " + longitude + ")";
	}

}
