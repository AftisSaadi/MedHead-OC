package com.luv2code.springboot.cruddemo.test.REST;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.rest.HospitalRestController;
import com.luv2code.springboot.cruddemo.util.Requete;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class TestRestController {

	
	@Autowired
	HospitalRestController rest;
	
	
	@Test
	@Transactional
	public void testApp() {
		Requete req= new Requete (48.85299690999344, 2.287069755171,"Gastrologie");
		//int i=5;
		String str = rest.findAll(req);
		assertEquals(str,"Rendez-vous à l'hopital Hopital Saint joseph à l'adresse 185 Rue Raymond Losserand Il se trouve a 2.5687152331185334km de votre position & evenement lit reservé");
		
	}
}
