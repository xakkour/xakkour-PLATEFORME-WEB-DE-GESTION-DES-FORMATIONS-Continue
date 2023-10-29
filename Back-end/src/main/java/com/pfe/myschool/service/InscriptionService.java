package com.pfe.myschool.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.myschool.model.Compteur;
import com.pfe.myschool.model.Inscription;
import com.pfe.myschool.repository.CompteurRepository;
import com.pfe.myschool.repository.InscriptionRepository;

@Service
@Transactional
public class InscriptionService {
	 @Autowired
		InscriptionRepository repository;
	 @Autowired
		CompteurRepository compteurRepository;
		public List<Inscription> getAll() {
			System.out.println("Get all Inscriptions 11111...");
	    	return repository.findAll();    	
	    }
		
		
		public int max(int ann) {
			return repository.max(ann);
		}
		
		public int nbre(int ann) {
			return repository.nbre(ann);
		}
	  
	    
	    public long save(Inscription inscription) {
	    	System.out.println("save  all Inscriptions 11111...");
	    	   Optional<Compteur> CompteurInfo = compteurRepository.findByAnnee(inscription.getAnnee());
		     	if (CompteurInfo.isPresent()) {
			    	Compteur compteur = CompteurInfo.get();
			           compteur.setNumInscription(compteur.getNumInscription()+1);
			         compteur =   compteurRepository.save(compteur);
		     	}
	        return repository.save(inscription)
	                             .getId();
	    }
	    public void update(long id, Inscription inscription) {
	        Optional<Inscription> inscri = repository.findById(id);
	        if (inscri.isPresent()) {
	            Inscription insc = inscri.get();
	            repository.save(insc);
	        }
	    }
	  
	
	   

	    public void delete(long id) {
	        Optional<Inscription> insc = repository.findById(id);
	        insc.ifPresent(repository::delete);
	    }





		public Optional<Inscription> findById(long id) {
			// TODO Auto-generated method stub
			return repository.findById(id);
		}





		
}


