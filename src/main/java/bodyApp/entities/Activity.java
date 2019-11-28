package bodyApp.entities;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Entity
public class Activity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    private Long idActivity;
	
	private String durationActivity;

    private String contentActivity;
    
    private String describtionActivity;

    private Double price;

    @Lob
    private byte[] photo;
    
    @Transient
    private Long idOwner;


    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;
    
    @OneToMany
    @JoinColumn(name= "idComment")
    private List<Comment>comment;
    
    
    @ElementCollection(targetClass = Category.class)
    @JoinTable(name = "Activity", joinColumns = @JoinColumn(name = "idActivity"))
    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    Collection<Category> category;
    
    
    public Activity() {
    	
    }

    public Long getIdActivity() {
		return idActivity;
	}


	public void setIdActivity(Long idActivity) {
		this.idActivity = idActivity;
	}


	public String getDurationActivity() {
		return durationActivity;
	}


	public void setDurationActivity(String durationActivity) {
		this.durationActivity = durationActivity;
	}


	public String getContentActivity() {
		return contentActivity;
	}


	public void setContentActivity(String contentActivity) {
		this.contentActivity = contentActivity;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public byte[] getPhoto() {
		return photo;
	}
	

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@JsonIgnore
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public List<Comment> getComment() {
		return comment;
	}


	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}


	public Collection<Category> getCategory() {
		return category;
	}


	public void setCategory(Collection<Category> category) {
		this.category = category;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	 public Long getIdOwner() {
	        return idOwner;
	    }

	    public void setIdOwner(Long idOwner) {
	        this.idOwner = idOwner;
	    }

		public String getDescribtionActivity() {
			return describtionActivity;
		}

		public void setDescribtionActivity(String describtionActivity) {
			this.describtionActivity = describtionActivity;
		}




    
}
