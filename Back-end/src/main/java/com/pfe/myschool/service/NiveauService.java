package com.pfe.myschool.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pfe.myschool.model.Niveau;
import com.pfe.myschool.repository.NiveauRepository;

@Service
@Transactional
public class NiveauService {
	 @Autowired
		NiveauRepository repository;
		public List<Niveau> getAll() {
			System.out.println("Get all Niveaus 11111...");
	    	return repository.findAll(Sort.by("libelle").ascending());	    	
	    }
		
		public int max() {
			return repository.max();
		}
		
		public int nbre() {
			return repository.nbre();
		}
		
	    public Optional<Niveau> findById(Long id) {
	        return repository.findById(id);
	    }
	    
	    public long save(Niveau niveau) {
	    	System.out.println("save  all Niveaus 11111...");
	        
	        return repository.save(niveau)
	                             .getId();
	    }
	    public void update(Niveau niveau) {
	       
	            repository.save(niveau);
	        }
	    
	  
	
	    public List<Niveau> findByLibelle(String libelle) {
	        return repository.findAllByLibelleContaining(libelle);
	    }

	    public void delete(String code) {
	        Optional<Niveau> niv = repository.findByCode(code);
	        niv.ifPresent(repository::delete);
	    }

		public Optional<Niveau> findByCode(String code) {
			// TODO Auto-generated method stub
			return null;
		}
		
}

