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


@ManagedBean(name="prestBean")
@ViewScoped
public class PrestataireBean  implements Serializable{

	
	private static final long serialVersionUID = 1L;
			
			
			@EJB
			private PrestataireServiceLocal prestService;
			
			private List<Prestataire> prestataires = new ArrayList<Prestataire>();
			private List<Prestataire> SelectedPrestataires = new ArrayList<Prestataire>();
			private List<Prestataire> filtredPrestataires = new ArrayList<Prestataire>();


			private Prestataire p = new Prestataire();
			private String référence = new String();
			
			
			public PrestataireBean() {
				super();
			}

			public PrestataireBean(Prestataire p, String référence) {
				super();
				this.p = p;
				this.référence = référence;
			}
			
			@PostConstruct
			public void init() {
				prestataires = prestService.findAllPrestataire();
			}
		

			public void doCreatePrestataire() {
				
				prestService.createPrestataire(p);
				
				p = new Prestataire();

			}
		
			public void ajoutProjet(int idProjet)
			{
				
				
			}
			
			//getter & Setters
			
			public List<Prestataire> getPrestataires() {
				return prestataires;
			}

			public Prestataire getP() {
				return p;
			}

			public void setP(Prestataire p) {
				this.p = p;
			}

			public void setPrestataires(List<Prestataire> prestataires) {
				this.prestataires = prestataires;
			}

			public List<Prestataire> getSelectedPrestataires() {
				return SelectedPrestataires;
			}

			public void setSelectedPrestataires(List<Prestataire> selectedPrestataires) {
				SelectedPrestataires = selectedPrestataires;
			}

			public List<Prestataire> getFiltredPrestataires() {
				return filtredPrestataires;
			}

			public void setFiltredPrestataires(List<Prestataire> filtredPrestataires) {
				this.filtredPrestataires = filtredPrestataires;
			}

			public String getRéférence() {
				return référence;
			}

			public void setRéférence(String référence) {
				this.référence = référence;
			}

	

}
