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
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pfe.myschool.model.Examen;
import com.pfe.myschool.service.ExamenService;
	@CrossOrigin(origins = "http://localhost:4200")
	@RestController
	@RequestMapping("/api")
	public class ExamenController {
		 @Autowired
		    private ExamenService examenService;
		 @Autowired  ServletContext context;
		 
		 @GetMapping("/examens/7/{ann}")
		 public  int getNumero(@PathVariable int ann) {
		 
			 System.out.println("Get Numbers...");
			 int  x = examenService.nbre(ann);
			 System.out.println(x);
			 if (x == 0)
			 {
				 return 0;
			 }
			 else
			 {
				 return examenService.max(ann);
			 }
		    
		 }
		 
		 @GetMapping("/examens")
		    public List<Examen> list() {
			 System.out.println("Get all Examens...");
		             return examenService.getAll();
		   }
		 	 
		 @GetMapping("/examens/{id}")
		 public ResponseEntity<Examen> post(@PathVariable long id) {
		        Optional<Examen> cat = examenService.findById(id);
		        return cat.map(ResponseEntity::ok)
		                   .orElseGet(() -> ResponseEntity.notFound()
	                                                  .build());
		    }
		    
		

		 @PutMapping("/examens/{code}")
		    public void update(@PathVariable long id, @RequestBody Examen examen) {
		       
		            examenService.update(id, examen);
		      
		    }

		    
		    @PostMapping("/examens")
			 public long createExamen (@RequestParam("file") MultipartFile file,
					 @RequestParam("examen") String examen) throws JsonParseException , JsonMappingException , Exception
			 {
				 System.out.println("add Examen");
				Examen exament = new ObjectMapper().readValue(examen, Examen.class);
				addExamenImage(file);
			    String filename = file.getOriginalFilename();
			    String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
			    exament.setFileName(newFileName);
			  
		    
			    return examenService.save(exament);
			 }

			 @PutMapping("/examens/{id}")
			    public void update(@PathVariable long id,@RequestParam("file") MultipartFile file,
						 @RequestParam("Examen") String Examen) throws JsonParseException , JsonMappingException , Exception {
			     Examen Exament = new ObjectMapper().readValue(Examen, Examen.class);
			        	deleteExamenImage(Exament);
			        	 String filename = file.getOriginalFilename();
			     	    String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
			     	    Exament.setFileName(newFileName);
			            examenService.update(id, Exament);
			           
			            addExamenImage(file);
			       
			    }

			    @DeleteMapping("/examens/{id}")
			    public void delete(@PathVariable long id) {
			        examenService.delete(id);
			    }
			     
			    
			    @GetMapping(path="/ImgExamens/{id}")
				 public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
			    	 System.out.println("Get all Examens Images...");
					 Examen examen   =examenService.findById(id).get();
					 return Files.readAllBytes(Paths.get(context.getRealPath("/ImgExamens/")+examen.getFileName()));
				 }
			    
			    private void addExamenImage(MultipartFile file)
			    {
			    	boolean isExit = new File(context.getRealPath("/ImgExamens/")).exists();
				    if (!isExit)
				    {
				    	new File (context.getRealPath("/ImgExamens/")).mkdir();
				    	System.out.println("mk dir ImgExamens.............");
				    }
				    String filename = file.getOriginalFilename();
				    String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
				    File serverFile = new File (context.getRealPath("/ImgExamens/"+File.separator+newFileName));
				    try
				    {
				    
				    	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
				    	 
				    }catch(Exception e) {
				    	 System.out.println("Failed to Add Image Examen !!");
				    }
				    
			    	
			    }
			    
			    private void deleteExamenImage(Examen Examen)
			    {
			    	System.out.println( " Delete Examen Image");
			         try { 
			        	 File file = new File (context.getRealPath("/ImgExamens/"+Examen.getFileName()));
			             System.out.println(Examen.getFileName());
			              if(file.delete()) { 
			                System.out.println(file.getName() + " is deleted!");
			             } else {
			                System.out.println("Delete operation is failed.");
			                }
			          }
			            catch(Exception e)
			            {
			                System.out.println("Failed to Delete image !!");
			            }
			    }

		    
		  
	}


	

