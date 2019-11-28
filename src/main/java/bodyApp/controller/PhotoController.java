package bodyApp.controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bodyApp.entities.Activity;
import bodyApp.entities.User;
import bodyApp.repositories.iActivity;
import bodyApp.repositories.iUser;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/photos")
public class PhotoController {

	
	 	@Autowired
	 	private iActivity activityRepository;
	    @Autowired
	    private iUser userRepository;

	    @GetMapping("/activity/{idActivity}")
	    public ResponseEntity photoActivity(@PathVariable Long idActivity) {
	        if (idActivity == null) {
	            return ResponseEntity.badRequest().body("Cannot get activity photo with null ID");
	        }
	        Activity activity = activityRepository.getOne(idActivity);
	        if (activity == null) {
	            return ResponseEntity.notFound().build();
	        }
	        if (activity.getPhoto() == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok()
	                .contentType(MediaType.IMAGE_GIF)
	                .contentType(MediaType.IMAGE_JPEG)
	                .contentType(MediaType.IMAGE_PNG)
	                .body(new InputStreamResource(new ByteArrayInputStream(activity.getPhoto())));
	    }

	    @GetMapping("/user/{idUser}")
	    public ResponseEntity photoUser(@PathVariable Long idUser) {
	        if (idUser == null) {
	            return ResponseEntity.badRequest().body("Cannot get user photo with null ID");
	        }
	        User user = userRepository.getOne(idUser);
	        if (user == null) {
	            return ResponseEntity.notFound().build();
	        }
	        if (user.getPhoto() == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok()
	                .contentType(MediaType.IMAGE_GIF)
	                .contentType(MediaType.IMAGE_JPEG)
	                .contentType(MediaType.IMAGE_PNG)
	                .body(new InputStreamResource(new ByteArrayInputStream(user.getPhoto())));
	    }
}
