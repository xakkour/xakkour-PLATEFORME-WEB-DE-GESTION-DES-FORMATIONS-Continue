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

import com.pfe.myschool.dto.ListTarif;
import com.pfe.myschool.model.Tarif;
import com.pfe.myschool.service.TarifService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api")
public class TarifController {
	 @Autowired
	    private TarifService tarifService;
   	 @GetMapping("/tarifs/7")
	 public  int getCode() {
		 System.out.println("Get Numbers...");
		 int  x = tarifService.nbre();
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return tarifService.max();
		 }
	    
	 }
	 
	 @GetMapping("/tarifs")
	    public List<ListTarif> list() {
		 System.out.println("Get all Tarifs...");
	             return tarifService.getAll();
	   }
	 	 
	 @GetMapping("/tarifs/{id}")
	 public ResponseEntity<Tarif> post(@PathVariable Long id) {
	        Optional<Tarif> tar = tarifService.findById(id);
	        return tar.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
	    }
	 
	 @GetMapping("/tarifs/AN/{annee}")
	 public ResponseEntity<Tarif> post(@PathVariable int annee) {
	        Optional<Tarif>tar = tarifService.findByAnnee(annee);
	        return tar.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
	    }
	    
	 @PostMapping("/tarifs")
	    public long save(@RequestBody Tarif tarif) {
		 
	        return tarifService.save(tarif);
	    }

	 @PutMapping("/tarifs")
	    public void update(@RequestBody Tarif tarif) {
	       
	            tarifService.update(tarif);
	      
	    }

	    @DeleteMapping("/tarifs/{id}")
	    public void delete(@PathVariable long id) {
	        tarifService.delete(id);
	    }
	     
	  
}

