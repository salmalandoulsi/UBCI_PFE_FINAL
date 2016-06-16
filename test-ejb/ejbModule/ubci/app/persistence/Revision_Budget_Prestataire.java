package ubci.app.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Revision_Budget_Prestataire implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private Charge_Budget charge;
	
	private int id_prestataire;
	
//	private Prestataire prestataire;
	
	private String motif;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_r�vision;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "revisionPrestataire_fk", insertable = false, updatable = false)
	private  R�vision_Budget_Projet r�vision_projet;
	
	
	
	
	
	
	
	

	public Revision_Budget_Prestataire() {
		super();
	}

	
	
	//getter & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Charge_Budget getCharge() {
		return charge;
	}

	public void setCharge(Charge_Budget charge) {
		this.charge = charge;
	}

//	public Prestataire getPrestataire() {
//		return prestataire;
//	}
//
//	public void setPrestataire(Prestataire prestataire) {
//		this.prestataire = prestataire;
//	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Date getDate_r�vision() {
		return date_r�vision;
	}

	public void setDate_r�vision(Date date_r�vision) {
		this.date_r�vision = date_r�vision;
	}



	public R�vision_Budget_Projet getR�vision_projet() {
		return r�vision_projet;
	}



	public void setR�vision_projet(R�vision_Budget_Projet r�vision_projet) {
		this.r�vision_projet = r�vision_projet;
	}



	public int getId_prestataire() {
		return id_prestataire;
	}



	public void setId_prestataire(int id_prestataire) {
		this.id_prestataire = id_prestataire;
	}
	
	
	
	

}
