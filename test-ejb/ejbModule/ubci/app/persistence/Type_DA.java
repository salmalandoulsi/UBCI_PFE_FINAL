package ubci.app.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Type_DA implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String lib�l� ;
	
	
	
	
	
	
	public Type_DA() {
		super();
	}
	@Override
	public String toString() {
		return  lib�l�;
	}

	public Type_DA(int id, String lib�l�) {
		super();
		this.id = id;
		this.lib�l� = lib�l�;
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
