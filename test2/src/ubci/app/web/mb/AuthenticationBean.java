package ubci.app.web.mb;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import ubci.app.business.AuthenticationServiceLocal;
import ubci.app.persistence.User;

@ManagedBean(name = "authBean")
@ViewScoped
public class AuthenticationBean implements Serializable {

	@EJB
	private AuthenticationServiceLocal authentif;

	private User user = new User();
	private String login ;
	private String password;
	private String redirection = "";

	
	public AuthenticationBean() {
		super();
	}

	public String doLogin() {
		
		System.out.println("login="+login);
		System.out.println("redirection="+redirection);

		user.setLogin(login);
		user.setPassword(password);
		
		System.out.println(user.getLogin() + "," + user.getPassword());

		User fund = authentif.authenticate(user.getLogin(), user.getPassword());

		System.out.println("************");
		String navigateTo = null;

		System.out.println("comparaison");
		if (fund != null) {
			System.out.println("comparaison faite ");
			user = fund;
			navigateTo = "pages/Dashbord.xhtml?faces-redirect=true";
			System.out.println("redirection effectuée  " +fund);

		} else {
			System.out.printf("erreur");
			navigateTo = "pages/salim.xhtml?faces-redirect=true";
			System.out.println("erreur confirmer  "+fund);

		}
		return navigateTo;
	}

	
	
	//getter & Setter
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRedirection() {
		return redirection;
	}

	public void setRedirection(String redirection) {
		this.redirection = redirection;
	}

	private static final long serialVersionUID = -9040274036031665311L;

	private Date d_étude = new Date();

	public Date getD_étude() {
		return d_étude;
	}

	public void setD_étude(Date d_étude) {
		this.d_étude = d_étude;
	}

}
