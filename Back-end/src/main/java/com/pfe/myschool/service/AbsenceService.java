package com.pfe.myschool.service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.pfe.myschool.model.Labsence;
import com.pfe.myschool.model.Absence;
import com.pfe.myschool.repository.LabsenceRepository;
import com.pfe.myschool.repository.AbsenceRepository;
@Service
@Transactional
public class AbsenceService {
	 @Autowired
		AbsenceRepository repository;
	 @Autowired
		LabsenceRepository lAbsenceRepository;		
	
	 public List<Absence> getAll() {
			System.out.println("Get all Absences 11111...");
	    	return repository.findAll();    	
	    }
		
	 public long  save(@Valid @RequestBody Absence absence) {
			   System.out.println("save lAbsence");
			   List<Labsence> labsences = absence.getLabsences();
			   for (Labsence labsence : labsences) {
			    	 System.out.println(absence.getNumero());
			    	
		            labsence.setNumero(absence.getNumero());
		           System.out.println(" save data ligne");
		           lAbsenceRepository.save(labsence);
			       }
			
	  	 return repository.save(absence)
                         .getId();
	}
	  
	    
	public void update(long id, Absence Absence) {
	        Optional<Absence> not = repository.findById(id);
	        if (not.isPresent()) {
	            Absence Absences = not.get();
	            repository.save(Absences);
	        }
	}
	
	public void delete(long id) {
	        Optional<Absence> not = repository.findById(id);
	        not.ifPresent(repository::delete);
	}

	public Optional<Absence> findById(long id) {
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
