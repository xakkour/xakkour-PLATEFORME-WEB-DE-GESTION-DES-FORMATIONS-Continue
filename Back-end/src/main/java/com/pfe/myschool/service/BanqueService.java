package com.pfe.myschool.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pfe.myschool.model.Banque;
import com.pfe.myschool.repository.BanqueRepository;

@Service
@Transactional
public class BanqueService {
	 @Autowired
		BanqueRepository repository;
		public List<Banque> getAll() {
			System.out.println("Get all Banques 11111...");
	    	return repository.findAll(Sort.by("libelle").ascending());	    	
	    }
		
		
		
	    public Optional<Banque> findById(Long id) {
	        return repository.findById(id);
	    }
	    
	    public long save(Banque banque) {
	    	System.out.println("save  all Banques 11111...");
	        
	        return repository.save(banque)
	                             .getId();
	    }
	    public void update(Banque banque) {
	    	
	            repository.save(banque);
	        }
	    
	  
	
	    public List<Banque> findByLibelle(String libelle) {
	        return repository.findAllByLibelleContaining(libelle);
	    }

	    public void delete(long id) {
	        Optional<Banque> ban = repository.findById(id);
	        ban.ifPresent(repository::delete);
	    }



	
}

