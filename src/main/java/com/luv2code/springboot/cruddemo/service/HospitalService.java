package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Hospital;

public interface HospitalService {
	
    public List<Hospital> findAll();
	
	public Hospital findById(int theId);
	
	public void save (Hospital theEmployee);
	
	public void deleteById (int theId);

}
