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
import com.pfe.myschool.dto.ListCours;
import com.pfe.myschool.model.Etudiant;
import com.pfe.myschool.service.EtudiantService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api")
public class EtudiantController {
	 @Autowired
	    private EtudiantService etudiantService;
	 @Autowired  ServletContext context;
	
	 @GetMapping("/etudiants/7/{ann}")
	 public  int getMatricule(@PathVariable int ann) {
		 System.out.println("Get Numbers...");
		 int  x = etudiantService.nbre(ann);
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return etudiantService.max(ann);
		 }
	    
	 }
	 
	 @GetMapping("/etudiants")
	    public List<Etudiant> list() {
		 System.out.println("Get all Etudiants...");
	             return etudiantService.getAll();
	   }
	 	 
	 @GetMapping("/etudiants/{id}")
	 public ResponseEntity<Etudiant> post(@PathVariable long id) {
	        Optional<Etudiant> cat = etudiantService.findById(id);
	        return cat.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
	    }
	 
	 @GetMapping("/etudiants/E/{mat}")
	 public ResponseEntity<Etudiant> rechEtudiant(@PathVariable String mat) {
		 System.out.println("Recherche Etudiant...");
	        Optional<Etudiant> etu = etudiantService.findByMatricule(mat);
	        return etu.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
	    }
	 
	 @PostMapping("/etudiants")
	 public long createUser (@RequestParam("file") MultipartFile file,
			 @RequestParam("etudiant") String etudiant) throws JsonParseException , JsonMappingException , Exception
	 {
		 System.out.println("Save Etudiants...");
		Etudiant etud = new ObjectMapper().readValue(etudiant, Etudiant.class);
		addImage(file);
	    String filename = file.getOriginalFilename();
	    String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
	    etud.setFileName(newFileName);
	    return etudiantService.save(etud);
	 }
	 
	 @GetMapping("etudiants/cl/{code}")
	    public List<Etudiant> listEtudiant(@PathVariable String code) {
		 System.out.println(code);
	             return etudiantService.findAllByCodeClasse(code);
	   }
	    
	 @PostMapping("/etudiants/S")
	    public long save(@RequestBody Etudiant etudiant) {
		 
	        return etudiantService.save(etudiant);
	    }
	    

	 @PutMapping("/etudiants")
	    public void update( @RequestBody Etudiant etudiant) {
	       
	            etudiantService.update(etudiant);
	      
	    }

	    @DeleteMapping("/etudiants/{id}")
	    public void delete(@PathVariable long id) {
	        etudiantService.delete(id);
	    }
	     
	    private void addImage(MultipartFile file)
	    {
	    	
	    	boolean isExit = new File(context.getRealPath("/ImgEtudiants/")).exists();
		    if (!isExit)
	    	
		    {
		    	new File (context.getRealPath("/ImgEtudiants/")).mkdir();
		    	System.out.println("mk dir ImgEtudiants............");
		    }
		    String filename = file.getOriginalFilename();
		    String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
		    File serverFile = new File (context.getRealPath("/ImgEtudiants/"+File.separator+newFileName));
		    try
		    {
		    
		    	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
		    	 
		    }catch(Exception e) {
		    	 System.out.println("Failed to Add Image Etudiant !!");
		    }
		    
	    	
	    } 
	    
	    @GetMapping(path="/ImgEtudiants/{id}")
		 public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
	    	 System.out.println("Get all Users Images...");
			 Etudiant  etudiant   =etudiantService.findById(id).get();
			 return Files.readAllBytes(Paths.get(context.getRealPath("/ImgEtudiants/")+etudiant.getFileName()));
		 }
	    
	     
	  
}
