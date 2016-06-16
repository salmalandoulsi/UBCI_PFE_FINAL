package ubci.app.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Charge_Budget implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int idCharge;
	
	private int jh;
	private float tnd;
	
	
	
	public Charge_Budget() {
		super();
	}
	
	public int getIdCharge() {
		return idCharge;
	}

	public void setIdCharge(int idCharge) {
		this.idCharge = idCharge;
	}

	public int getJh() {
		return jh;
	}
	public void setJh(int jh) {
		this.jh = jh;
	}
	public float getTnd() {
		return tnd;
	}
	public void setTnd(float tnd) {
		this.tnd = tnd;
	}
	
	
}
