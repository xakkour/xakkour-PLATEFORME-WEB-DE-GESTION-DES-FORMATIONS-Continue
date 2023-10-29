package com.pfe.myschool.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.myschool.model.Lemploi;
import com.pfe.myschool.repository.LemploiRepository;
@Service
@Transactional
public class LemploiService {
	 @Autowired
		LemploiRepository repository;
		public List<Lemploi> getAll() {
			System.out.println("Get all Lemplois 11111...");
	    	return repository.findAll();	    	
	    }
		

	    public void delete(long id) {
	        Optional<Lemploi> cat = repository.findById(id);
	        cat.ifPresent(repository::delete);
	    }

	    public List<Lemploi> findByNumero(int numero) {
	    	System.out.println("Get all Lemplois service..");
	        return repository.findByNumero(numero);
	    }

}
