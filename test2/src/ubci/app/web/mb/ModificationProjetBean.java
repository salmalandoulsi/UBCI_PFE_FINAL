package ubci.app.web.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import ubci.app.business.AttributsProjetServiceLocal;
import ubci.app.business.AuthenticationServiceLocal;
import ubci.app.business.PrestataireServiceLocal;
import ubci.app.business.ProjectServiceLocal;
import ubci.app.business.UserServiceLocal;
import ubci.app.persistence.Application;
import ubci.app.persistence.Enjeux;
import ubci.app.persistence.Entité;
import ubci.app.persistence.Prestataire;
import ubci.app.persistence.Priorité;
import ubci.app.persistence.Project;
import ubci.app.persistence.Reliquat;
import ubci.app.persistence.Statut;
import ubci.app.persistence.Type_DA;
import ubci.app.persistence.User;

@ManagedBean(name = "Modifprojet")
@ViewScoped
public class ModificationProjetBean implements Serializable {

	@EJB
	private AuthenticationServiceLocal authentif;
	@EJB
	private UserServiceLocal userService;
	@EJB
	private ProjectServiceLocal projService;
	@EJB
	private AttributsProjetServiceLocal attributService;
	@EJB
	private PrestataireServiceLocal prestService;

	public boolean inuput_recherche;
	public boolean button_recherche;
	public String id;
	public String userName;
	public String userLastName;
	public String loginChef;
	public String loginSponsor;
	public String loginMOA;
	public String entité;
	public String app;
	public String macrochiffrage;

	private List<Integer> prest = new ArrayList<Integer>();

	private String panel1 = "close()";
	public String en, en2, en3, en4, en5;

	private List<Project> projects = new ArrayList<Project>();
	private List<User> users = new ArrayList<User>();
	private List<Enjeux> enjeux = new ArrayList<Enjeux>();
	private List<Priorité> priorité = new ArrayList<Priorité>();
	private List<Statut> statut = new ArrayList<Statut>();
	private List<Reliquat> reliquat = new ArrayList<Reliquat>();
	private List<Type_DA> type_da = new ArrayList<Type_DA>();
	private List<Prestataire> prestataires = new ArrayList<Prestataire>();
	private List<Entité> entites = new ArrayList<Entité>();
	private List<Application> applications = new ArrayList<Application>();

	private List<Prestataire> SelectedPrestataires = new ArrayList<Prestataire>();
	private List<SelectItem> usersSelect = new ArrayList<SelectItem>();
	private List<SelectItem> enjeuxSelect = new ArrayList<SelectItem>();
	private List<SelectItem> prioritéSelect = new ArrayList<SelectItem>();
	private List<SelectItem> statutSelect = new ArrayList<SelectItem>();
	private List<SelectItem> reliquatSelect = new ArrayList<SelectItem>();
	private List<SelectItem> typeDASelect = new ArrayList<SelectItem>();
	private List<SelectItem> applicationSelect = new ArrayList<SelectItem>();
	private List<SelectItem> entiteSelect = new ArrayList<SelectItem>();

	private String libélé = "";
	private String descriptionProjet = "";

	private static final long serialVersionUID = -9040274036031665311L;

	private String lancerMetier = "";
	private String lc = "";
	private float budget_int = 0;
	private float budget_supp = 0;
	private float budget_rev = 0;
	private int charge_prev = 0;
	private int charge_supp = 0;
	private int charge_Total = 0;
	private boolean display = false;

	private Project p;

	@PostConstruct
	public void init() {
		inuput_recherche= false;
		 button_recherche=false;
		 
		

		entites = attributService.findAllEntité();
		applications = attributService.findAllApplication();
		// projects = projService.findAllProject();
		users = userService.findAllUser();
		enjeux = attributService.findAllEnjeux();
		priorité = attributService.findAllPriorité();
		statut = attributService.findAllStatut();
		reliquat = attributService.findAllReliquat();
		type_da = attributService.findAllType_DA();
		prestataires = prestService.findAllPrestataire();

	}

