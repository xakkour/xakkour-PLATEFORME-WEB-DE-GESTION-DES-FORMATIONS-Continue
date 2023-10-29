package com.pfe.myschool.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.myschool.dto.ListTarif;
import com.pfe.myschool.model.Tarif;
import com.pfe.myschool.repository.TarifRepository;

@Service
@Transactional
public class TarifService {
	 @Autowired
		TarifRepository repository;
		public List<ListTarif> getAll() {
			System.out.println("Get all Tarifs 11111...");
	    	return repository.listTarif();	    	
	    }
		
		public int max() {
			return repository.max();
		}
		
		public int nbre() {
			return repository.nbre();
		}
		
	    public Optional<Tarif> findById(Long id) {
	        return repository.findById(id);
	    }
	    
	    public Optional<Tarif> findByAnnee(int annee) {
	        return repository.findByAnnee(annee);
	    }
	    
	    public long save(Tarif tarif) {
	    	System.out.println("save  all Tarifs 11111...");
	        
	        return repository.save(tarif)
	                             .getId();
	    }
	    public void update(Tarif tarif) {
	        
	         
	            repository.save(tarif);
	        }
	    
	  
	

	    public void delete(long id) {
	        Optional<Tarif> tar = repository.findById(id);
	        tar.ifPresent(repository::delete);
	    }
		
}


