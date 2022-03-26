package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.luv2code.springboot.cruddemo.dao.HospitalRepository;
import com.luv2code.springboot.cruddemo.entity.Hospital;

@Service
public class HospitalServiceImpl implements HospitalService {
	
	
	private HospitalRepository HospitalRepository;
	
	
	
	
	
	@Autowired
	public HospitalServiceImpl(HospitalRepository theHospitalRepository) {
		HospitalRepository = theHospitalRepository;
	}
	
	
	

	@Override
	
	public List<Hospital> findAll() {
		
		return HospitalRepository.findAll();
	}

	@Override
	
	public Hospital findById(int theId) {

		Optional<Hospital> result = HospitalRepository.findById(theId);
		
		Hospital theHospital=null;
		
		 if (result.isPresent() ) {
			 theHospital=result.get(); 
		 }
		 else {
			 throw new RuntimeException ("not found"); 
		 }
		return theHospital;
		
	}

	@Override
	
	public void save(Hospital theHospital) {

		HospitalRepository.save(theHospital);
	}

	@Override
	
	public void deleteById(int theId) {

		HospitalRepository.deleteById(theId);
	}

}
