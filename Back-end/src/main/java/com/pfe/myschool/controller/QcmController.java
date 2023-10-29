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

import com.pfe.myschool.model.Qcm;
import com.pfe.myschool.service.QcmService;



	@CrossOrigin(origins = "http://localhost:4200")
	@RestController
	@RequestMapping("/api")
	public class QcmController {
		 @Autowired
		    private QcmService qcmService;
		 
		 @GetMapping("/qcms/7/{ann}")
		 public  int getNumero(@PathVariable int ann) {
		 
			 System.out.println("Get Numbers...");
			 int  x = qcmService.nbre(ann);
			 System.out.println(x);
			 if (x == 0)
			 {
				 return 0;
			 }
			 else
			 {
				 return qcmService.max(ann);
			 }
		    
		 }
		 
		 @GetMapping("/qcms")
		    public List<Qcm> list() {
			 System.out.println("Get all Qcms...");
		             return qcmService.getAll();
		   }
		 	 
		 @GetMapping("/qcms/{id}")
		 public ResponseEntity<Qcm> post(@PathVariable long id) {
		        Optional<Qcm> cat = qcmService.findById(id);
		        return cat.map(ResponseEntity::ok)
		                   .orElseGet(() -> ResponseEntity.notFound()
	                                                  .build());
		    }
		    
		 @PostMapping("/qcms")
		    public long save(@RequestBody Qcm qcm) {
			 
		        return qcmService.save(qcm);
		    }

		 @PutMapping("/qcms/{code}")
		    public void update(@PathVariable long id, @RequestBody Qcm qcm) {
		       
		            qcmService.update(id, qcm);
		      
		    }

		    @DeleteMapping("/qcms/{id}")
		    public void delete(@PathVariable long id) {
		        qcmService.delete(id);
		    }
		     
		  
	}


	

