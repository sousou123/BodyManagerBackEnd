package bodyApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bodyApp.entities.Activity;
import bodyApp.entities.User;

public interface iActivity extends JpaRepository<Activity, Long> {

	List<Activity> findByUser(User user);
	
}
