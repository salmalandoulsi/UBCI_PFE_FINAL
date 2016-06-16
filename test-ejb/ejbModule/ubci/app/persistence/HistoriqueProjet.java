package ubci.app.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class HistoriqueProjet implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id 
	private String id;
	
	private  String  Hdescription;
	
	private String date; 
	private int idUser; 
	
	
	
	

	public HistoriqueProjet() {
		super();
	}

	

	
	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getHdescription() {
		return Hdescription;
	}

	public void setHdescription(String hdescription) {
		Hdescription = hdescription;
	}

	

	public String getDate() {
		return date;
	}




	public void setDate(String date) {
		this.date = date;
	}




	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	
	
	
	

}
