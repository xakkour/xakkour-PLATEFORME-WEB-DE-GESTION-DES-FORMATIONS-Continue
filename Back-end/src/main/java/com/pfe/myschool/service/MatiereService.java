package com.pfe.myschool.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pfe.myschool.model.Matiere;
import com.pfe.myschool.repository.MatiereRepository;

@Service
@Transactional
public class MatiereService {
	 @Autowired
		MatiereRepository repository;
		public List<Matiere> getAll() {
			System.out.println("Get all Matiere 11111...");
	    	return repository.findAll(Sort.by("libelle").ascending());	    	
	    }
		
		
		
	    public Optional<Matiere> findById(Long id) {
	        return repository.findById(id);
	    }
	    
	    public long save(Matiere matiere) {
	    	System.out.println("save  all Matiere 11111...");
	        
	        return repository.save(matiere)
	                             .getId();
	    }
	    public void update(Matiere matiere) {
	    	
	            repository.save(matiere);
	        }
	    
	  
	
	    public List<Matiere> findByLibelle(String libelle) {
	        return repository.findAllByLibelleContaining(libelle);
	    }

	    public void delete(long id) {
	        Optional<Matiere> mat = repository.findById(id);
	        mat.ifPresent(repository::delete);
	    }

}
