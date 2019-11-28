package bodyApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bodyApp.entities.User;

public interface iUser extends JpaRepository<User, Long> {

	User findByMailAndPassword(String mail, String password);
}
