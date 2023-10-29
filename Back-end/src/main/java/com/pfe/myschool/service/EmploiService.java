package com.pfe.myschool.service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.pfe.myschool.model.Lemploi;
import com.pfe.myschool.model.Emploi;
import com.pfe.myschool.repository.LemploiRepository;
import com.pfe.myschool.repository.EmploiRepository;
@Service
@Transactional
public class EmploiService {
	@Autowired
	EmploiRepository repository;
 @Autowired
	LemploiRepository LemploiRepository;		
 
 public List<Emploi> getAll() {
		System.out.println("Get all Emplois 11111...");
    	return repository.findAll();    	
    }
	
 public long  save(@Valid @RequestBody Emploi Emploi) {
		   System.out.println("save Lemploi");
		   List<Lemploi> Lemplois = Emploi.getLemplois();
		   for (Lemploi Lemploi : Lemplois) {
               Lemploi.setNumero(Emploi.getNumero());
	           System.out.println(" save data ligne");
	           LemploiRepository.save(Lemploi);
		       }
		
  	 return repository.save(Emploi)
                     .getId();
}
  
    
public void update(long id, Emploi Emploi) {
        Optional<Emploi> not = repository.findById(id);
        if (not.isPresent()) {
            Emploi Emplois = not.get();
            repository.save(Emplois);
        }
}

public void delete(long id) {
        Optional<Emploi> not = repository.findById(id);
        not.ifPresent(repository::delete);
}

public Optional<Emploi> findById(long id) {
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
