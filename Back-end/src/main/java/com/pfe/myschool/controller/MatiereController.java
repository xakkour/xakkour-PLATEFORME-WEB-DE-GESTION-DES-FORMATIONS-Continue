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

import com.pfe.myschool.model.Matiere;
import com.pfe.myschool.service.MatiereService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MatiereController {
	 @Autowired
	    private MatiereService matiereService;
   
	 
	 @GetMapping("/matieres")
	    public List<Matiere> list() {
		 System.out.println("Get all Banques...");
	             return matiereService.getAll();
	   }
	 	 
	 @GetMapping("/matieres/{id}")
	 public ResponseEntity<Matiere> post(@PathVariable long id) {
	        Optional<Matiere> mat = matiereService.findById(id);
	        return mat.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
	    }
	    
	 @PostMapping("/matieres")
	    public long save(@RequestBody Matiere matiere) {
		 System.out.println("Save Matieres...");
	        return matiereService.save(matiere);
	    }

	 @PutMapping("/matieres")
	    public void update( @RequestBody Matiere matiere) {
		
	            matiereService.update(matiere);
	      
	    }

	    @DeleteMapping("/matiers/{id}")
	    public void delete(@PathVariable long id) {
	        matiereService.delete(id);
	    }
	     
	  
}


