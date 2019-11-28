package bodyApp.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;





@Entity
@Table(name="Certification")
public class CoachCertification implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue
	private Long id;
	private String nemeCertification,dateGiv,cityGiv,domaine;
	
	@ManyToOne
	@JoinColumn(name = "idUser")
	private User user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNemeCertification() {
		return nemeCertification;
	}
	public void setNemeCertification(String nemeCertification) {
		this.nemeCertification = nemeCertification;
	}
	public String getDateGiv() {
		return dateGiv;
	}
	public void setDateGiv(String dateGiv) {
		this.dateGiv = dateGiv;
	}
	public String getCityGiv() {
		return cityGiv;
	}
	public void setCityGiv(String cityGiv) {
		this.cityGiv = cityGiv;
	}
	public String getDomaine() {
		return domaine;
	}
	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
