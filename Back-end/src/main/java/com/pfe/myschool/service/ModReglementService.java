package com.pfe.myschool.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pfe.myschool.model.ModReglement;
import com.pfe.myschool.repository.ModReglementRepository;

@Service
@Transactional

public class ModReglementService {
	 @Autowired
		ModReglementRepository repository;
	 
		public int max() {
			return repository.max();
		}
		
		public int nbre() {
			return repository.nbre();
		}
		public List<ModReglement> getAll() {
			System.out.println("Get all Modreglements 11111...");
	    	return repository.findAll(Sort.by("libelle").ascending());	    	
	    }
		
		
		
	    public Optional<ModReglement> findByCode(String code) {
	        return repository.findByCode(code);
	    }
	    
	    public long save(ModReglement modreglement) {
	    	System.out.println("save  all Modreglements 11111...");
	        
	        return repository.save(modreglement)
	                             .getId();
	    }
	    public void update(ModReglement modreglement) {
	        
	            repository.save(modreglement);
	        }
	    
	  
	
	    public List<ModReglement> findByLibelle(String libelle) {
	        return repository.findAllByLibelleContaining(libelle);
	    }

	    public void delete(String code) {
	        Optional<ModReglement> cat = repository.findByCode(code);
	        cat.ifPresent(repository::delete);
	    }

		public Optional<ModReglement> findById(Long id) {
			// TODO Auto-generated method stub
			return null;
		}
		
}



