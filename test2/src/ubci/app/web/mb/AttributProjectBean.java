package ubci.app.web.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;



import ubci.app.business.AttributsProjetService;
import ubci.app.business.AttributsProjetServiceLocal;
import ubci.app.persistence.Application;
import ubci.app.persistence.Enjeux;
import ubci.app.persistence.Entité;
import ubci.app.persistence.Priorité;
import ubci.app.persistence.Reliquat;
import ubci.app.persistence.Statut;
import ubci.app.persistence.Type_DA;

@ManagedBean(name = "athProjB")
@ViewScoped
public class AttributProjectBean implements Serializable {

	@EJB
	private AttributsProjetServiceLocal auth;

	private static final long serialVersionUID = -9040274036031665311L;

	private List<Enjeux> enj = new ArrayList<Enjeux>();
	private List<Priorité> priorités = new ArrayList<Priorité>();
	private List<Statut> status = new ArrayList<Statut>();
	private List<Type_DA> das = new ArrayList<Type_DA>();
	private List<Reliquat> reliquats = new ArrayList<Reliquat>();
	private List<Entité> entites = new ArrayList<Entité>();
	private List<Application> applications = new ArrayList<Application>();

	


	private Enjeux e = new Enjeux();
	private Priorité p = new Priorité();
	private Statut s = new Statut();
	private Type_DA da = new Type_DA();
	private Reliquat r= new Reliquat();
	private Entité enité = new Entité();
	private Application app = new Application();

	private Date d_étude;
	private String libEnjeux= new String();

	private String lib= new String();
	private String libStatut= new String();
	private String libReliquat= new String();
	private String libPriorité= new String();
	private String libType_DA= new String();


	
	  
	  private List<Enjeux> filteredEnjeux;
	
	public AttributProjectBean() {
		super();
	}

	@PostConstruct
	public void init() {
		
	System.out.println("init *** start");
	entites=auth.findAllEntité();
	applications= auth.findAllApplication();
		enj = auth.findAllEnjeux();
		priorités = auth.findAllPriorité();
		status = auth.findAllStatut();
		das = auth.findAllType_DA();
		reliquats=auth.findAllReliquat();
		System.out.println("init *** end");
		

	}

	public List<Entité> getEntites() {
		return entites;
	}

