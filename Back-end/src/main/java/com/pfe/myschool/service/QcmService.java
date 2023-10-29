package com.pfe.myschool.service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.pfe.myschool.model.Lqcm;
import com.pfe.myschool.model.Qcm;
import com.pfe.myschool.repository.LqcmRepository;
import com.pfe.myschool.repository.QcmRepository;
@Service
@Transactional
public class QcmService {
	 @Autowired
		QcmRepository repository;
	 @Autowired
		LqcmRepository lqcmRepository;		
	
	 public List<Qcm> getAll() {
			System.out.println("Get all Qcms 11111...");
	    	return repository.findAll();    	
	    }
		
	 public long  save(@Valid @RequestBody Qcm qcm) {
		   System.out.println("save lqcm");
		   List<Lqcm> lqcms = qcm.getLqcms();
		   for (Lqcm lqcm : lqcms) {
		    	lqcm.setNumero(qcm.getNumero());
	           lqcmRepository.save(lqcm);
		       }
		
	 return repository.save(qcm)
                   .getId();
}
	  
	    
	public void update(long id, Qcm qcm) {
	        Optional<Qcm> qc = repository.findById(id);
	        if (qc.isPresent()) {
	            Qcm qcms = qc.get();
	            repository.save(qcms);
	        }
	}
	
	public void delete(long id) {
	        Optional<Qcm> qc = repository.findById(id);
	        qc.ifPresent(repository::delete);
	}

	public Optional<Qcm> findById(long id) {
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

