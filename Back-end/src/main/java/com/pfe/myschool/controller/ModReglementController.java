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

import com.pfe.myschool.model.ModReglement;
import com.pfe.myschool.service.ModReglementService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ModReglementController {
	 @Autowired
	    private ModReglementService modreglService;
	 @GetMapping("/modreglements")
	    public List<ModReglement> list() {
		 System.out.println("Get all Modreglements...");
	             return modreglService.getAll();
	   }
	 @GetMapping("/modreglements/{id}")
	 public ResponseEntity<ModReglement> post(@PathVariable Long id) {
	        Optional<ModReglement> mre = modreglService.findById(id);
	        return mre.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
	    }
	    
	 @PostMapping("/modreglements")
	    public long save(@RequestBody ModReglement modreglement) {
		 
	        return modreglService.save(modreglement);
	    }

	 @PutMapping("/modreglements")
	    public void update( @RequestBody ModReglement modreglement) {
	       
	            modreglService.update(modreglement);
	      
	    }

	    @DeleteMapping("/modreglements/{code}")
	    public void delete(@PathVariable String code) {
	        modreglService.delete(code);
	    }
	     
	  
}




