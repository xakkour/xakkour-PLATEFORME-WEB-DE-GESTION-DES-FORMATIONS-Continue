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

import com.pfe.myschool.model.Specialite;
import com.pfe.myschool.service.SpecialiteService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api")
public class SpecialiteController {
	 @Autowired
	    private SpecialiteService specialiteService;
   	 @GetMapping("/specialites/7")
	 public  int getCode() {
		 System.out.println("Get Numbers...");
		 int  x = specialiteService.nbre();
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return specialiteService.max();
		 }
	    
	 }
	 
	 @GetMapping("/specialites")
	    public List<Specialite> list() {
		 System.out.println("Get all Specialites...");
	             return specialiteService.getAll();
	   }
	 	 
	 @GetMapping("/specialites/{id}")
	 public ResponseEntity<Specialite> post(@PathVariable Long id) {
	        Optional<Specialite> spe = specialiteService.findById(id);
	        return spe.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
	    }
	    
	 @PostMapping("/specialites")
	    public long save(@RequestBody Specialite specialite) {
		 
	        return specialiteService.save(specialite);
	    }

	 @PutMapping("/specialites")
	    public void update(@RequestBody Specialite specialite) {
	       
	            specialiteService.update(specialite);
	      
	    }

	    @DeleteMapping("/specialites/{id}")
	    public void delete(@PathVariable long id) {
	        specialiteService.delete(id);
	    }
	     
	  }
