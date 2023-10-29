package com.pfe.myschool.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pfe.myschool.model.Specialite;
import com.pfe.myschool.repository.SpecialiteRepository;

@Service
@Transactional
public class SpecialiteService {
	 @Autowired
		SpecialiteRepository repository;
		public List<Specialite> getAll() {
			System.out.println("Get all Specialites 11111...");
	    	return repository.findAll(Sort.by("libelle").ascending());	    	
	    }
		
		public int max() {
			return repository.max();
		}
		
		public int nbre() {
			return repository.nbre();
		}
		
	    public Optional<Specialite> findById(Long id) {
	        return repository.findById(id);
	    }
	    
	    public long save(Specialite specialite) {
	    	System.out.println("save  all Specialites 11111...");
	        
	        return repository.save(specialite)
	                             .getId();
	    }
	    public void update(Specialite specialite) {
	        
	            repository.save(specialite);
	        }
	    
	  
	
	    public List<Specialite> findByLibelle(String libelle) {
	        return repository.findAllByLibelleContaining(libelle);
	    }

	    public void delete(long id) {
	        Optional<Specialite> cat = repository.findById(id);
	        cat.ifPresent(repository::delete);
	    }
		
}

