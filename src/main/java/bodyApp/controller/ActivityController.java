package bodyApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bodyApp.entities.Activity;
import bodyApp.entities.User;
import bodyApp.repositories.iActivity;
import bodyApp.repositories.iUser;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/activitys")
public class ActivityController {

	
	@Autowired
	private iUser userRepository;
	@Autowired
	private iActivity activityRepository;
	
	// renvoi la liste des activity 
	@GetMapping("/")
	public ResponseEntity findAll() {
		
		return ResponseEntity.ok(activityRepository.findAll());
		
	}
	
	@GetMapping("/all/{idUser}")
	public ResponseEntity findAllUserActivity(@PathVariable Long idUser) {
		
		if(idUser == null) {
			return ResponseEntity.badRequest().body("champ vide user null");
		}
		User user = userRepository.getOne(idUser);
		if(user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(activityRepository.findByUser(user));
	}
	
	
	//renvoi une activity  par son id
		@GetMapping("/{idActivity}")
		public ResponseEntity findActivityById(@PathVariable(name = "idActivity") Long idActivity) {
			
			if(idActivity == null) {
				return ResponseEntity.badRequest().body("impossible de trouver l'activity avec un id null");
			}
			
			Activity activity = activityRepository.getOne(idActivity);
			
			if(activity == null) {
				ResponseEntity.notFound().build();
			}
			
			return ResponseEntity.ok().body(activity);
		}
		
		
		// creer une activity
		
		@PostMapping("/")
		public ResponseEntity createActivity(@RequestBody Activity activity) {
			
			if(activity == null) {
				return ResponseEntity.badRequest().body("impossible de creer le programme");
			}
			
			Activity createActivity = activityRepository.save(activity);
			return ResponseEntity.ok(createActivity);
		}
		
		// supprimer un programme
		@DeleteMapping("/{idActivity}")
		public ResponseEntity deletActivity(@PathVariable(name="idActivity") Long idActivity) {
			
			if(idActivity == null) {
				ResponseEntity.badRequest().body("impossible de supprimer le programme");
			}
			
			Activity activity = activityRepository.getOne(idActivity);
			if(activity == null) {
				ResponseEntity.notFound().build();
			}
			activityRepository.delete(activity);
			return ResponseEntity.ok("programme supprimer");
		}
		
	
		
}
