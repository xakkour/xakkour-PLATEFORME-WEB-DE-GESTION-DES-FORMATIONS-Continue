package com.pfe.myschool.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pfe.myschool.model.Nationalite;
import com.pfe.myschool.repository.NationaliteRepository;

@Service
@Transactional
public class NationaliteService {
	 @Autowired
		NationaliteRepository repository;
		public List<Nationalite> getAll() {
			System.out.println("Get all Nationalites 11111...");
	    	return repository.findAll(Sort.by("libelle").ascending());	    	
	    }
		
		public int max() {
			return repository.max();
		}
		
		public int nbre() {
			return repository.nbre();
		}
		
	    public Optional<Nationalite> findById(Long id) {
	        return repository.findById(id);
	    }
	    
	    public long save(Nationalite nationalite) {
	    	System.out.println("save  all Nationalites 11111...");
	        
	        return repository.save(nationalite)
	                             .getId();
	    }
	    public void update( Nationalite nationalite) {
	       
	            repository.save(nationalite);
	        }
	    
	  
	
	    public List<Nationalite> findByLibelle(String libelle) {
	        return repository.findAllByLibelleContaining(libelle);
	    }

	    public void delete(String code) {
	        Optional<Nationalite> nat = repository.findByCode(code);
	        nat.ifPresent(repository::delete);
	    }

		public Optional<Nationalite> findByCode(String code) {
			// TODO Auto-generated method stub
			return null;
		}
		
}


