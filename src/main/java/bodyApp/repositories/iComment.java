package bodyApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bodyApp.entities.Comment;

public interface iComment extends JpaRepository<Comment, Long> {

}
