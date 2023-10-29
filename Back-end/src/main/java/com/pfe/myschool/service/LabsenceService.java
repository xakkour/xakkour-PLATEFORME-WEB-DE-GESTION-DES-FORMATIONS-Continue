package com.pfe.myschool.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.myschool.model.Labsence;
import com.pfe.myschool.repository.LabsenceRepository;
@Service
@Transactional
public class LabsenceService {
	 @Autowired
		LabsenceRepository repository;
		public List<Labsence> getAll() {
			System.out.println("Get all Labsences 11111...");
	    	return repository.findAll();	    	
	    }
		

	    public void delete(long id) {
	        Optional<Labsence> cat = repository.findById(id);
	        cat.ifPresent(repository::delete);
	    }

	    public List<Labsence> findByNumero(int numero) {
	    	System.out.println("Get all Labsences service..");
	        return repository.findByNumero(numero);
	    }

}
