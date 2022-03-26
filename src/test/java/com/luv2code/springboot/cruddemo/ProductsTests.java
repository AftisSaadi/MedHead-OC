package com.luv2code.springboot.cruddemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.luv2code.springboot.cruddemo.dao.HospitalRepository;
import com.luv2code.springboot.cruddemo.entity.Hospital;
import com.luv2code.springboot.cruddemo.service.HospitalService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class ProductsTests {
	
	@Autowired
	private HospitalRepository repo;
	

	
	@Test
	public void testCreateProduct() {
		Hospital theHospital = new Hospital ("Pompidou"," 12 rue auguste pompidou",2.34634,4.3874394,35,"Oncologie",5);
		Hospital savedHospital = repo.save(theHospital);
		assertNotNull(savedHospital);
		
	}
	
	
	@Test
	public void testGetProductById() {
		int id= 3;
		String name = "Hopital de paris";
		String str;
		str = repo.findById(id).get().getName();
		//assertThat(str.isEqualTo("anis"));
		assertEquals(str,name);
		
	}
	
	
	@Test
	public void testUpdateProduct() {
		
		int id=1;
		int nbrLits=5000;
		Hospital theHospital = repo.findById(id).get();
		theHospital.setLits(nbrLits);
		repo.save(theHospital);
		theHospital = repo.findById(id).get();
		assertEquals(theHospital.getLits(),nbrLits);
	}
	
	
	@Test
	public void testGetAll() {
		
	}
	
	

}
