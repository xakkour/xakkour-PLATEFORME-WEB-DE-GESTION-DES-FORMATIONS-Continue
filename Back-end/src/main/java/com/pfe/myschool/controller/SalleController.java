package com.pfe.myschool.controller;

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

import com.pfe.myschool.model.Salle;
import com.pfe.myschool.service.SalleService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SalleController {
	 @Autowired
	    private SalleService salleService;
   
	 
	 @GetMapping("/salles")
	    public List<Salle> list() {
		 System.out.println("Get all Salles...");
	             return salleService.getAll();
	   }
	 	 
	 @GetMapping("/salles/{id}")
	 public ResponseEntity<Salle> post(@PathVariable long id) {
	        Optional<Salle> sal = salleService.findById(id);
	        return sal.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
	    }
	    
	 @PostMapping("/salles")
	    public long save(@RequestBody Salle salle) {
		 System.out.println("Save Salles...");
	        return salleService.save(salle);
	    }

	 @PutMapping("/salles")
	    public void update( @RequestBody Salle salle) {
		
	            salleService.update(salle);
	      
	    }

	    @DeleteMapping("/salles/{id}")
	    public void delete(@PathVariable long id) {
	        salleService.delete(id);
	    }
	     
	  
}

