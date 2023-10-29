package com.pfe.myschool.service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.pfe.myschool.model.Examen;
import com.pfe.myschool.repository.ExamenRepository;
@Service
@Transactional
public class ExamenService {
	 @Autowired
		ExamenRepository repository;
		
	
	 public List<Examen> getAll() {
			System.out.println("Get all Examens 11111...");
	    	return repository.findAll();    	
	    }
		
	 public long  save(@Valid @RequestBody Examen Examen) {
		   System.out.println("save lExamen");
		  
		
	 return repository.save(Examen)
                   .getId();
}
	  
	    
	public void update(long id, Examen Examen) {
	        Optional<Examen> qc = repository.findById(id);
	        if (qc.isPresent()) {
	            Examen Examens = qc.get();
	            repository.save(Examens);
	        }
	}
	
	public void delete(long id) {
	        Optional<Examen> qc = repository.findById(id);
	        qc.ifPresent(repository::delete);
	}

	public Optional<Examen> findById(long id) {
			// TODO Auto-generated method stub
			return repository.findById(id);
	}
	
	public int max(int ann) {
		return repository.max(ann);
	}
	
	public int nbre(int ann) {
		return repository.nbre(ann);
	}
}

