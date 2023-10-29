package com.pfe.myschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pfe.myschool.model.Labsence;
import com.pfe.myschool.service.LabsenceService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LabsenceController {
	@Autowired
    private LabsenceService  service;
 @GetMapping("/labsences")
    public List<Labsence> list() {
	 System.out.println("Get all Labsences...");
             return service.getAll();
   }
 
 @GetMapping("/labsences/{numero}")
 public List<Labsence> listlabsence(@PathVariable int numero) {
	 System.out.println(numero);
             return service.findByNumero(numero);
   }
}
