package bodyApp.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bodyApp.entities.Activity;
import bodyApp.entities.Category;
import bodyApp.entities.User;

public interface iActivity extends JpaRepository<Activity, Long> {

		

	    List<Activity> findByUser(User user);
	    
	    //Activity findByCategoryType(Category category);
	    
	    

	   
}
