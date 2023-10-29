package com.pfe.myschool.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.myschool.model.Lreglement;
import com.pfe.myschool.repository.LreglementRepository;

@Service
@Transactional
public class LreglementService {
	 @Autowired
		LreglementRepository repository;
		public List<Lreglement> getAll() {
			System.out.println("Get all Lreglements 11111...");
	    	return repository.findAll();	    	
	    }
		

	    public void delete(long id) {
	        Optional<Lreglement> lreg = repository.findById(id);
	        lreg.ifPresent(repository::delete);
	    }

	    public List<Lreglement> findByNumero(int numero) {
	    	System.out.println("Get all Lreglements service..");
	        return repository.findByNumero(numero);
	    }



		
}