	public void setEntites(List<Entité> entites) {
		this.entites = entites;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public Entité getEnité() {
		return enité;
	}

	public void setEnité(Entité enité) {
		this.enité = enité;
	}

	public Application getApp() {
		return app;
	}

	public void setApp(Application app) {
		this.app = app;
	}

	// CRUD Enjeux
	public String doCreateEnjeux1() {
		
      
		String navigateTo =null;
		 navigateTo = "parametre.xhtml?faces-redirect=true";
		 System.out.println("redirection effectuée  " );
		

		auth.createEnjeux(e);
		System.out.println("création");
		 return navigateTo;
	}
	public void doCreateEnjeux() {
		System.out.println("début création");

       e.setLibélé(libEnjeux);
		System.out.println("libélnjeuxé :"+libEnjeux);
		

		auth.createEnjeux(e);
		System.out.println("création");
		
	}

	public void doUpdateEnjeux(Enjeux e) {
		auth.saveOrUpdateEnjeux(e);
	}

	public void doRemoveEnjeux(Enjeux e) {
		auth.removeEnjeux(e);
	}

	public void doFindAllEnjeux() {
		auth.findAllEnjeux();
	}

	// CRUD Reliquat
	public void doCreateReliquat() {
     r.setLibélé(libReliquat);
		auth.createReliquat(r);
		r = new Reliquat();
	}

	public void doUpdateReliquat(Reliquat r) {
		auth.saveOrUpdateReliquat(r);
		;
	}

	public void doRemoveReliquat(Reliquat r) {
		auth.removeReliquat(r);
	}

	public void doFindAllReliquat() {
		auth.findAllReliquat();
	}
	// CRUD Priorité
		public void doCreatePriorité() {
           p.setLibélé(libPriorité);
			auth.createPriorité(p);
			p = new Priorité();
		}

		public void doUpdatePriorité(Priorité p) {
			auth.saveOrUpdatePriorité(p);
			;
		}

		public void doRemovePriorité(Priorité p) {
			auth.removePriorité(p);
		}

		public void doFindAllPriorité() {
			auth.findAllPriorité();
		}

	// CRUD Statut
	public void doCreateStatut() {
        s.setLibélé(libStatut);
		auth.createStatut(s);
		s = new Statut();
	}

	public void doUpdateStatut(Statut s) {
		auth.saveOrUpdateStatut(s);
	}

	public void doRemoveStatut(Statut s) {
		auth.removeStatut(s);
	}

	public void doFindAllStatut() {
		auth.findAllStatut();
	}

	// CRUD Type_DA
	public void doCreateType_DA() {
        da.setLibélé(libType_DA);
		auth.createType_DA(da);
		da = new Type_DA();
	}

	public void doUpdateType_DA(Type_DA da) {
		auth.saveOrUpdateType_DA(da);
	}

	public void doRemoveType_DA(Type_DA da) {
		auth.removeType_DA(da);
	}

	public void doFindAllType_DA() {
		auth.findAllType_DA();
	}

	// getters+Setters
	
	
	
	public AttributsProjetServiceLocal getAuth() {
		return auth;
	}



	public String getLibType_DA() {
		return libType_DA;
	}

	public void setLibType_DA(String libType_DA) {
		this.libType_DA = libType_DA;
	}

	public String getLibEnjeux() {
		return libEnjeux;
	}

	public void setLibEnjeux(String libEnjeux) {
		this.libEnjeux = libEnjeux;
	}

	public String getLibStatut() {
		return libStatut;
	}

	public void setLibStatut(String libStatut) {
		this.libStatut = libStatut;
	}

	public String getLibReliquat() {
		return libReliquat;
	}

	public void setLibReliquat(String libReliquat) {
		this.libReliquat = libReliquat;
	}

	public String getLibPriorité() {
		return libPriorité;
	}

	public void setLibPriorité(String libPriorité) {
		this.libPriorité = libPriorité;
	}

	public void setAuth(AttributsProjetServiceLocal auth) {
		this.auth = auth;
	}

	 	
	public String getLib() {
		return lib;
	}

	public void setLib(String lib) {
		this.lib = lib;
	}

	public Enjeux getE() {
		return e;
	}

	public void setE(Enjeux e) {
		this.e = e;
	}

	public Priorité getP() {
		return p;
	}

	public void setP(Priorité p) {
		this.p = p;
	}

	public Statut getS() {
		return s;
	}

	public void setS(Statut s) {
		this.s = s;
	}

	public Type_DA getDa() {
		return da;
	}

	public void setDa(Type_DA da) {
		this.da = da;
	}

	public List<Enjeux> getEnj() {
		return enj;
	}

	public void setEnj(List<Enjeux> enj) {
		this.enj = enj;
	}

	public List<Priorité> getPriorités() {
		return priorités;
	}

	public void setPriorités(List<Priorité> priorités) {
		this.priorités = priorités;
	}

	public List<Statut> getStatus() {
		return status;
	}

	public void setStatus(List<Statut> status) {
		this.status = status;
	}

	public List<Type_DA> getDas() {
		return das;
	}

	public void setDas(List<Type_DA> das) {
		this.das = das;
	}

	
	
	public List<Reliquat> getReliquats() {
		return reliquats;
	}

	public void setReliquats(List<Reliquat> reliquats) {
		this.reliquats = reliquats;
	}

	public Reliquat getR() {
		return r;
	}

	public void setR(Reliquat r) {
		this.r = r;
	}

	public Date getD_étude() {
		return d_étude;
	}

	public void setD_étude(Date d_étude) {
		this.d_étude = d_étude;
	}

	public List<Enjeux> getFilteredEnjeux() {
		return filteredEnjeux;
	}

	public List<Enjeux> getFilteredENjeux() {
		return filteredEnjeux;
	}

	public void setFilteredEnjeux(List<Enjeux> filteredEnjeux) {
		this.filteredEnjeux = filteredEnjeux;
	}

	
	 
	
	
	
	     
	
	    
}
