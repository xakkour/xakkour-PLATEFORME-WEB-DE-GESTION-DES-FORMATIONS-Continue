package com.pfe.myschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.myschool.model.Lqcm;
import com.pfe.myschool.service.LqcmService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LqcmController {
	 @Autowired
	    private LqcmService service;
	 @GetMapping("/lqcms")
	    public List<Lqcm> list() {
		 System.out.println("Get all Lqcms...");
	             return service.getAll();
	   }
	 
	 @GetMapping("/lqcms/{numero}")
	 public List<Lqcm> listlqcm(@PathVariable int numero) {
		 System.out.println(numero);
	             return service.findByNumero(numero);
	   }

}

