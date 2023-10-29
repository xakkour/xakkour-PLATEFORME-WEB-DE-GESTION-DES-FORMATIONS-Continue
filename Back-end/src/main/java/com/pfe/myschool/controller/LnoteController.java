package com.pfe.myschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.myschool.model.Lnote;
import com.pfe.myschool.service.LnoteService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LnoteController {
	 @Autowired
	    private LnoteService service;
	 @GetMapping("/lnotes")
	    public List<Lnote> list() {
		 System.out.println("Get all Lnotes...");
	             return service.getAll();
	   }
	 
	 @GetMapping("/lnotes/{numero}")
	 public List<Lnote> listlnote(@PathVariable int numero) {
		 System.out.println(numero);
	             return service.findByNumero(numero);
	   }

}

