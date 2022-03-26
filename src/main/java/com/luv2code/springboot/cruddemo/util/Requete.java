package com.luv2code.springboot.cruddemo.util;

public class Requete {
	
	
	private double latitude;
	private double longitude;
	private String specialite;
	public Requete(double latitude, double longitude, String specialite) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.specialite = specialite;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	
	

}
