package com.pfe.myschool.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pfe.myschool.model.Salle;
import com.pfe.myschool.repository.SalleRepository;

@Service
@Transactional
public class SalleService {
	@Autowired
	SalleRepository repository;
	public List<Salle> getAll() {
		System.out.println("Get all Salles 11111...");
    	return repository.findAll(Sort.by("libelle").ascending());	    	
    }
	
	
	
    public Optional<Salle> findById(Long id) {
        return repository.findById(id);
    }
    
    public long save(Salle salle) {
    	System.out.println("save  all Salles 11111...");
        
        return repository.save(salle)
                             .getId();
    }
    public void update(Salle salle) {
    	
            repository.save(salle);
        }
    
  

    public List<Salle> findByLibelle(String libelle) {
        return repository.findAllByLibelleContaining(libelle);
    }

    public void delete(long id) {
        Optional<Salle> sal= repository.findById(id);
        sal.ifPresent(repository::delete);
    }




}



