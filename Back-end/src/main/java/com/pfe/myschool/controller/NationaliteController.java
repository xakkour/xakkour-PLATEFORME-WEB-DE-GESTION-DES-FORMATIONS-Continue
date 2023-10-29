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

import com.pfe.myschool.model.Nationalite;
import com.pfe.myschool.service.NationaliteService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api")
public class NationaliteController {
	 @Autowired
	    private NationaliteService nationaliteService;
   	 @GetMapping("/nationalites")
	    public List<Nationalite> list() {
		 System.out.println("Get all Nationalites...");
	             return nationaliteService.getAll();
	   }
	 	 
	 @GetMapping("/nationalites/{id}")
	 public ResponseEntity<Nationalite> post(@PathVariable String id) {
	        Optional<Nationalite> nat = nationaliteService.findByCode(id);
	        return nat.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
	    }
	    
	 @PostMapping("/nationalites")
	    public long save(@RequestBody Nationalite nationalite) {
		 
	        return nationaliteService.save(nationalite);
	    }

	 @PutMapping("/nationalites")
	    public void update( @RequestBody Nationalite nationalite) {
	       
	            nationaliteService.update(nationalite);
	      
	    }

	    @DeleteMapping("/nationalites/{code}")
	    public void delete(@PathVariable String code) {
	        nationaliteService.delete(code);
	    }
	     
	  
}