	public String NewDemande()
	{
		 System.out.println("*******" );	
		String navigateTo =null;
		 navigateTo = "creationProjet2.xhtml?faces-redirect=true";
		 System.out.println("redirection effectuée  " );
		 return navigateTo;
	}
	public String Consultation()
	{
		 System.out.println("*******Consultation" );	
		String navigateTo =null;
		 navigateTo = "Consultation.xhtml?faces-redirect=true";
		 System.out.println("redirection Consultation " );
		 return navigateTo;
	}
	public void RechercheProjetBYRéférence(ActionEvent actionEvent) {
		inuput_recherche=true;
		 button_recherche= true;
		System.out.println("recherche *******");
		p=new Project();
		addMessage("Welcome to Primefaces!!");
		System.out.println("recherche *******");
		try {

			System.out.println("id=" + id);
			p = projService.findProjectById(id);

			libélé = p.getLibélé();
			System.out.println("libélé=" + libélé);
			loginChef = userService.findUserById(p.getChefP()).getLogin();
			System.out.println("loginChef=" + loginChef);

			loginSponsor = userService.findUserById(p.getSpons()).getLogin();
			loginMOA = userService.findUserById(p.getMOA()).getLogin();
			entité = attributService.findEntitéById(p.getEntite()).getLibélé();
			app = attributService.findApplicationById(p.getApp()).getLibélé();
			macrochiffrage = p.getMacrochiffrage();
			panel1 = "show()";
		} catch (Exception ex) {

			libélé = "erreur";
			System.out.println("erreurrrrr");
		}
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}


	public void RechercheProjetBYRéférence() {
		inuput_recherche=true;
		 button_recherche= true;
		 p=new Project();
		
			
		System.out.println("recherche  BY réfférence  *******");
		try {

			System.out.println("id=" + id);
			p = projService.findProjectById(id);
			System.out.println("p.id =" + p.getId());
			System.out.println("p.libélé=" + p.getLibélé());
			libélé = p.getLibélé();

			System.out.println("libélé=" + libélé);
			macrochiffrage = p.getMacrochiffrage();
			descriptionProjet = p.getDescription();
			
			budget_int = p.getBudget_int();
			budget_supp = p.getBudget_supp();
			budget_rev = p.getBudget_rev();
			charge_prev = p.getCharge_prev();
			charge_supp = p.getCharge_supp();
			charge_Total = p.getCharge_Total();
			
			try {
				lancerMetier = p.getLancerMetier();
				} catch (Exception ex) {
					lancerMetier = "Select Lancer Métier";
				}
				try{
				lc = p.getLC();
			} catch (Exception ex) {
				lc = "Select Local/Central";
			}
			try {
				loginChef = userService.findUserById(p.getChefP()).getLogin();
				System.out.println("loginChef=" + loginChef);
			} catch (Exception ex) {
				loginChef = "Select MOA";
			}
			try {
				loginSponsor = userService.findUserById(p.getSpons())
						.getLogin();
			} catch (Exception ex) {
				loginSponsor = "Select Sponsor";
			}
			try {
				loginMOA = userService.findUserById(p.getMOA()).getLogin();
			} catch (Exception ex) {
				loginSponsor = "Select Sponsor";
			}
			try {
				entité = attributService.findEntitéById(p.getEntite())
						.getLibélé();
			} catch (Exception ex) {
				entité = "Select entité";
			}
			try {
				app = attributService.findApplicationById(p.getApp())
						.getLibélé();
			} catch (Exception ex) {
				app = "Select Application";
			}

			try {
				en = attributService.findEnjeuxById(p.getEnjeux()).getLibélé();
			} catch (Exception ex) {
				en = "Select Enjeux";
			}
			try {
				en2 = attributService.findPrioritéById(p.getPriorité())
						.getLibélé();
			} catch (Exception ex) {
				en2 = "Select Priorité";
			}

			try {
				en3 = attributService.findReliquatById(p.getReliquat())
						.getLibélé();
			} catch (Exception ex) {
				en3 = "Select Reliquat";
			}
			try {
				en4 = attributService.findStatutById(p.getStatut()).getLibélé();
			} catch (Exception ex) {
				en4 = "Select Statut";
			}

			try {
				en5 = attributService.findType_DAById(p.getTypeDA())
						.getLibélé();
			} catch (Exception ex) {
				en5 = "Select Type Demande";
			}
			
			

		} catch (Exception ex) {

			libélé = "erreur";
			System.out.println("erreurrrrr");
			
				
		}

	}

