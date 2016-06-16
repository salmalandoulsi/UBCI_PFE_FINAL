package ubci.app.web.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ubci.app.business.AttributsProjetServiceLocal;
import ubci.app.business.ProjectServiceLocal;
import ubci.app.persistence.Project;

@ManagedBean(name = "")
@ViewScoped
public class ConsultationDemandeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ProjectServiceLocal projService;
	@EJB
	private AttributsProjetServiceLocal attributService;

	private Project p = new Project();
	ModificationProjetBean modif= new ModificationProjetBean();


	@PostConstruct
	public void init() {
		p = new Project();
		//projects = projService.findAllProject();
	}
}
