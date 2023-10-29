package com.pfe.myschool.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pfe.myschool.model.TypePaiement;
import com.pfe.myschool.repository.TypePaiementRepository;

@Service
@Transactional
public class TypePaiementService {
	 @Autowired
		TypePaiementRepository repository;
		public List<TypePaiement> getAll() {
			System.out.println("Get all TypePaiements 11111...");
	    	return repository.findAll(Sort.by("libelle").ascending());	    	
	    }
		
		public int max() {
			return repository.max();
		}
		
		public int nbre() {
			return repository.nbre();
		}
		
	    public Optional<TypePaiement> findById(Long id) {
	        return repository.findById(id);
	    }
	    
	    public long save(TypePaiement TypePaiement) {
	    	System.out.println("save  all TypePaiements 11111...");
	        
	        return repository.save(TypePaiement)
	                             .getId();
	    }
	    public void update(TypePaiement TypePaiement) {
	        
	            repository.save(TypePaiement);
	        }
	    
	  
	
	    public List<TypePaiement> findByLibelle(String libelle) {
	        return repository.findAllByLibelleContaining(libelle);
	    }

	    public void delete(long id) {
	        Optional<TypePaiement> typ = repository.findById(id);
	        typ.ifPresent(repository::delete);
	    }
}

