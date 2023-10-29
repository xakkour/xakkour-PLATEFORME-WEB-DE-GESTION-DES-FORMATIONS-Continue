package com.pfe.myschool.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pfe.myschool.model.Jour;
import com.pfe.myschool.repository.JourRepository;

@Service
@Transactional
public class JourService {
	 @Autowired
		JourRepository repository;
		public List<Jour> getAll() {
			System.out.println("Get all Jours 11111...");
	    	return repository.findAll(Sort.by("code").ascending());	    	
	    }
		
		public int max() {
			return repository.max();
		}
		
		public int nbre() {
			return repository.nbre();
		}
		
	    public Optional<Jour> findById(Long id) {
	        return repository.findById(id);
	    }
	    
	    public long save(Jour jour) {
	    	System.out.println("save  all Jours 11111...");
	        
	        return repository.save(jour)
	                             .getId();
	    }
	    public void update(Jour jour) {
	    	
	            repository.save(jour);
	        }
	    
	  
	
	

	    public void delete(long id) {
	        Optional<Jour> ban = repository.findById(id);
	        ban.ifPresent(repository::delete);
	    }



	
}
