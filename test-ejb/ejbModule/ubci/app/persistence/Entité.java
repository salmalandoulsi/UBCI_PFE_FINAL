package ubci.app.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Entit�  implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String lib�l� ;
	public Entit�() {
		super();
	}
	

	@Override
	public String toString() {
		return  lib�l�;
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
	
	
}
