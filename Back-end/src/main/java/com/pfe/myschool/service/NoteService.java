package com.pfe.myschool.service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.pfe.myschool.model.Lnote;
import com.pfe.myschool.model.Note;
import com.pfe.myschool.repository.LnoteRepository;
import com.pfe.myschool.repository.NoteRepository;
@Service
@Transactional
public class NoteService {
	 @Autowired
		NoteRepository repository;
	 @Autowired
		LnoteRepository lnoteRepository;		
	
	 public List<Note> getAll() {
			System.out.println("Get all Notes 11111...");
	    	return repository.findAll();    	
	    }
		
	 public long  save(@Valid @RequestBody Note note) {
			   System.out.println("save lnote");
			   List<Lnote> lnotes = note.getLnotes();
			   for (Lnote lnote : lnotes) {
			    	lnote.setNumero(note.getNumero());
		           lnoteRepository.save(lnote);
			       }
			
	  	 return repository.save(note)
                         .getId();
	}
	  
	    
	public void update(long id, Note note) {
	        Optional<Note> not = repository.findById(id);
	        if (not.isPresent()) {
	            Note notes = not.get();
	            repository.save(notes);
	        }
	}
	
	public void delete(long id) {
	        Optional<Note> not = repository.findById(id);
	        not.ifPresent(repository::delete);
	}

	public Optional<Note> findById(long id) {
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
