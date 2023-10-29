package com.pfe.myschool.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.pfe.myschool.model.Event;
import com.pfe.myschool.repository.EventRepository;
@Service
@Transactional
public class EventService {
	 @Autowired
		EventRepository repository;
	 public List<Event> getAll() {
			System.out.println("Get all Events 11111...");
	    	return repository.findAll();    	
	    }
		
	 public long  save(@Valid @RequestBody Event Event) {
			   System.out.println("save lEvent");
			  
			
	  	 return repository.save(Event)
                         .getId();
	}
	  
	    
	public long update(Event event) {
	       
	            return repository.save(event)
	            .getId();
	        }
	
	
	public void delete(long id) {
	        Optional<Event> qc = repository.findById(id);
	        qc.ifPresent(repository::delete);
	}

	public Optional<Event> findById(long id) {
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

