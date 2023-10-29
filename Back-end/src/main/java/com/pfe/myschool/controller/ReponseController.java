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

import com.pfe.myschool.model.Reponse;
import com.pfe.myschool.service.ReponseService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ReponseController {
	 @Autowired
	    private ReponseService reponseService;
	 
	 @GetMapping("/reponses/7/{ann}")
	 public  int getNumero(@PathVariable int ann) {
	 
		 System.out.println("Get Numbers...");
		 int  x = reponseService.numero(ann);
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return reponseService.max(ann);
		 }
	    
	 }
	 
	 @GetMapping("/reponses")
	    public List<Reponse> list() {
		 System.out.println("Get all Notes...");
	             return reponseService.getAll();
	   }
	 	 
	 @GetMapping("/reponses/{id}")
	 public ResponseEntity<Reponse> post(@PathVariable long id) {
	        Optional<Reponse> cat = reponseService.findById(id);
	        return cat.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
	    }
	    
	 @PostMapping("/reponses")
	    public long save(@RequestBody Reponse reponse) {
		 
	        return reponseService.save(reponse);
	    }

	 @PutMapping("/reponses/{code}")
	    public void update(@PathVariable long id, @RequestBody Reponse reponse) {
	       
	           reponseService.update(id, reponse);
	      
	    }

	    @DeleteMapping("/reponses/{id}")
	    public void delete(@PathVariable long id) {
	        reponseService.delete(id);
	    }
	     
	  
}

