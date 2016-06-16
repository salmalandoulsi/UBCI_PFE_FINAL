package ubci.app.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Enjeux implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String libélé ;
	
	
	
	
	
	public Enjeux() {
		super();
	}
	@Override
	public String toString() {
		return  libélé;
	}

	public Enjeux(int id, String libélé) {
		super();
		this.id = id;
		this.libélé = libélé;
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
