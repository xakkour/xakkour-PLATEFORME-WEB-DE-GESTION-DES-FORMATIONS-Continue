package com.pfe.myschool.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.myschool.dto.StatData;
import com.pfe.myschool.repository.StatReglementRepository;

@Service
@Transactional
public class StatReglementService {
	@Autowired
	StatReglementRepository repository;
	public List<StatData> getAll() {
		System.out.println("Get all Stat 11111...");
    	return repository.listData();	    	
    }
}
