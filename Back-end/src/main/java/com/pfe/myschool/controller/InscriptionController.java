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

import com.pfe.myschool.model.Inscription;
import com.pfe.myschool.service.InscriptionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class InscriptionController {
	 @Autowired
	    private InscriptionService inscriptionService;
   
	 @GetMapping("/inscriptions/7/{ann}")
	 public  int getNumero(@PathVariable int ann) {
		 int  x = inscriptionService.nbre(ann);
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return inscriptionService.max(ann);
		 }
	 }
	 
	 @GetMapping("/inscriptions")
	    public List<Inscription> list() {
		 System.out.println("Get all Inscriptions...");
	             return inscriptionService.getAll();
	   }
	 
	
	 	 
	 @GetMapping("/inscriptions/{id}")
	 public ResponseEntity<Inscription> post(@PathVariable long id) {
		 System.out.println("Get  Inscriptions By Id...");
	        Optional<Inscription> ins = inscriptionService.findById(id);
	        return ins.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
	    }
	    
	 @PostMapping("/inscriptions")
	    public long save(@RequestBody Inscription inscription) {
		 
	        return inscriptionService.save(inscription);
	    }

	 @PutMapping("/inscriptions/{code}")
	    public void update(@PathVariable long id, @RequestBody Inscription inscription) {
	       
	            inscriptionService.update(id, inscription);
	      
	    }

	    @DeleteMapping("/inscriptions/{id}")
	    public void delete(@PathVariable long id) {
	        inscriptionService.delete(id);
	    }
	     
	  
}
