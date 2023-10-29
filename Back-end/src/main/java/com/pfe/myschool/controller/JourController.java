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

import com.pfe.myschool.model.Jour;
import com.pfe.myschool.service.JourService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class JourController {
	@Autowired
    private JourService jourService;
	 @GetMapping("/jourss")
	 public  int getNumero() {
	 
		 System.out.println("Get Numbers...");
		 int  x = jourService.nbre();
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return jourService.max();
		 }
	    
	 }
 
 @GetMapping("/jours")
    public List<Jour> list() {
	 System.out.println("Get all Jours...");
             return jourService.getAll();
   }
 	 
 @GetMapping("/jours/{id}")
 public ResponseEntity<Jour> post(@PathVariable long id) {
        Optional<Jour> ban = jourService.findById(id);
        return ban.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound()
                                              .build());
    }
    
 @PostMapping("/jours")
    public long save(@RequestBody Jour jour) {
	 System.out.println("Save Jours...");
        return jourService.save(jour);
    }

 @PutMapping("/jours")
    public void update( @RequestBody Jour jour) {
	
            jourService.update(jour);
      
    }

    @DeleteMapping("/jours/{id}")
    public void delete(@PathVariable long id) {
        jourService.delete(id);
    }
     
}
