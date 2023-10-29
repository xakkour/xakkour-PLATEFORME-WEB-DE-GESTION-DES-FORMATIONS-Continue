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

import com.pfe.myschool.model.Absence;
import com.pfe.myschool.service.AbsenceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AbsenceController {
	 @Autowired
	    private AbsenceService absenceService;
	 
	 @GetMapping("/absences/7/{ann}")
	 public  int getNumero(@PathVariable int ann) {
	 
		 System.out.println("Get Numbers...");
		 int  x = absenceService.nbre(ann);
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return absenceService.max(ann);
		 }
	    
	 }
	 
	 @GetMapping("/absences")
	    public List<Absence> list() {
		 System.out.println("Get all Absences...");
	             return absenceService.getAll();
	   }
	 	 
	 @GetMapping("/absences/{id}")
	 public ResponseEntity<Absence> post(@PathVariable long id) {
	        Optional<Absence> cat = absenceService.findById(id);
	        return cat.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
	    }
	    
	 @PostMapping("/absences")
	    public long save(@RequestBody Absence Absence) {
	        return absenceService.save(Absence);
	    }

	 @PutMapping("/absences/{code}")
	    public void update(@PathVariable long id, @RequestBody Absence Absence) {
	            absenceService.update(id, Absence);
	    }

	    @DeleteMapping("/absences/{id}")
	    public void delete(@PathVariable long id) {
	        absenceService.delete(id);
	    }
	     
	  
}

