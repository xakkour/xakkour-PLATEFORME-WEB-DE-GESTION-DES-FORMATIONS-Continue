package com.pfe.myschool.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.pfe.myschool.model.Etudiant;
import com.pfe.myschool.model.User;
import com.pfe.myschool.repository.EtudiantRepository;
import com.pfe.myschool.repository.UserRepository;

@Service
@Transactional
public class EtudiantService {

	 @Autowired
		EtudiantRepository repository;
	 @Autowired 	UserRepository userRepository;
	 @Autowired
		private JavaMailSender mailSender;
		public List<Etudiant> getAll() {
			System.out.println("Get all Etudiants 11111...");
			
	    	return repository.findAll();	    	
	    }
		
		public int max(int ann) {
			return repository.max(ann);
		}
		
		public int nbre(int ann) {
			return repository.nbre(ann);
		}
		
	    public long save(Etudiant etudiant) {
	    	String  pwd ;
	    	System.out.println("save  all Etudiants 11111...");
	    	User user = new User();
	        user.setUsername(etudiant.getEmail());
	        user.setEmail(etudiant.getEmail());
	        user.setMatricule(etudiant.getMatricule());
	        pwd = RandomStringUtils.randomAlphanumeric(8);
	        user.setPassword(pwd);
	        user.setRole("ETUDIANT");
	        user.setActive(true);
	        userRepository.save(user);
	        etudiant.setPwd(pwd);
	    /*    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
 			simpleMailMessage.setFrom("testab.symfony@gmail.com");
 			simpleMailMessage.setTo(etudiant.getEmail());
 			simpleMailMessage.setSubject("Mot de Passe ");
 			simpleMailMessage.setText("Votre Mot de passe :" + pwd);
			sendEmail(simpleMailMessage);**/
	        etudiant.setMoy(0);
	        etudiant.setAbsent(null);
	        return repository.save(etudiant)
	                             .getId();
	    }
	    @Async
		public void sendEmail(SimpleMailMessage email) {
			mailSender.send(email);
		}
		public void update(Etudiant etudiant) {
	       
	            repository.save(etudiant);
	        }
	    
	    public void delete(long id) {
	        Optional<Etudiant> etud = repository.findById(id);
	        etud.ifPresent(repository::delete);
	    }

		public Optional<Etudiant> findById(long id) {
			  return repository.findById(id);
		}

		public Optional<Etudiant> findByMatricule(String mat) {
			// TODO Auto-generated method stub
			 return repository.findByMatricule(mat);
		}

			public List<Etudiant> findAllByCodeClasse(String code) {
			// TODO Auto-generated method stub
			return repository.findAllByCodeClasse(code);
		}
}
