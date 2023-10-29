package com.pfe.myschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.myschool.dto.StatData;
import com.pfe.myschool.service.StatReglementService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class StatReglementController {
	@Autowired
    private StatReglementService statService;
	 @GetMapping("/stats")
	    public List<StatData> list() {
		 System.out.println("Get all Statistiques...");
	             return statService.getAll();
	   }
}
