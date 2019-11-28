package bodyApp.entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Comment")
public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long idComment;
	private String commentaire;
	private Time datePost;
	
	@OneToMany(mappedBy = "comment")
    private List<Activity> activityComment;
    
	@OneToMany(mappedBy = "idUser")
	private List<User> userComment;
	
	
	public Long getId() {
		return idComment;
	}
	public void setId(Long idComment) {
		this.idComment = idComment;
	}
	@JsonIgnore
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Time getDatePost() {
		return datePost;
	}
	public void setDatePost(Time datePost) {
		this.datePost = datePost;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
