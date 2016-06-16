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
	private String lib�l� ;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name="type_ID")
	  private TypeP type;
	
	
	

	public Parametre() {
		super();
	}

	public Parametre( String lib�l�, TypeP type) {
		super();
		
		this.lib�l� = lib�l�;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLib�l�() {
		return lib�l�;
	}

	public void setLib�l�(String lib�l�) {
		this.lib�l� = lib�l�;
	}

	public TypeP getType() {
		return type;
	}

	public void setType(TypeP type) {
		this.type = type;
	}
	
	
	
	 

}
