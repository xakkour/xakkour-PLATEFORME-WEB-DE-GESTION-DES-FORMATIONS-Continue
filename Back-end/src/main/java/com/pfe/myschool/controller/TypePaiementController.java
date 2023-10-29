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

import com.pfe.myschool.model.TypePaiement;
import com.pfe.myschool.service.TypePaiementService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TypePaiementController {
	 @Autowired
	    private TypePaiementService typepaiementservice;
	 
	 @GetMapping("/typepaiements/7")
	 public  int getCode() {
		 System.out.println("Get Numbers...");
		 int  x = typepaiementservice.nbre();
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return typepaiementservice.max();
		 }
	    
	 }
	 
	 @GetMapping("/typepaiements")
	    public List<TypePaiement> list() {
		 System.out.println("Get all Typepaiements...");
	             return typepaiementservice.getAll();
	   }
	 @GetMapping("/typepaiements/{id}")
	 public ResponseEntity<TypePaiement> post(@PathVariable Long id) {
	        Optional<TypePaiement> typ = typepaiementservice.findById(id);
	        return typ.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
	    }
	    
	 @PostMapping("/typepaiements")
	    public long save(@RequestBody TypePaiement typepaiement) {
		 
	        return typepaiementservice.save(typepaiement);
	    }

	 @PutMapping("/typepaiements")
	    public void update(@RequestBody TypePaiement typepaiement) {
	       
	            typepaiementservice.update(typepaiement);
	      
	    }

	    @DeleteMapping("/typepaiements/{id}")
	    public void delete(@PathVariable long id) {
	        typepaiementservice.delete(id);
	    }
	     
	  
}








