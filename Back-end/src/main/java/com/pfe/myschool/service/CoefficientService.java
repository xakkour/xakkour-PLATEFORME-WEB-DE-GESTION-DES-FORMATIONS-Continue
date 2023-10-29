package com.pfe.myschool.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pfe.myschool.dto.ListCours;
import com.pfe.myschool.model.Coefficient;
import com.pfe.myschool.repository.CoefficientRepository;

@Service
@Transactional
public class CoefficientService {
	 @Autowired
		CoefficientRepository repository;
	 
	 public int max() {
			return repository.max();
		}
		
		public int nbre() {
			return repository.nbre();
		}
		public List<Coefficient> getAll() {
			System.out.println("Get all Coefficients 11111...");
	    	return repository.findAll(Sort.by("libelle").ascending());	    	
	    }
		
		
		
	    public Optional<Coefficient> findById(Long id) {
	        return repository.findById(id);
	    }
	    
	    public long save(Coefficient coefficient) {
	    	System.out.println("save  all Coefficients 11111...");
	        
	        return repository.save(coefficient)
	                             .getId();
	    }
	    public void update(Coefficient coefficient) {
	    	
	            repository.save(coefficient);
	        }
	    
	  
	
	    

	    public void delete(long id) {
	        Optional<Coefficient> coef = repository.findById(id);
	        coef.ifPresent(repository::delete);
	    }

		public double getCoefficient(String cl, String mat) {
			// TODO Auto-generated method stub
			return repository.getCoefficient(cl,mat);
		}



	
}

