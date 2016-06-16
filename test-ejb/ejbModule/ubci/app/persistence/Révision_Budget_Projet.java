package ubci.app.persistence;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ubci.app.persistence.Charge_Budget;
import ubci.app.persistence.Prestataire;
import ubci.app.persistence.Project;
import ubci.app.persistence.ProjectPrestataire;
import ubci.app.persistence.Revision_Budget_Prestataire;

@Entity
public class Révision_Budget_Projet implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	
	private float budget_initial;
	
	private float budget_final;
	
	private float macroChiffrage;
	
	@OneToOne(fetch = FetchType.LAZY)
	
	private Project projet;
	
	@OneToMany(mappedBy="révision_projet",cascade=CascadeType.PERSIST)
	private List<Revision_Budget_Prestataire> revisionPrestataire;
	
	

	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_validation;





	public Révision_Budget_Projet() {
		super();
	}



// getters & Setters

	public String getId() {
		return id;
	}





	public void setId(String id) {
		this.id = id;
	}





	public float getBudget_initial() {
		return budget_initial;
	}





	public void setBudget_initial(float budget_initial) {
		this.budget_initial = budget_initial;
	}





	public float getBudget_final() {
		return budget_final;
	}





	public void setBudget_final(float budget_final) {
		this.budget_final = budget_final;
	}





	public float getMacroChiffrage() {
		return macroChiffrage;
	}





	public void setMacroChiffrage(float macroChiffrage) {
		this.macroChiffrage = macroChiffrage;
	}





	public Project getProjet() {
		return projet;
	}





	public void setProjet(Project projet) {
		this.projet = projet;
	}





	public List<Revision_Budget_Prestataire> getRevisionPrestataire() {
		return revisionPrestataire;
	}





	public void setRevisionPrestataire(
			List<Revision_Budget_Prestataire> revisionPrestataire) {
		this.revisionPrestataire = revisionPrestataire;
	}





	public Date getDate_validation() {
		return date_validation;
	}





	public void setDate_validation(Date date_validation) {
		this.date_validation = date_validation;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
