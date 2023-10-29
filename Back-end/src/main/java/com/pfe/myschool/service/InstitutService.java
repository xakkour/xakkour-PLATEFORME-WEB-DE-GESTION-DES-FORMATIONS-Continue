package com.pfe.myschool.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.pfe.myschool.model.Etablissement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.myschool.model.Institut;
import com.pfe.myschool.repository.InstitutRepository;

@Service
@Transactional
public class InstitutService {
	 @Autowired
		InstitutRepository repository;
		public List<Institut> getAll() {
			System.out.println("Get all Instituts 11111...");
	    	return repository.findAll();	    	
	    }
		
	    public Optional<Institut> findById(long id) {
	        return repository.findById(id);
	    }
	    
	    public long save(Institut institut) {
	    	System.out.println("save  all Instituts 11111...");
	        
	        return repository.save(institut)
	                             .getId();
	    }
	   

	    public void delete(long id) {
	        Optional<Institut> ins = repository.findById(id);
	        ins.ifPresent(repository::delete);
	    }

	    public int max() {
			return repository.max();
		}
		

		public int nbre() {
			return repository.nbre();
		}


	public List<Institut> findByLibelle(String libelle) {
		return repository.findAllByLibelleContaining(libelle);
	}
}


