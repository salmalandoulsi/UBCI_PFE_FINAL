package ubci.app.business;

import java.util.List;

import javax.ejb.Remote;

import ubci.app.persistence.Project;

@Remote
public interface ProjectServiceRemote {
	void createProject(Project p);
	void saveOrUpdateProject(Project p);
	Project findProjectById(String id);
	void removeProject(Project p);
	List<Project> findAllProject();

}
