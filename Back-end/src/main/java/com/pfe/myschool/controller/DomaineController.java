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

import com.pfe.myschool.model.Domaine;
import com.pfe.myschool.service.DomaineService;


@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api")
public class DomaineController {
	 @Autowired
	    private DomaineService domaineService;
   	 @GetMapping("/domaines/7")
	 public  int getCode() {
		 System.out.println("Get Numbers...");
		 int  x = domaineService.nbre();
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return domaineService.max();
		 }
	    
	 }
	 
	 @GetMapping("/domaines")
	    public List<Domaine> list() {
		 System.out.println("Get all Domaines...");
	             return domaineService.getAll();
	   }
	 	 
	 @GetMapping("/domaines/{id}")
	 public ResponseEntity<Domaine> post(@PathVariable Long id) {
	        Optional<Domaine> dom = domaineService.findById(id);
	        return dom.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
	    }
	    
	 @PostMapping("/domaines")
	    public long save(@RequestBody Domaine domaine) {
		 
	        return domaineService.save(domaine);
	    }

	 @PutMapping("/domaines")
	    public void update(@RequestBody Domaine domaine) {
	       
	            domaineService.update(domaine);
	      
	    }

	    @DeleteMapping("/domaines/{id}")
	    public void delete(@PathVariable long id) {
	        domaineService.delete(id);
	    }
	     
	  
}
