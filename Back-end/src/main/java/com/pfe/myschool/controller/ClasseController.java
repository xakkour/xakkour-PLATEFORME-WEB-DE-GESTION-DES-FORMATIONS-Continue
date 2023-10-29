package com.pfe.myschool.controller;

import java.util.List;
import java.util.Optional;

import com.pfe.myschool.model.Etablissement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pfe.myschool.dto.ListClasse;
import com.pfe.myschool.model.Classe;
import com.pfe.myschool.service.ClasseService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClasseController {
	 @Autowired
	    private ClasseService classeService;
	
	 @GetMapping("/classes/7")
	 public  int getCode() {
		 System.out.println("Get Numbers...");
		 int  x = classeService.nbre();
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return classeService.max();
		 }
	    
	 }
	 
	 @GetMapping("/classes")
	    public List<ListClasse> list() {
		 System.out.println("Get all Classes...");
	             return classeService.getAll();
	   }
	 
	
	 
	 @GetMapping("/classes/{id}")
	 public ResponseEntity<Classe> post(@PathVariable Long id) {
	        Optional<Classe> cla = classeService.findById(id);
	        return cla.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                               .build());
	    }
	    
	 @PostMapping("/classes")
	    public long save(@RequestBody Classe classe) {
		 
	        return classeService.save(classe);
	    }

	 @PutMapping("/classes")
	    public void update(@RequestBody Classe classe) {
	       
	            classeService.update(classe);
	      
	    }

	    @DeleteMapping("/classes/{id}")
	    public void delete(@PathVariable long id) {
	        classeService.delete(id);
	    }

	@GetMapping("/classes/search")

	public ResponseEntity<List<Classe>> searchetablissements(@RequestParam("query") String query) {
		List<Classe> classeList = classeService.findByLibelle(query);
		return new ResponseEntity<>(classeList, HttpStatus.OK);
	}

}
