package com.pfe.myschool.service;



import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.pfe.myschool.model.Lqcm;
import com.pfe.myschool.model.Reponse;
import com.pfe.myschool.repository.CompteurRepository;
import com.pfe.myschool.repository.LqcmRepository;
import com.pfe.myschool.repository.ReponseRepository;



@Service
@Transactional
public class ReponseService {
	 @Autowired
		ReponseRepository repository;
	 @Autowired
		LqcmRepository lqcmRepository;		
	 @Autowired
		CompteurRepository compteurRepository;
	 public List<Reponse> getAll() {
			System.out.println("Get all Reponses 11111...");
	    	return repository.findAll();    	
	    }
		
	 public long  save(@Valid @RequestBody Reponse reponse) {
			   System.out.println("save lnote");
			   List<Lqcm> lqcms = reponse.getLqcm();
			   for (Lqcm lqcm : lqcms) {
			    	 System.out.println(reponse.getNumero());
		            lqcm.setNumero(reponse.getNumero());
		           System.out.println(" save data ligne");
		           lqcmRepository.save(lqcm);
			       }
			
	  	 return repository.save(reponse)
                         .getId();
	}
	  
	    
	public void update(long id, Reponse note) {
	        Optional<Reponse> rep = repository.findById(id);
	        if (rep.isPresent()) {
	            Reponse reponses = rep.get();
	            repository.save(reponses);
	        }
	}
	
	public void delete(long id) {
	        Optional<Reponse> rep = repository.findById(id);
	        rep.ifPresent(repository::delete);
	}

	public Optional<Reponse> findById(long id) {
			// TODO Auto-generated method stub
			return repository.findById(id);
	}
	
	public int max(int ann) {
		return repository.max(ann);
	}
	
	public int numero(int ann) {
		return repository.numero(ann);
	}
}

