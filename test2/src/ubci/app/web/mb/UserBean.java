package ubci.app.web.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import ubci.app.business.ProjectServiceLocal;
import ubci.app.business.UserServiceLocal;
import ubci.app.persistence.Project;
import ubci.app.persistence.User;


@ManagedBean(name="userBean")
@ViewScoped
public class UserBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	
	@EJB
	private UserServiceLocal userService;
	private List<User> users = new ArrayList<User>();
	private User 		 u = new User() ;
	private String pass="";
	
	
	
	
	@PostConstruct
	public void init() {
		users = userService.findAllUser();
	}
	
	public void doCreateUser() {
		
		userService.createUser(u);
		
	}

	
	
	//getters & setters
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
