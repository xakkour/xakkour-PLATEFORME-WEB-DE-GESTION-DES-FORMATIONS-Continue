package com.pfe.myschool.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import com.pfe.myschool.model.User;
import com.pfe.myschool.repository.UserRepository;

@Service
@Transactional
public class UserService {

	private static final long EXPIRE_TOKEN_AFTER_MINUTES = 60;
	 @Autowired
		 UserRepository repository;




	public long save(User User) {
		System.out.println("save  all Users 11111...");
		return repository.save(User)
				.getId();
	}


	 @Autowired
		private JavaMailSender mailSender;
	 
		public List<User> getAll() {
			System.out.println("Get all Users 11111...");
	    	return repository.findAll(Sort.by("username").ascending());	    	
	    }
		
	    public Optional<User> findById(long id) {
	        return repository.findById(id);
	    }
	    

	    
	    public void update(long id, User user) {
		        user.setFileName(user.getFileName());
	            repository.save(user);
	        }
	    
	
	    public Optional<User> login(String name) {
	    	System.out.println(name);
	        return repository.findByUsername(name);
	    }

	    public void delete(long id) {
	        Optional<User> user = repository.findById(id);
	        user.ifPresent(repository::delete);
	    }
	    

	   
		public Optional <User> findUserByEmail(String email) {
			return repository.findByEmail(email);
		}

		
		public Optional <User> findUserByResetToken(String resetToken) {
			return repository.findByResetToken(resetToken);
		}
		
		@Async
		public void sendEmail(SimpleMailMessage email) {
			mailSender.send(email);
		}
}