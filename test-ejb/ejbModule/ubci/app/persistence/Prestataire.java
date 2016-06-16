package ubci.app.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Prestataire implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String nom ;
	private String adresse;
	private int charge_JH;
	private float charge_TND;
	@OneToMany(mappedBy="prestataire",cascade=CascadeType.PERSIST)
	private List<ProjectPrestataire> projectPrestataire;
	
	
	public Prestataire() {
		super();
	}
	
	
	public int getCharge_JH() {
		return charge_JH;
	}


	public void setCharge_JH(int charge_JH) {
		this.charge_JH = charge_JH;
	}


	public float getCharge_TND() {
		return charge_TND;
	}


	public void setCharge_TND(float charge_TND) {
		this.charge_TND = charge_TND;
	}


	public List<ProjectPrestataire> getProjectPrestataire() {
		return projectPrestataire;
	}


	public void setProjectPrestataire(List<ProjectPrestataire> projectPrestataire) {
		this.projectPrestataire = projectPrestataire;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	
	
	
	
	
}
