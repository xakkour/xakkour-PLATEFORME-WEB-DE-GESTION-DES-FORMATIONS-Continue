package com.pfe.myschool.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.pfe.myschool.model.Domaine;
import com.pfe.myschool.repository.DomaineRepository;

@Service
@Transactional
public class DomaineService {
	 @Autowired
		DomaineRepository repository;
		public List<Domaine> getAll() {
			System.out.println("Get all Domaines 11111...");
	    	return repository.findAll(Sort.by("libelle").ascending());	    	
	    }
		
		public int max() {
			return repository.max();
		}
		
		public int nbre() {
			return repository.nbre();
		}
		
	    public Optional<Domaine> findById(Long id) {
	        return repository.findById(id);
	    }
	    
	    public long save(Domaine domaine) {
	    	System.out.println("save  all Domaines 11111...");
	        
	        return repository.save(domaine)
	                             .getId();
	    }
	    public void update(Domaine domaine) {
	       
	            repository.save(domaine);
	        }
	    
	  
	
	    public List<Domaine> findByLibelle(String libelle) {
	        return repository.findAllByLibelleContaining(libelle);
	    }

	    public void delete(long id) {
	        Optional<Domaine> cat = repository.findById(id);
	        cat.ifPresent(repository::delete);
	    }
		
}


