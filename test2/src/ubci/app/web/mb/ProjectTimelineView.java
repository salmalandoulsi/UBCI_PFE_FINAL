package ubci.app.web.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ubci.app.business.AttributsProjetServiceLocal;
import ubci.app.business.PrestataireServiceLocal;
import ubci.app.business.ProjectServiceLocal;
import ubci.app.business.UserServiceLocal;
import ubci.app.persistence.Project;
import ubci.app.persistence.User;

@ManagedBean(name="timelineP")
@ViewScoped
public class ProjectTimelineView implements Serializable{
	
	
	

	private static final long serialVersionUID = -9046215104266175386L;

	@EJB
	private ProjectServiceLocal projService;
	@EJB
	private UserServiceLocal userService;
	@EJB
	private AttributsProjetServiceLocal attributService;
	@EJB
	private PrestataireServiceLocal prestService;
	
	private List<Project> projects = new ArrayList<Project>();
	
	private List<User> users = new ArrayList<User>();
	
	private Project p = new Project();
	
	
	
	
	
	@PostConstruct
	public void init() {
		
		projects = projService.findAllProject();
		users=userService.findAllUser();
		
	}








	
	//getters & Setters 

	public List<User> getUsers() {
		return users;
	}





	public void setUsers(List<User> users) {
		this.users = users;
	}

	
	public List<Project> getProjects() {
		return projects;
	}





	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}









	public Project getP() {
		return p;
	}









	public void setP(Project p) {
		this.p = p;
	}


	
	
}