	public void doModifiProject() {

		p.setLibélé(libélé);
		projService.saveOrUpdateProject(p);
		System.out.println("update done ");
	}

	// getters & Setters

	public AuthenticationServiceLocal getAuthentif() {
		return authentif;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setAuthentif(AuthenticationServiceLocal authentif) {
		this.authentif = authentif;
	}

	public UserServiceLocal getUserService() {
		return userService;
	}

	public void setUserService(UserServiceLocal userService) {
		this.userService = userService;
	}

	public ProjectServiceLocal getProjService() {
		return projService;
	}

	public void setProjService(ProjectServiceLocal projService) {
		this.projService = projService;
	}

	public AttributsProjetServiceLocal getAttributService() {
		return attributService;
	}

	public void setAttributService(AttributsProjetServiceLocal attributService) {
		this.attributService = attributService;
	}

	public PrestataireServiceLocal getPrestService() {
		return prestService;
	}

	public void setPrestService(PrestataireServiceLocal prestService) {
		this.prestService = prestService;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getLoginChef() {
		return loginChef;
	}

	public void setLoginChef(String loginChef) {
		this.loginChef = loginChef;
	}

	public String getLoginSponsor() {
		return loginSponsor;
	}

	public void setLoginSponsor(String loginSponsor) {
		this.loginSponsor = loginSponsor;
	}

	public String getLoginMOA() {
		return loginMOA;
	}

	public void setLoginMOA(String loginMOA) {
		this.loginMOA = loginMOA;
	}

	public String getEntité() {
		return entité;
	}

	public void setEntité(String entité) {
		this.entité = entité;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getMacrochiffrage() {
		return macrochiffrage;
	}

	public void setMacrochiffrage(String macrochiffrage) {
		this.macrochiffrage = macrochiffrage;
	}

	public List<Integer> getPrest() {
		return prest;
	}

	public void setPrest(List<Integer> prest) {
		this.prest = prest;
	}

	public String getEn() {
		return en;
	}

	public void setEn(String en) {
		this.en = en;
	}

	public String getEn2() {
		return en2;
	}

	public void setEn2(String en2) {
		this.en2 = en2;
	}

	public String getEn3() {
		return en3;
	}

	public void setEn3(String en3) {
		this.en3 = en3;
	}

	public String getEn4() {
		return en4;
	}

	public void setEn4(String en4) {
		this.en4 = en4;
	}

	public String getEn5() {
		return en5;
	}

	public void setEn5(String en5) {
		this.en5 = en5;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Enjeux> getEnjeux() {
		return enjeux;
	}

	public void setEnjeux(List<Enjeux> enjeux) {
		this.enjeux = enjeux;
	}

	public List<Priorité> getPriorité() {
		return priorité;
	}

	public void setPriorité(List<Priorité> priorité) {
		this.priorité = priorité;
	}

	public List<Statut> getStatut() {
		return statut;
	}

	public void setStatut(List<Statut> statut) {
		this.statut = statut;
	}

	public List<Reliquat> getReliquat() {
		return reliquat;
	}

	public void setReliquat(List<Reliquat> reliquat) {
		this.reliquat = reliquat;
	}

	public List<Type_DA> getType_da() {
		return type_da;
	}

	public void setType_da(List<Type_DA> type_da) {
		this.type_da = type_da;
	}

	public List<Prestataire> getPrestataires() {
		return prestataires;
	}

	public void setPrestataires(List<Prestataire> prestataires) {
		this.prestataires = prestataires;
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

	public List<Prestataire> getSelectedPrestataires() {
		return SelectedPrestataires;
	}

	public void setSelectedPrestataires(List<Prestataire> selectedPrestataires) {
		SelectedPrestataires = selectedPrestataires;
	}

	public List<SelectItem> getUsersSelect() {
		return usersSelect;
	}

	public void setUsersSelect(List<SelectItem> usersSelect) {
		this.usersSelect = usersSelect;
	}

	public List<SelectItem> getEnjeuxSelect() {
		return enjeuxSelect;
	}

	public void setEnjeuxSelect(List<SelectItem> enjeuxSelect) {
		this.enjeuxSelect = enjeuxSelect;
	}

	public List<SelectItem> getPrioritéSelect() {
		return prioritéSelect;
	}

	public void setPrioritéSelect(List<SelectItem> prioritéSelect) {
		this.prioritéSelect = prioritéSelect;
	}

	public List<SelectItem> getStatutSelect() {
		return statutSelect;
	}

	public void setStatutSelect(List<SelectItem> statutSelect) {
		this.statutSelect = statutSelect;
	}

	public List<SelectItem> getReliquatSelect() {
		return reliquatSelect;
	}

	public void setReliquatSelect(List<SelectItem> reliquatSelect) {
		this.reliquatSelect = reliquatSelect;
	}

	public List<SelectItem> getTypeDASelect() {
		return typeDASelect;
	}

	public void setTypeDASelect(List<SelectItem> typeDASelect) {
		this.typeDASelect = typeDASelect;
	}

	public List<SelectItem> getApplicationSelect() {
		return applicationSelect;
	}

	public void setApplicationSelect(List<SelectItem> applicationSelect) {
		this.applicationSelect = applicationSelect;
	}

	public List<SelectItem> getEntiteSelect() {
		return entiteSelect;
	}

	public void setEntiteSelect(List<SelectItem> entiteSelect) {
		this.entiteSelect = entiteSelect;
	}

	public Project getP() {
		return p;
	}

	public void setP(Project p) {
		this.p = p;
	}

	public String getLibélé() {
		return libélé;
	}

	public void setLibélé(String libélé) {
		this.libélé = libélé;
	}

	public String getDescriptionProjet() {
		return descriptionProjet;
	}

	public void setDescriptionProjet(String descriptionProjet) {
		this.descriptionProjet = descriptionProjet;
	}

	public String getLancerMetier() {
		return lancerMetier;
	}

	public void setLancerMetier(String lancerMetier) {
		this.lancerMetier = lancerMetier;
	}

	public String getLc() {
		return lc;
	}

	public void setLc(String lc) {
		this.lc = lc;
	}

	public float getBudget_int() {
		return budget_int;
	}

	public void setBudget_int(float budget_int) {
		this.budget_int = budget_int;
	}

	public float getBudget_supp() {
		return budget_supp;
	}

	public void setBudget_supp(float budget_supp) {
		this.budget_supp = budget_supp;
	}

	public float getBudget_rev() {
		return budget_rev;
	}

	public void setBudget_rev(float budget_rev) {
		this.budget_rev = budget_rev;
	}

	public int getCharge_prev() {
		return charge_prev;
	}

	public void setCharge_prev(int charge_prev) {
		this.charge_prev = charge_prev;
	}

	public int getCharge_supp() {
		return charge_supp;
	}

	public void setCharge_supp(int charge_supp) {
		this.charge_supp = charge_supp;
	}

	public int getCharge_Total() {
		return charge_Total;
	}

	public void setCharge_Total(int charge_Total) {
		this.charge_Total = charge_Total;
	}

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

	public String getPanel1() {
		return panel1;
	}

	public void setPanel1(String panel1) {
		this.panel1 = panel1;
	}

	public boolean isInuput_recherche() {
		return inuput_recherche;
	}

	public void setInuput_recherche(boolean inuput_recherche) {
		this.inuput_recherche = inuput_recherche;
	}

	public boolean isButton_recherche() {
		return button_recherche;
	}

	public void setButton_recherche(boolean button_recherche) {
		this.button_recherche = button_recherche;
	}

}
