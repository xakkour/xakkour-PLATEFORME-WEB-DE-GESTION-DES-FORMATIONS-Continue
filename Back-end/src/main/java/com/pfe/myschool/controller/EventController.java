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
import com.pfe.myschool.model.Event;
import com.pfe.myschool.service.EventService;
	@CrossOrigin(origins = "http://localhost:4200")
	@RestController
	@RequestMapping("/api")
	public class EventController {
		 @Autowired
		    private EventService eventService;
		 @Autowired  ServletContext context;
		 
		 @GetMapping("/events/7/{ann}")
		 public  int getNumero(@PathVariable int ann) {
		 
			 System.out.println("Get Numbers...");
			 int  x = eventService.nbre(ann);
			 System.out.println(x);
			 if (x == 0)
			 {
				 return 0;
			 }
			 else
			 {
				 return eventService.max(ann);
			 }
		    
		 }
		 
		 @GetMapping("/events")
		    public List<Event> list() {
			 System.out.println("Get all Events...");
		             return eventService.getAll();
		   }
		 	 
		 @GetMapping("/events/{id}")
		 public ResponseEntity<Event> post(@PathVariable long id) {
		        Optional<Event> cat = eventService.findById(id);
		        return cat.map(ResponseEntity::ok)
		                   .orElseGet(() -> ResponseEntity.notFound()
	                                                  .build());
		    }
		    
		

		 @PutMapping("/events")
		    public void update( @RequestBody Event event) {
		       
		            eventService.update(event);
		      
		    }

		    
		    @PostMapping("/events")
			 public long createEvent (@RequestParam("file") MultipartFile file,
					 @RequestParam("event") String event) throws JsonParseException , JsonMappingException , Exception
			 {
				 System.out.println("add Event");
				Event eventt = new ObjectMapper().readValue(event, Event.class);
				addEventImage(file);
			    String filename = file.getOriginalFilename();
			    String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
			    eventt.setFileName(newFileName);
			  
		    
			    return eventService.save(eventt);
			 }

			 @PutMapping("/events/{id}")
			    public void update(@PathVariable long id,@RequestParam("file") MultipartFile file,
						 @RequestParam("event") String event) throws JsonParseException , JsonMappingException , Exception {
			     Event eventt = new ObjectMapper().readValue(event, Event.class);
			        	deleteEventImage(eventt);
			        	 String filename = file.getOriginalFilename();
			     	    String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
			     	    eventt.setFileName(newFileName);
			            eventService.update( eventt);
			           
			            addEventImage(file);
			       
			    }

			    @DeleteMapping("/events/{id}")
			    public void delete(@PathVariable long id) {
			        eventService.delete(id);
			    }
			     
			    
			    @GetMapping(path="/ImgEvents/{id}")
				 public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
			    	 System.out.println("Get all Events Images...");
					 Event event   =eventService.findById(id).get();
					 return Files.readAllBytes(Paths.get(context.getRealPath("/ImgEvents/")+event.getFileName()));
				 }
			    
			    private void addEventImage(MultipartFile file)
			    {
			    	boolean isExit = new File(context.getRealPath("/ImgEvents/")).exists();
				    if (!isExit)
				    {
				    	new File (context.getRealPath("/ImgEvents/")).mkdir();
				    	System.out.println("mk dir ImgEvents.............");
				    }
				    String filename = file.getOriginalFilename();
				    String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
				    File serverFile = new File (context.getRealPath("/ImgEvents/"+File.separator+newFileName));
				    try
				    {
				    
				    	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
				    	 
				    }catch(Exception e) {
				    	 System.out.println("Failed to Add Image Event !!");
				    }
				    
			    	
			    }
			    
			    private void deleteEventImage(Event event)
			    {
			    	System.out.println( " Delete Event Image");
			         try { 
			        	 File file = new File (context.getRealPath("/ImgEvents/"+event.getFileName()));
			             System.out.println(event.getFileName());
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


	

