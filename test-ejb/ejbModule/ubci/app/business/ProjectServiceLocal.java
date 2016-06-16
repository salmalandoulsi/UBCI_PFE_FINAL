package ubci.app.business;

import java.util.List;

import javax.ejb.Local;

import ubci.app.persistence.Enjeux;
import ubci.app.persistence.Project;


@Local
public interface ProjectServiceLocal {
	
	void createProject(Project p);
	void saveOrUpdateProject(Project p);
	Project findProjectById(String id);
	void removeProject(Project p);
	List<Project> findAllProject();
    void createProjetPrestataire(String idproject, int idprestataire, String référence);

}
