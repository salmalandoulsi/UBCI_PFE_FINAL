package ubci.app.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_user")
public class User implements Serializable{
	
	private static final long serialVersionUID = -1014505330615266768L;
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int idUser;
	@Column(unique = true)
	
	private String login;
	

	private String password;
	private String email;
	private String photo; 
	private String nom;
	private String prenom;
	private String role;
	private String sexe; 
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_naissance; 
	
	@OneToMany(mappedBy="user",cascade=CascadeType.PERSIST)
	private List<ProjectUser> projectUser;

	
	
	public User() {
	}

	public User(String login, String password, String email) {
		this.login = login;
		this.password = password;
		this.email = email;
	}

	
	
	
	
	
	
	
	@Override
	public String toString() {
		return  nom + " " + prenom ;
	}
	//getters and setters 
	public String getPhoto() {
		return photo;
	}

	public List<ProjectUser> getProjectUser() {
		return projectUser;
	}

	public void setProjectUser(List<ProjectUser> projectUser) {
		this.projectUser = projectUser;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return idUser;
	}

	public void setId(int id) {
		this.idUser = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	

}
