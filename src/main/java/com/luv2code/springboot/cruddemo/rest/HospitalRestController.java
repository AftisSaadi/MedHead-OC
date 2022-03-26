package com.luv2code.springboot.cruddemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Hospital;
import com.luv2code.springboot.cruddemo.service.HospitalService;
import com.luv2code.springboot.cruddemo.util.Requete;
import com.luv2code.springboot.cruddemo.util.UtilTools;

@RestController
@RequestMapping("/api")
public class HospitalRestController {

	private HospitalService hospitalService;
	
	@Autowired
	public HospitalRestController(HospitalService thehospitalService) {
		hospitalService = thehospitalService;
	}
	
	
	@GetMapping("/employees")
	public String findAll (@RequestBody Requete theHospital ){ //Hospital theHospital
		
		
		Hospital theHospitalAnswer;
		double lat = theHospital.getLatitude();
		double longi= theHospital.getLongitude()  ;
		String specialite= theHospital.getSpecialite() ; 
		//int lits = theHospital.getLits();
		double res=0;
		double resF=0;
		int j=0;
		
		//theHospital.setName("Real");
		//hospitalService.save(theHospital);
		
		List<Hospital> liste= hospitalService.findAll();
		List<Hospital> listeF =new ArrayList<Hospital>();
		
		
		
		for (int i=0; i<liste.size();i++)
		{
			if (liste.get(i).getSpecialite().contains(specialite) && liste.get(i).getLits()>0) //>= lits
			{ 
				
				listeF.add(liste.get(i));
				
			}
		}
		
		
		//Conditions dans le cas ou aucun hopital n'a été trouvé
		if (listeF.size()==0)
		 return "Aucun hopital disponible pour votre spécialité";
		
		
		for (int i=0; i<listeF.size(); i++) {
		res = UtilTools.distance(lat, listeF.get(i).getLatitude(), longi , listeF.get(i).getLongitude(), 35, 35);
		if (i==0)
			resF=res;
		
		if (res<resF) {
			resF=res;
			j=i;
		  }
		}
		
		theHospitalAnswer = listeF.get(j);
		theHospitalAnswer.setLits(theHospitalAnswer.getLits()-1);
		hospitalService.save(theHospitalAnswer);
		resF= resF/1000;
		return "Rendez-vous à l'hopital "+theHospitalAnswer.getName()+" à l'adresse " +theHospitalAnswer.getAdresse()+" Il se trouve a " +resF+ "km de votre position & evenement lit reservé";
		}
	
	
	
	@GetMapping("/employees/{hospitalId}")
	public Hospital findById(@PathVariable int hospitalId) {
		
		Hospital theHospital = hospitalService.findById(hospitalId);
		if (theHospital== null) {
			throw new RuntimeException ("Hospital not found: "+hospitalId);
		}
		//theHospital.setName("Barca");
		//hospitalService.save(theHospital);
		
		
		
		return theHospital;
	}
	
	@PostMapping("/employees")
	public Hospital addEmployee(@RequestBody Hospital theHospital) {
		
		
		theHospital.setId(0);
		
		hospitalService.save(theHospital);

		return theHospital;
	}

	
	@PutMapping("/employees")
	public Hospital upadateEmployee(@RequestBody Hospital theHospital) {
		
		hospitalService.save(theHospital);
		
		return theHospital;
		
	}
	
	@DeleteMapping("/employees/{hospitalId}")
	public String deleteEmployee (@PathVariable int hospitalId) {
		
		Hospital tempEmployee = hospitalService.findById(hospitalId);
		
		if (tempEmployee== null) {
			throw new RuntimeException ("Employee doesnt exist");
		}
		
		hospitalService.deleteById(hospitalId);
		
		return "Deleted employee of id :" +hospitalId;
	}
	
	
	
}
