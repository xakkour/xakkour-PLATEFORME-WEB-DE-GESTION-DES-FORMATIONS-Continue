package com.pfe.myschool.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pfe.myschool.model.Cycle;
import com.pfe.myschool.repository.CycleRepository;

@Service
@Transactional
public class CycleService {
	 @Autowired
		CycleRepository repository;
		public List<Cycle> getAll() {
			System.out.println("Get all Cycles 11111...");
	    	return repository.findAll(Sort.by("libelle").ascending());	    	
	    }
		
		public int max() {
			return repository.max();
		}
		
		public int nbre() {
			return repository.nbre();
		}
		
	    public Optional<Cycle> findById(Long id) {
	        return repository.findById(id);
	    }
	    
	    public long save(Cycle cycle) {
	    	System.out.println("save  all Cycles 11111...");
	        
	        return repository.save(cycle).getId();
	    }


	    public void update( Cycle cycle) {
	       
	            repository.save(cycle);
	        }
	    
	  
	
	    public List<Cycle> findByLibelle(String libelle) {
	        return repository.findAllByLibelleContaining(libelle);
	    }

	    public void delete(Long id) {
	        Optional<Cycle> cycle = repository.findById(id);
	        cycle.ifPresent(repository::delete);
	    }

		
}



