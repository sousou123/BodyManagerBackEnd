package bodyApp.entities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Builder
public class User implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    private Long idUser;

    private String firstName;

    private String lastName;

    private String mail;
  

	private Integer age;
    
    private Boolean coach;
    
    private Boolean admin;

    private String password;

    @Lob
    private byte[] photo;

    @OneToMany(mappedBy = "user")
    private List<Activity> activity;
    
    @OneToMany(mappedBy = "user")
    private List<CoachCertification> certification;
    
    @OneToMany
    @JoinColumn(name= "idComment")
    private List<Comment>userComment;
   
   
    
    public User() {
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
    
    public Boolean getCoach() {
        return coach;
    }

    public void setCoach(Boolean coach) {
        this.coach = coach;
    }
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @JsonIgnore
    public List<Activity> getActivity() {
        return activity;
    }

    public void setActivity(List<Activity>activity) {
        this.activity = activity;
    }


   
}
