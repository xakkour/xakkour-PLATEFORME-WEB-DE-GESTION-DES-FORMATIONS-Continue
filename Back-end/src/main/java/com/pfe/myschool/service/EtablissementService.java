package com.pfe.myschool.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.myschool.model.Etablissement;
import com.pfe.myschool.repository.EtablissementRepository;

@Service
@Transactional
public class EtablissementService {
	 @Autowired
		EtablissementRepository repository;
		public List<Etablissement> getAll() {
			System.out.println("Get all Etablissements 11111...");
	    	return repository.findAll();	    	
	    }
		
		public int max() {
			return repository.max();
		}
		
		public int nbre() {
			return repository.nbre();
		}
		
	    public Optional<Etablissement> findById(long id) {
	        return repository.findById(id);
	    }
	    
	    public long save(Etablissement etablissement) {
	    	System.out.println("save  all Etablissements 11111...");
	        
	        return repository.save(etablissement)
	                             .getId();
	    }
	    public void update(Etablissement etablissement) {
	    	
	            repository.save(etablissement);
	        }
	    
	  
	
	    public List<Etablissement> findByLibelle(String libelle) {
	        return repository.findAllByLibelleContaining(libelle);
	    }

			public void delete(long id) {
	        Optional<Etablissement> etab = repository.findById(id);
	        etab.ifPresent(repository::delete);
	    }
		
}


