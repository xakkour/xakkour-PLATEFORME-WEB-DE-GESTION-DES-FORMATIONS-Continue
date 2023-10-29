package com.pfe.myschool.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.myschool.model.Reglement;
import com.pfe.myschool.service.ReglementService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api")
public class ReglementController {
	 @Autowired
	    private ReglementService reglementService;
	 @GetMapping("/reglements/{annee}/{m}")
	 public  double getMont1(@PathVariable int annee,@PathVariable int m) {
		 System.out.println("Get Numbers...");
		 int  x = reglementService.nbMois(annee,m);
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
		 double  y = reglementService.getMontMois(annee, m);
		 System.out.println(y);
		
			 return y;
		 }
	 }
	 
	 @GetMapping("/reglements/{d1}/{d2}")
	    public List<Reglement> listReglment(@PathVariable String d1, @PathVariable String d2) throws ParseException {
		 System.out.println(d1);
		 System.out.println(d2);
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 Date d3 = formatter.parse(d1);
		 Date d4 = formatter.parse(d2);
      return reglementService.listReglement(d3,d4);
	   }
	 
	 @GetMapping("/reglements/M/{annee}")
	 public  double getMontA(@PathVariable int annee) {
		 System.out.println("Get Numbers...");
		 int  x = reglementService.nbAnnee(annee);
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
		 double  y = reglementService.getMontAnnee(annee);
		 System.out.println(y);
		
			 return y;
		 }
	 }
	 
	 
	 @GetMapping("/reglements")
	    public List<Reglement> list() {
		 System.out.println("Get all Reglements...");
	             return reglementService.getAll();
	   }
	 	 
	 @GetMapping("/reglements/{id}")
	 public ResponseEntity<Reglement> post(@PathVariable long id) {
	        Optional<Reglement> reg = reglementService.findById(id);
	        return reg.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
	    }
	    
	 @PostMapping("/reglements")
	    public long save(@RequestBody Reglement reglement) {
		 
	        return reglementService.save(reglement);
	    }

	 @PutMapping("/reglements/{code}")
	    public void update(@PathVariable long id, @RequestBody Reglement reglement) {
	       
	            reglementService.update(id, reglement);
	      
	    }

	    @DeleteMapping("/reglements/{id}")
	    public void delete(@PathVariable long id) {
	        reglementService.delete(id);
	    }
	     
	  
}

