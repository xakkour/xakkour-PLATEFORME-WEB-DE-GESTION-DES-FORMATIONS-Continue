package com.pfe.myschool.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.pfe.myschool.model.Etablissement;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.myschool.model.Enseignant;

import com.pfe.myschool.model.User;
import com.pfe.myschool.repository.EnseignantRepository;
import com.pfe.myschool.repository.UserRepository;
@Service
@Transactional
public class EnseignantService {
	@Autowired
	EnseignantRepository repository;
	@Autowired 	UserRepository userRepository;
 public List<Enseignant> getAll() {
		System.out.println("Get all Enseignant ...");
    	return repository.findAll();	    	
    }
 public int max(int ann) {
		return repository.max(ann);
	}
	
	public int nbre(int ann) {
		return repository.nbre(ann);
	}
 public Optional<Enseignant> findById(Long id) {
        return repository.findById(id);
    }
    
    public long save(Enseignant enseignant) {
    	System.out.println("save  all Enseignants ...");
    	 User user = new User();
	        user.setUsername(enseignant.getEmail());
	        user.setNom(enseignant.getNom());
	        user.setEmail(enseignant.getEmail());
	        user.setMatricule(enseignant.getMatricule());
	        user.setPassword(RandomStringUtils.randomAlphanumeric(8));
	        user.setRole("ENSEIGNANT");
	        user.setActive(true);
	        userRepository.save(user);
        return repository.save(enseignant)
                             .getId();
    }
    public void update(Enseignant Enseignant) {
       
            repository.save(Enseignant);
        }
    
  

   

    public void delete(long id) {
        Optional<Enseignant> ens = repository.findById(id);
        ens.ifPresent(repository::delete);
    }
	public List<Enseignant> customSearch(String mot) {
		return repository.customSearch(mot);
	}
	public Optional<Enseignant> findByMatricule(String mat) {

			 return repository.findByMatricule(mat);
		}
}
