package ubci.app.web.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ubci.app.business.PrestataireServiceLocal;
import ubci.app.persistence.Prestataire;
import ubci.app.persistence.Project;
import ubci.app.persistence.ProjectPrestataire;

@ManagedBean(name="presP")
@ViewScoped
public class PrestataireProjetBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
			
			
			@EJB
			private PrestataireServiceLocal prestService;
			
			private List<Prestataire> prestataires = new ArrayList<Prestataire>();
			private List<Prestataire> SelectedPrestataires = new ArrayList<Prestataire>();
			private List<Prestataire> filtredPrestataires = new ArrayList<Prestataire>();


			private Prestataire pres = new Prestataire();
			private Project projet= new Project();
			private ProjectPrestataire pp = new ProjectPrestataire();
			
			
			
			@PostConstruct
			public void init() {
				prestataires = prestService.findAllPrestataire();
			}
			
			
			
			

}
