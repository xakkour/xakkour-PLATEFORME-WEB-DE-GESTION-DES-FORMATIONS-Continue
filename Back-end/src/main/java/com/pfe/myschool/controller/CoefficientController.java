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

import com.pfe.myschool.model.Coefficient;
import com.pfe.myschool.service.CoefficientService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CoefficientController {
	 @Autowired
	    private CoefficientService coefficientService;
	 @GetMapping("/coefficients/7")
	 public  int getCode() {
		 System.out.println("Get Numbers...");
		 int  x = coefficientService.nbre();
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return coefficientService.max();
		 }
	    
	 }
	 
	 @GetMapping("/coefficients")
	    public List<Coefficient> list() {
		 System.out.println("Get all Coefficients...");
	             return coefficientService.getAll();
	   }
	 	 
	 @GetMapping("/coefficients/{id}")
	 public ResponseEntity<Coefficient> post(@PathVariable long id) {
	        Optional<Coefficient> coef = coefficientService.findById(id);
	        return coef.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
	    }
	    
	 @PostMapping("/coefficients")
	    public long save(@RequestBody Coefficient coefficient) {
		 System.out.println("Save Coefficients...");
	        return coefficientService.save(coefficient);
	    }

	 @PutMapping("/coefficients")
	    public void update( @RequestBody Coefficient coefficient) {
		
	           coefficientService.update(coefficient);
	      
	    }

	    @DeleteMapping("/coefficients/{id}")
	    public void delete(@PathVariable long id) {
	        coefficientService.delete(id);
	    }
	     
	    @GetMapping("/coefficients/{cl}/{mat}")
		 public  double  getCoefficient(@PathVariable String cl,@PathVariable String mat) {
			 System.out.println("ok ggggggggg...");
			 return  coefficientService.getCoefficient(cl,mat);
			
		 }
	    
	    
	  
	  
}

