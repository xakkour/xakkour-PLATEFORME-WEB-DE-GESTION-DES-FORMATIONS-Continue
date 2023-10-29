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

import com.pfe.myschool.model.Horaire;
import com.pfe.myschool.service.HoraireService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class HoraireController {
	@Autowired
    private HoraireService horaireService;

	 @GetMapping("/horaires/7")
	 public  int getCode() {
		 System.out.println("Get Numbers...");
		 int  x = horaireService.nbre();
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return horaireService.max();
		 }
	    
	 }
 
 @GetMapping("/horaires")
    public List<Horaire> list() {
	 System.out.println("Get all Horaires...");
             return horaireService.getAll();
   }
 	 
 @GetMapping("/horaires/{id}")
 public ResponseEntity<Horaire> post(@PathVariable long id) {
        Optional<Horaire> ban = horaireService.findById(id);
        return ban.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound()
                                              .build());
    }
    
 @PostMapping("/horaires")
    public long save(@RequestBody Horaire horaire) {
	 System.out.println("Save Horaires...");
        return horaireService.save(horaire);
    }

 @PutMapping("/horaires")
    public void update( @RequestBody Horaire horaire) {
	
            horaireService.update(horaire);
      
    }

    @DeleteMapping("/horaires/{id}")
    public void delete(@PathVariable long id) {
        horaireService.delete(id);
    }
     

}
