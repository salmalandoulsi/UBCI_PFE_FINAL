package ubci.app.persistence;
import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class ProjectPrestataireID implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private int idPrestataire;
	private String idProject;
	
	
	public int getIdPrestataire() {
		return idPrestataire;
	}


	public void setIdPrestataire(int idPrestataire) {
		this.idPrestataire = idPrestataire;
	}


	public String getIdProject() {
		return idProject;
	}


	public void setIdProject(String idProject) {
		this.idProject = idProject;
	}


	public ProjectPrestataireID() {
		super();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPrestataire;
		result = prime * result
				+ ((idProject == null) ? 0 : idProject.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectPrestataireID other = (ProjectPrestataireID) obj;
		if (idPrestataire != other.idPrestataire)
			return false;
		if (idProject == null) {
			if (other.idProject != null)
				return false;
		} else if (!idProject.equals(other.idProject))
			return false;
		return true;
	}


	

	
	
	
	
}

