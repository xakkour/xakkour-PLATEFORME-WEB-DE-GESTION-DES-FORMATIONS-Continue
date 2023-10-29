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
import com.pfe.myschool.model.Emploi;
import com.pfe.myschool.service.EmploiService;
	@CrossOrigin(origins = "http://localhost:4200")
	@RestController
	@RequestMapping("/api")
	public class EmploiController {
		 @Autowired
		    private EmploiService emploiService;
		 
		 @GetMapping("/emplois/7/{ann}")
		 public  int getNumero(@PathVariable int ann) {
		 
			 System.out.println("Get Numbers...");
			 int  x = emploiService.nbre(ann);
			 System.out.println(x);
			 if (x == 0)
			 {
				 return 0;
			 }
			 else
			 {
				 return emploiService.max(ann);
			 }
		    
		 }
		 
		 @GetMapping("/emplois")
		    public List<Emploi> list() {
			 System.out.println("Get all Emplois...");
		             return emploiService.getAll();
		   }
		 	 
		 @GetMapping("/emplois/{id}")
		 public ResponseEntity<Emploi> post(@PathVariable long id) {
		        Optional<Emploi> cat = emploiService.findById(id);
		        return cat.map(ResponseEntity::ok)
		                   .orElseGet(() -> ResponseEntity.notFound()
	                                                  .build());
		    }
		    
		 @PostMapping("/emplois")
		    public long save(@RequestBody Emploi Emploi) {
			 
		        return emploiService.save(Emploi);
		    }

		 @PutMapping("/Emplois/{code}")
		    public void update(@PathVariable long id, @RequestBody Emploi emploi) {
		       
		            emploiService.update(id, emploi);
		      
		    }

		    @DeleteMapping("/emplois/{id}")
		    public void delete(@PathVariable long id) {
		        emploiService.delete(id);
		    }
		     
		  
	}


	

