package com.pfe.myschool.controller;

import java.util.List;
import java.util.Optional;

import com.pfe.myschool.model.Classe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pfe.myschool.model.Institut;
import com.pfe.myschool.service.InstitutService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class InstitutController {
	 @Autowired
	    private InstitutService institutService;
   
	 @GetMapping("/instituts")
	    public List<Institut> list() {
		 System.out.println("Get all Instituts...");
	             return institutService.getAll();
	   }
	 @GetMapping("/instituts/7")
	 public  int getCode() {
		 System.out.println("Get Numbers...");
		 int  x = institutService.nbre();
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return institutService.max();
		 }
	    
	 }

	 @GetMapping("/instituts/{id}")
	 public ResponseEntity<Institut> post(@PathVariable long id) {
	        Optional<Institut> ins = institutService.findById(id);
	        return ins.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
	    }
	    
	 @PostMapping("/instituts")
	    public long save(@RequestBody Institut institut) {
		 
	        return institutService.save(institut);
	    }

	 @PutMapping("/instituts")
	    public void update( @RequestBody Institut institut) {
	       
	            institutService.save(institut);
	      
	    }

	    @DeleteMapping("/instituts/{id}")
	    public void delete(@PathVariable long id) {
	        institutService.delete(id);
	    }

	@GetMapping("/instituts/search")

	public ResponseEntity<List<Institut>> searchetablissements(@RequestParam("query") String query) {
		List<Institut> classeList = institutService.findByLibelle(query);
		return new ResponseEntity<>(classeList, HttpStatus.OK);
	}
}

