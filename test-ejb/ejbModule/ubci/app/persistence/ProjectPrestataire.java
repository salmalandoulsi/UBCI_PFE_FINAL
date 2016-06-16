package ubci.app.persistence;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProjectPrestataire implements Serializable 
{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProjectPrestataireID projectPrestataireId;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "prest_fk", insertable = false, updatable = false)
	private Prestataire prestataire;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "project_fk", insertable = false, updatable = false)
	private Project proj;

	private String r�f�rence;
	
	public ProjectPrestataire() {
		super();
	}


	public ProjectPrestataire(ProjectPrestataireID projectPrestataireId) {
		super();
		this.projectPrestataireId = projectPrestataireId;
	}


	public String getR�f�rence() {
		return r�f�rence;
	}


	public void setR�f�rence(String r�f�rence) {
		this.r�f�rence = r�f�rence;
	}

	
	
}



