package com.pfe.myschool.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.myschool.dto.ListCours;
import com.pfe.myschool.model.Cours;
import com.pfe.myschool.repository.CoursRepository;

@Service
@Transactional
public class CoursService {
	@Autowired
	CoursRepository repository;
 
 public List<ListCours> getAll() {
		System.out.println("Get all Cours 11111...");
    	return repository.listAll();	    	
    }
 
 public Optional<Cours> findById(Long id) {
        return repository.findById(id);
    }
    
    public long save(Cours cours) {
    	System.out.println("save  all Cours 11111...");
        
        return repository.save(cours)
                             .getId();
    }
    public void update(Cours cours) {
       
            repository.save(cours);
        }
    
  

   

    public void delete(long id) {
        Optional<Cours> cou = repository.findById(id);
        cou.ifPresent(repository::delete);
    }

	public List<ListCours> getCoursCl(String matricule) {
		// TODO Auto-generated method stub
		return repository.listCours(matricule);
	}

	public List<ListCours> getCoursMat(String code, String cl) {
		
		return repository.listMatiere(code, cl);
		
	}

	public int max(int ann) {
		return repository.max(ann);
	}
	
	public int nbre(int ann) {
		return repository.nbre(ann);
	}

}
