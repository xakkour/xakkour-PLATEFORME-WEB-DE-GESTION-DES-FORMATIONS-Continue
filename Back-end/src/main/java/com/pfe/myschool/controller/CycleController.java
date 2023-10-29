package com.pfe.myschool.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pfe.myschool.model.Cycle;
import com.pfe.myschool.service.CycleService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CycleController {
	 @Autowired
	    private CycleService cycleService;
   	 @GetMapping("/cycles/7")
	 public  int getCode() {
		 System.out.println("Get Numbers...");
		 int  x = cycleService.nbre();
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return cycleService.max();
		 }
	    
	 }
	@GetMapping("/cycles/search")

	public ResponseEntity<List<Cycle>> searchCycles(@RequestParam("query") String query) {
		List<Cycle> cycles = cycleService.findByLibelle(query);
		return new ResponseEntity<>(cycles, HttpStatus.OK);
	}
	 
	 @GetMapping("/cycles")
	    public List<Cycle> list() {
		 System.out.println("Get all Cycles...");
	             return cycleService.getAll();
	   }
	 	 
	 @GetMapping("/cycles/{id}")
	 public ResponseEntity<Cycle> post(@PathVariable Long id) {
	        Optional<Cycle> cyc = cycleService.findById(id);
	        return cyc.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
	    }
	    
	 @PostMapping("/cycles")
	    public long save(@RequestBody Cycle cycle) {
		 
	        return cycleService.save(cycle);
	    }

	 @PutMapping("/cycles")
	    public void update( @RequestBody Cycle cycle) {
	       
	            cycleService.update(cycle);
	      
	    }

	    @DeleteMapping("/cycles/{id}")
	    public void delete(@PathVariable Long id) {
	        cycleService.delete(id);
	    }
	     
	  
}
