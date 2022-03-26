package com.luv2code.springboot.cruddemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hospitals")
public class Hospital {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column (name="Id")
	private int id;
	
	@Column (name="name")
	private String name;
	
	@Column (name="adresse")
	private String adresse;
	
	@Column (name="longitude")
	private double longitude;
	
	@Column (name="latitude")
	private double latitude;
	
	@Column (name="height")
	private double height;
	
	@Column (name="specialite")
	private String specialite;
	
	@Column (name="lits")
	private int lits;
	

	
	
	
	
	public Hospital () {}




	



	public Hospital(String name, String adresse, double longitude, double latitude, double height, String specialite,
			int lits) {
		this.name = name;
		this.adresse = adresse;
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
		this.specialite = specialite;
		this.lits = lits;
	}








	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getAdresse() {
		return adresse;
	}




	public void setAdresse(String adresse) {
		this.adresse = adresse;
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




	public double getHeight() {
		return height;
	}




	public void setHeight(double height) {
		this.height = height;
	}




	public String getSpecialite() {
		return specialite;
	}




	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}




	public int getLits() {
		return lits;
	}




	public void setLits(int lits) {
		this.lits = lits;
	}




	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", adresse=" + adresse + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", height=" + height + ", specialite=" + specialite + ", lits=" + lits
				+ "]";
	}




	
	
	
	
	
	
}
