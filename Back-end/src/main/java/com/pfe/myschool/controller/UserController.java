package com.pfe.myschool.controller;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pfe.myschool.model.User;
import com.pfe.myschool.service.UserService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
	
	 @Autowired  private UserService userService;
	 @Autowired  ServletContext context;
	 private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;
	 /*
		 * The Spring Framework provides an easy abstraction for sending email by using
		 * the JavaMailSender interface, and Spring Boot provides auto-configuration for
		 * it as well as a starter module.
		 */
		
	 @GetMapping("/users")
	    public List<User> list() {
		 System.out.println("Get all Users...");
	             return userService.getAll();
	   }
	 	 
	 @GetMapping("/users/{id}")
	 public ResponseEntity<User> post(@PathVariable long id) {
	        Optional<User> user = userService.findById(id);
	        return user.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                               .build());
	    }
	    
	 @GetMapping("/users/verif/{email}/{pwd}")
	    public String findUserByEmail(@PathVariable String email, @PathVariable String pwd, HttpServletRequest request) {
	    	 Optional<User> user = userService.findUserByEmail(email);
		 String appUrl = request.getScheme() + "://" + request.getServerName()+":4200";
		 if (!user.isPresent()) {
				System.out.println( "We didn't find an account for that e-mail address.");
				return "0";
			} else {
				User userr = user.get();
				if (userr.getPassword().equals(pwd) )
				{
				userr.setDateToken(LocalDateTime.now());
				userr.setResetToken(UUID.randomUUID().toString());
     			userService.save(userr);
     			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
     			simpleMailMessage.setFrom("testab.symfony@gmail.com");
     			simpleMailMessage.setTo(userr.getEmail());
     			simpleMailMessage.setSubject("Password Reset Request");
     			simpleMailMessage.setText("Pou récupérer votre Mot De passe cliquer sur ce Lien :\n" + appUrl
    					+ "/resetpwd?token=" + userr.getResetToken());
     			System.out.println(userr.getResetToken());
    			userService.sendEmail(simpleMailMessage);
    			return "1";
				}
				else
				{
					System.out.println( "Mot de Passe Incorrecte");
					return ("2");
			}
	   }
	 }
	 
	 @GetMapping("/users/rest/{resetToken}/{password}")
	    public String findUserByResetToken (@PathVariable String resetToken,@PathVariable String password) {
		 System.out.println("Get  User By resetToken..");
	            
	             Optional<User> user = userService.findUserByResetToken(resetToken);
	             if (!user.isPresent()) {
	 				System.out.println( "We didn't find an account for that Token");
	 				return "0";
	 			} else {
	 				User userr = user.get();
	 				LocalDateTime tokenCreationDate = userr.getDateToken();

	 				if (isTokenExpired(tokenCreationDate)) {
	 					System.out.println("Token expired.");
	 					return "1";
	 				}
 			    	userr.setPassword(password.trim());
	 				userr.setResetToken(null);
	 				userr.setDateToken(null);
	      			userService.save(userr);
	      			return "2";
	 			}
	   }
	 
	 
	 @GetMapping("/users/auth/{name}")
	 public ResponseEntity<User> login(@PathVariable String name) {
		 System.out.println(name);
	        Optional<User> user = userService.login(name);
	        return user.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                               .build());
	    }
	 
	
	 @PostMapping("/users")
	 public long createUser (@RequestParam("file") MultipartFile file,
			 @RequestParam("user") String user) throws JsonParseException , JsonMappingException , Exception
	 {
		 System.out.println("add User");
		User userr = new ObjectMapper().readValue(user, User.class);
		addUserImage(file);
	    String filename = file.getOriginalFilename();
	    String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
	    userr.setFileName(newFileName);
	    userr.setResetToken(null);
	    userr.setActive(true);
    	// BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); // Strength set as 16
	//     User.setPassword(encoder.encode(User.getPassword()));
	    userr.setMatricule("999");
	    return userService.save(userr);
	 }

	 @PutMapping("/users/{id}")
	    public void update(@PathVariable long id,@RequestParam("file") MultipartFile file,
				 @RequestParam("user") String user) throws JsonParseException , JsonMappingException , Exception {
	     User userr = new ObjectMapper().readValue(user, User.class);
	        	deleteUserImage(userr);
	        	 String filename = file.getOriginalFilename();
	     	    String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
	     	    userr.setFileName(newFileName);
	            userService.update(id, userr);
	           
	            addUserImage(file);
	       
	    }

	    @DeleteMapping("/users/{id}")
	    public void delete(@PathVariable long id) {
	        userService.delete(id);
	    }
	     
	    
	    @GetMapping(path="/ImgUsers/{id}")
		 public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
	    	 System.out.println("Get all Users Images...");
			 User User   =userService.findById(id).get();
			 return Files.readAllBytes(Paths.get(context.getRealPath("/ImgUsers/")+User.getFileName()));
		 }
	    
	    private void addUserImage(MultipartFile file)
	    {
	    	boolean isExit = new File(context.getRealPath("/ImgUsers/")).exists();
		    if (!isExit)
		    {
		    	new File (context.getRealPath("/ImgUsers/")).mkdir();
		    	System.out.println("mk dir ImgUsers.............");
		    }
		    String filename = file.getOriginalFilename();
		    String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
		    File serverFile = new File (context.getRealPath("/ImgUsers/"+File.separator+newFileName));
		    try
		    {
		    
		    	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
		    	 
		    }catch(Exception e) {
		    	 System.out.println("Failed to Add Image User !!");
		    }
		    
	    	
	    }
	    
	    private void deleteUserImage(User user)
	    {
	    	System.out.println( " Delete User Image");
	         try { 
	        	 File file = new File (context.getRealPath("/ImgUsers/"+user.getFileName()));
	             System.out.println(user.getFileName());
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
	    
	    /**
		 * Check whether the created token expired or not.
		 * 
		 * @param tokenCreationDate
		 * @return true or false
		 */
		private boolean isTokenExpired(final LocalDateTime tokenCreationDate) {

			LocalDateTime now = LocalDateTime.now();
			Duration diff = Duration.between(tokenCreationDate, now);

			return diff.toMinutes() >= EXPIRE_TOKEN_AFTER_MINUTES;
		}  
	    
}
