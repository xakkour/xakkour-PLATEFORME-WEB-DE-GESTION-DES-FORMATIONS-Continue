package com.pfe.myschool.service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.pfe.myschool.model.Horaire;
import com.pfe.myschool.repository.HoraireRepository;
@Service
@Transactional
public class HoraireService {
	 @Autowired
		HoraireRepository repository;
		public List<Horaire> getAll() {
			System.out.println("Get all Horaires 11111...");
	    	return repository.findAll(Sort.by("code").ascending());	    	
	    }
		
		
		
	    public Optional<Horaire> findById(Long id) {
	        return repository.findById(id);
	    }
	    
	    public long save(Horaire horaire) {
	    	System.out.println("save  all Horaires 11111...");
	        
	        return repository.save(horaire)
	                             .getId();
	    }
	    public void update(Horaire horaire) {
	    	
	            repository.save(horaire);
	        }
	    
	  
	
	  
	    public void delete(long id) {
	        Optional<Horaire> ban = repository.findById(id);
	        ban.ifPresent(repository::delete);
	    }



	    public int max() {
			return repository.max();
		}
		
		public int nbre() {
			return repository.nbre();
		}



	
}
