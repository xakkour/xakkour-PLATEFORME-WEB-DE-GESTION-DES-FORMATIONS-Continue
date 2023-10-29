package com.pfe.myschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.myschool.model.Lemploi;
import com.pfe.myschool.service.LemploiService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LemploiController {
	@Autowired
    private LemploiService service;
 @GetMapping("/lemplois")
    public List<Lemploi> list() {
	 System.out.println("Get all Lemplois...");
             return service.getAll();
   }
 
 @GetMapping("/lemplois/{numero}")
 public List<Lemploi> listlemploi(@PathVariable int numero) {
	 System.out.println(numero);
             return service.findByNumero(numero);
   }
}
