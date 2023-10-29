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

import com.pfe.myschool.model.Niveau;
import com.pfe.myschool.service.NiveauService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api")
public class NiveauController {
	 @Autowired
	    private NiveauService niveauService;
   	 @GetMapping("/niveaus/7")
	 public  int getCode() {
		 System.out.println("Get Numbers...");
		 int  x = niveauService.nbre();
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return niveauService.max();
		 }
	    
	 }
	 
	 @GetMapping("/niveaus")
	    public List<Niveau> list() {
		 System.out.println("Get all Niveaus...");
	             return niveauService.getAll();
	   }
	 	 
	 @GetMapping("/niveaus/{id}")
	 public ResponseEntity<Niveau> post(@PathVariable String code) {
	        Optional<Niveau> niv = niveauService.findByCode(code);
	        return niv.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
	    }
	    
	 @PostMapping("/niveaus")
	    public long save(@RequestBody Niveau niveau) {
		 
	        return niveauService.save(niveau);
	    }

	 @PutMapping("/niveaus")
	    public void update( @RequestBody Niveau niveau) {
	       
	            niveauService.update(niveau);
	      
	    }

	    @DeleteMapping("/niveaus/{code}")
	    public void delete(@PathVariable String code) {
	        niveauService.delete(code);
	    }
	     
	  
}
