package com.pfe.myschool.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.pfe.myschool.model.Compteur;
import com.pfe.myschool.model.Lreglement;
import com.pfe.myschool.model.Reglement;
import com.pfe.myschool.repository.CompteurRepository;
import com.pfe.myschool.repository.LreglementRepository;
import com.pfe.myschool.repository.ReglementRepository;

@Service
@Transactional
public class ReglementService {
	 @Autowired
		ReglementRepository repository;
	 @Autowired
		LreglementRepository lreglementRepository;		
	 @Autowired
		CompteurRepository compteurRepository;
	 public List<Reglement> getAll() {
			System.out.println("Get all Reglements 11111...");
	    	return repository.findAll();    	
	    }
		
		
		 public long  save(@Valid @RequestBody Reglement reglement) {
			   System.out.println("save lreglment");
			   List<Lreglement> lreglements = reglement.getLreglement();
			   
			   for (Lreglement lreglement : lreglements) {
			    	System.out.println(reglement.getNumero());
		            lreglement.setNumero(reglement.getNumero());
		            lreglementRepository.save(lreglement);
			       }
			  
	  	 return repository.save(reglement)
                         .getId();
		    }
	  
	    
	    public void update(long id, Reglement reglement) {
	        Optional<Reglement> regl = repository.findById(id);
	        if (regl.isPresent()) {
	            Reglement reg = regl.get();
	            repository.save(reg);
	        }
	    }
	  
	
	   

	    public void delete(long id) {
	        Optional<Reglement> reg = repository.findById(id);
	        reg.ifPresent(repository::delete);
	    }



		public Optional<Reglement> findById(long id) {
			// TODO Auto-generated method stub
			return repository.findById(id);
		}


		public int nbMois(int annee,int m ) {
			  System.out.println("somme montant.....");
				return repository.nbre1(annee,m);
		}
		
		public double getMontMois(int annee,int m) {
			  System.out.println("somme montant.....");
			return repository.n1(annee,m);
		}

		public int nbAnnee(int annee) {
			// TODO Auto-generated method stub
			return repository.nbre2(annee);
		}


		public double getMontAnnee(int annee) {
			// TODO Auto-generated method stub
			return repository.tot1(annee);
		}

		public List<Reglement> listReglement(Date d1,Date d2) {
			System.out.println("service reglement....");
			return repository.findByDateReglementBetween(d1, d2);
		//	https://bushansirgur.in/spring-data-jpa-between-date-example/
		}
		
}


