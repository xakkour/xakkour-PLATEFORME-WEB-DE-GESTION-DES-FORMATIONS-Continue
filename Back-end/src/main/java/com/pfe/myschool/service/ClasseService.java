package com.pfe.myschool.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.pfe.myschool.dto.ListClasse;
import com.pfe.myschool.model.Classe;
import com.pfe.myschool.repository.ClasseRepository;


@Service
@Transactional
public class ClasseService {
	 @Autowired
		ClasseRepository repository;
	
		
		public int max() {
			return repository.max();
		}
		
		public int nbre() {
			return repository.nbre();
		}
		
	    public Optional<Classe> findById(Long id) {
	        return repository.findById(id);
	    }
	    
	    public long save(Classe classe) {
	    	System.out.println("save  all Classes 11111...");
	        
	        return repository.save(classe)
	                             .getId();
	    }
	    public void update( Classe classe) {
	      repository.save(classe);
	       
	    }
	  
	
	    public List<Classe> findByLibelle(String libelle) {
	        return repository.findAllByLibelleContaining(libelle);
	    }

	    public void delete(long id) {
	        Optional<Classe> cla = repository.findById(id);
	        cla.ifPresent(repository::delete);
	    }

		public List<ListClasse> getAll() {
			// TODO Auto-generated method stub
			return repository.listClasse();
		}

		
		
}

