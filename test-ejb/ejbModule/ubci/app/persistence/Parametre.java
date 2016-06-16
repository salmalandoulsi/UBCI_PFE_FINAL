package ubci.app.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Parametre implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String libélé ;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name="type_ID")
	  private TypeP type;
	
	
	

	public Parametre() {
		super();
	}

	public Parametre( String libélé, TypeP type) {
		super();
		
		this.libélé = libélé;
		this.type = type;
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

	public TypeP getType() {
		return type;
	}

	public void setType(TypeP type) {
		this.type = type;
	}
	
	
	
	 

}
