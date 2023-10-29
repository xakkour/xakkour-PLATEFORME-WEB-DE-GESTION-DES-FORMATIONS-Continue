package com.pfe.myschool.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.myschool.model.Lnote;
import com.pfe.myschool.repository.LnoteRepository;

@Service
@Transactional
public class LnoteService {
	 @Autowired
		LnoteRepository repository;
		public List<Lnote> getAll() {
			System.out.println("Get all Lnotes 11111...");
	    	return repository.findAll();	    	
	    }
		

	    public void delete(long id) {
	        Optional<Lnote> cat = repository.findById(id);
	        cat.ifPresent(repository::delete);
	    }

	    public List<Lnote> findByNumero(int numero) {
	    	System.out.println("Get all Lnotes service..");
	        return repository.findByNumero(numero);
	    }



		
}
