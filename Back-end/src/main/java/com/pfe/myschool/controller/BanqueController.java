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

import com.pfe.myschool.model.Banque;
import com.pfe.myschool.service.BanqueService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BanqueController {
	 @Autowired
	    private BanqueService banqueService;
   
	 
	 @GetMapping("/banques")
	    public List<Banque> list() {
		 System.out.println("Get all Banques...");
	             return banqueService.getAll();
	   }
	 	 
	 @GetMapping("/banques/{id}")
	 public ResponseEntity<Banque> post(@PathVariable long id) {
	        Optional<Banque> ban = banqueService.findById(id);
	        return ban.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
	    }
	    
	 @PostMapping("/banques")
	    public long save(@RequestBody Banque banque) {
		 System.out.println("Save Banques...");
	        return banqueService.save(banque);
	    }

	 @PutMapping("/banques")
	    public void update( @RequestBody Banque banque) {
		
	            banqueService.update(banque);
	      
	    }

	    @DeleteMapping("/banques/{id}")
	    public void delete(@PathVariable long id) {
	        banqueService.delete(id);
	    }
	     
	  
}

