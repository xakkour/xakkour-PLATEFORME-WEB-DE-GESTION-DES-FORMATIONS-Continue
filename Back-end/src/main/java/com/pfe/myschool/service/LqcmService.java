package com.pfe.myschool.service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pfe.myschool.model.Lqcm;
import com.pfe.myschool.repository.LqcmRepository;
@Service
@Transactional
public class LqcmService {
	 @Autowired
		LqcmRepository repository;
		public List<Lqcm> getAll() {
			System.out.println("Get all Lqcms 11111...");
	    	return repository.findAll();	    	
	    }
		

	    public void delete(long id) {
	        Optional<Lqcm> cat = repository.findById(id);
	        cat.ifPresent(repository::delete);
	    }

	    public List<Lqcm> findByNumero(int numero) {
	    	System.out.println("Get all Lqcms service..");
	        return repository.findByNumero(numero);
	    }



		
}
