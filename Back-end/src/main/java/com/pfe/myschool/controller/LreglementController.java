package com.pfe.myschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.myschool.model.Lreglement;
import com.pfe.myschool.service.LreglementService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LreglementController {
	 @Autowired
	    private LreglementService service;
	 @GetMapping("/lreglements")
	    public List<Lreglement> list() {
		 System.out.println("Get all Lreglements...");
	             return service.getAll();
	   }
	 
	 @GetMapping("/lreglements/{numero}")
	 public List<Lreglement> listlreg(@PathVariable int numero) {
		 System.out.println(numero);
	             return service.findByNumero(numero);
	   }


	   
	     
	  
}

