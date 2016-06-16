package ubci.app.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class TypeP implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String libélé ;
	  @OneToMany(mappedBy="type")
	  private List<Parametre> parametres;
	  
	
	
	public TypeP() {
		super();
	}


	
	public TypeP(String libélé) {
		super();
		this.libélé = libélé;
	}



	@Override
	public String toString() {
		return  libélé;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLibélé() {
		return libélé;
	}


	public void setLibélé(String libélé) {
		this.libélé = libélé;
	}
	
	
	
	

}
