package com.pfe.myschool.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.myschool.model.Note;
import com.pfe.myschool.service.NoteService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class NoteController {
	 @Autowired
	    private NoteService noteService;
	 
	 @GetMapping("/notes/7/{ann}")
	 public  int getNumero(@PathVariable int ann) {
	 
		 System.out.println("Get Numbers...");
		 int  x = noteService.nbre(ann);
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return noteService.max(ann);
		 }
	    
	 }
	 
	 @GetMapping("/notes")
	    public List<Note> list() {
		 System.out.println("Get all Notes...");
	             return noteService.getAll();
	   }
	 	 
	 @GetMapping("/notes/{id}")
	 public ResponseEntity<Note> post(@PathVariable long id) {
	        Optional<Note> cat = noteService.findById(id);
	        return cat.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
	    }
	    
	 @PostMapping("/notes")
	    public long save(@RequestBody Note note) {
		 
	        return noteService.save(note);
	    }

	 @PutMapping("/notes/{code}")
	    public void update(@PathVariable long id, @RequestBody Note note) {
	       
	            noteService.update(id, note);
	      
	    }

	    @DeleteMapping("/notes/{id}")
	    public void delete(@PathVariable long id) {
	        noteService.delete(id);
	    }
	     
	  
}

