package ubci.app.persistence;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProjectUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProjectUserID projectUserId;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_fk", insertable = false, updatable = false)
	private User user;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "project_fk", insertable = false, updatable = false)
	private Project project;

}
