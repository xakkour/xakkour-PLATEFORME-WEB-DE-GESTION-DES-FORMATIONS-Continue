package com.pfe.myschool.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pfe.myschool.model.Enseignant;

import com.pfe.myschool.service.EnseignantService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EnseignantController {
	 @Autowired
	    private EnseignantService enseignantService;
	 @Autowired  ServletContext context;
	 
	 @GetMapping("/enseignants")
	    public List<Enseignant> list() {
		 System.out.println("Get all Enseignants...");
	             return enseignantService.getAll();
	   }
	 
	 @GetMapping("/enseignants/7/{ann}")
	 public  int getMatricule(@PathVariable int ann) {
		 System.out.println("Get Numbers...");
		 int  x = enseignantService.nbre(ann);
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return enseignantService.max(ann);
		 }
	    
	 }
	 
	 @GetMapping("/enseignants/{id}")
	 public ResponseEntity<Enseignant> post(@PathVariable Long id) {
	        Optional<Enseignant> ens = enseignantService.findById(id);
	        return ens.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                         .build());
	    }
	 
	 @GetMapping("/enseignants/E/{mat}")
	 public ResponseEntity<Enseignant> rechEnseignant(@PathVariable String mat) {
		 System.out.println("Recherche Enseignant...");
	        Optional<Enseignant> ens = enseignantService.findByMatricule(mat);
	        return ens.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
	    }
	  
	 @PostMapping("/enseignants")
	 public long createUser (@RequestParam("file") MultipartFile file,
			 @RequestParam("enseignant") String enseignant) throws JsonParseException , JsonMappingException , Exception
	 {
		 System.out.println("Save Enseignants...");
		Enseignant ensei = new ObjectMapper().readValue(enseignant, Enseignant.class);
		addImage(file);
	    String filename = file.getOriginalFilename();
	    String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
	    ensei.setFileName(newFileName);
	    return enseignantService.save(ensei);
	 }
	



	@PostMapping("/Enseignants")
	    public long save(@RequestBody Enseignant enseignant) {
		 
	        return enseignantService.save(enseignant);
	    }

	 @PutMapping("/enseignants")
	    public void update(@RequestBody Enseignant enseignant) {
	       
	            enseignantService.update(enseignant);
	      
	    }

	    @DeleteMapping("/enseignants/{id}")
	    public void delete(@PathVariable long id) {
	        enseignantService.delete(id);
	    }
	    private void addImage(MultipartFile file)
	    {
	    	
	    	boolean isExit = new File(context.getRealPath("/ImgEnseignants/")).exists();
		    if (!isExit)
	    	
		    {
		    	new File (context.getRealPath("/ImgEnseignants/")).mkdir();
		    	System.out.println("mk dir ImgEnseignants............");
		    }
		    String filename = file.getOriginalFilename();
		    String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
		    File serverFile = new File (context.getRealPath("/ImgEnseignants/"+File.separator+newFileName));
		    try
		    {
		    
		    	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
		    	 
		    }catch(Exception e) {
		    	 System.out.println("Failed to Add Image Enseignants !!");
		    }
		    
	    	
	    }
	@GetMapping("/enseignants/search")

	public ResponseEntity<List<Enseignant>> searchetablissements(@RequestParam("query") String query) {
		List<Enseignant> enseignantList = enseignantService.customSearch(query);
		return new ResponseEntity<>(enseignantList, HttpStatus.OK);
	}
	    @GetMapping(path="/ImgEnseignants/{id}")
		 public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
	    	 System.out.println("Get all Users Images...");
			 Enseignant  enseignant   =enseignantService.findById(id).get();
			 return Files.readAllBytes(Paths.get(context.getRealPath("/ImgEnseignants/")+enseignant.getFileName()));
		 }

}
