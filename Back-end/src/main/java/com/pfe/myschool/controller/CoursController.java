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

import com.pfe.myschool.dto.ListCours;
import com.pfe.myschool.model.Cours;
import com.pfe.myschool.service.CoursService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CoursController {
	 @Autowired
	    private CoursService coursService;
	 
	 @GetMapping("/cours/7/{ann}")
	 public  int getNumero(@PathVariable int ann) {
		 int  x = coursService.nbre(ann);
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return coursService.max(ann);
		 }
	 }
	 
	 @GetMapping("/cours")
	    public List<ListCours> list() {
		 System.out.println("Get all Cours...");
	             return coursService.getAll();
	   }
	 
	 @GetMapping("/cours/cl/{matricule}")
	    public List<ListCours> listCours(@PathVariable String matricule) {
		 System.out.println("get classe ....");
	             return coursService.getCoursCl(matricule);
	   }
	 
	 @GetMapping("/cours/{matricule}/{cl}")
	    public List<ListCours> listMatiere(@PathVariable String matricule,@PathVariable String cl) {
		 System.out.println("Get all Cours..matiere.");
	             return coursService.getCoursMat(matricule,cl);
	   }
	 @GetMapping("/cours/{id}")
	 public ResponseEntity<Cours> post(@PathVariable Long id) {
	        Optional<Cours> cou = coursService.findById(id);
	        return cou.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                         .build());
	    }
	    
	 @PostMapping("/cours")
	    public long save(@RequestBody Cours cours) {
		 
	        return coursService.save(cours);
	    }

	 @PutMapping("/cours")
	    public void update(@RequestBody Cours cours) {
	       
	            coursService.update(cours);
	      
	    }

	    @DeleteMapping("/cours/{id}")
	    public void delete(@PathVariable long id) {
	        coursService.delete(id);
	    }


}

