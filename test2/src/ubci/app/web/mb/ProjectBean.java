package ubci.app.web.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ubci.app.business.AttributsProjetServiceLocal;
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

@ManagedBean(name = "project1")
@ViewScoped
public class ProjectBean implements Serializable {

	private static final long serialVersionUID = -9046215104266175386L;

	@EJB
	private ProjectServiceLocal projService;
	@EJB
	private UserServiceLocal userService;
	@EJB
	private AttributsProjetServiceLocal attributService;
	@EJB
	private PrestataireServiceLocal prestService;

	private List<Project> projects = new ArrayList<Project>();

	private List<User> users = new ArrayList<User>();
	private List<String> MOAConnetion = new ArrayList<String>();
	private List<String> SponsorConnetion = new ArrayList<String>();
	private List<String> ChefPConnetion = new ArrayList<String>();



	private List<Enjeux> enjeux = new ArrayList<Enjeux>();
	private List<String> enjeuxConnetion = new ArrayList<String>();
	private List<Priorité> priorité = new ArrayList<Priorité>();
	private List<Entité> entités = new ArrayList<Entité>();
	private List<Application> application = new ArrayList<Application>();
	private List<String> prioriteConnetion = new ArrayList<String>();
	private List<Statut> statut = new ArrayList<Statut>();
	private List<String> statutConnetion = new ArrayList<String>();
	private List<Reliquat> reliquat = new ArrayList<Reliquat>();
	private List<String> reliquatConnetion = new ArrayList<String>();
	private List<Type_DA> type_da = new ArrayList<Type_DA>();
	private List<String> type_daConnetion = new ArrayList<String>();
	private List<Prestataire> prestataires = new ArrayList<Prestataire>();
	private List<String> prestatiresConnetion = new ArrayList<String>();
	private List<String> entiteConnection = new ArrayList<String>();
	private List<String> appConnetion = new ArrayList<String>();


	private Enjeux enj = new Enjeux();
	private List<String> lancer = new ArrayList<String>();
	private List<String> LCS = new ArrayList<String>();

	private String libélé = "";
	private String nomUser = "";
	private String p, e, s, da, r,entité,app;
	private String lancerMetier = "";
	private String lc = "";

	private int ip, ie, is, ida, ir,iapp,ientite;
	private int iMOA ,iSponsor,iChefP;
	
	
	
	private List<Project> filteredProjects;
	 

	@PostConstruct
	public void init() {
		iMOA = 0;
		iSponsor=0;
		iChefP=0;
		ip = 0;
		ie = 0;
		is = 0;
		ida = 0;
		ir = 0;
		iapp=0;
		ientite=0;
		
		
		projects = projService.findAllProject();
		System.out.println("find projets done****");
		users = userService.findAllUser();
		enjeux = attributService.findAllEnjeux();
		priorité = attributService.findAllPriorité();
		statut = attributService.findAllStatut();
		reliquat = attributService.findAllReliquat();
		type_da = attributService.findAllType_DA();
		setEntités(attributService.findAllEntité());
		setApplication(attributService.findAllApplication());
		
		prestataires = prestService.findAllPrestataire();

		for (int i = 0; i < projects.size(); i++) {
			int idMOA ,idSponsor,idChefP, idp, ide, ids, idda, idr,idapp,identite;
			
			System.out.println("i=" + i);
			
			identite= projects.get(i).getEntite();
			System.out.println("id entité="+identite);
			try {
				entiteConnection.add(attributService.findEntitéById(identite).getLibélé());
				System.out.println("entité="+attributService.findEntitéById(identite).getLibélé());
			} catch (Exception ex) {
				entiteConnection.add("");
			}
			idapp= projects.get(i).getApp();
			try {
				appConnetion.add(attributService.findApplicationById(idapp).getLibélé());
				System.out.println("app="+attributService.findApplicationById(idapp).getLibélé());
			} catch (Exception ex) {
				appConnetion.add("");
			}
			idChefP= projects.get(i).getChefP();
			try{
			ChefPConnetion.add(userService.findUserById(idChefP).getLogin());
			System.out.println("chefP="
					+ userService.findUserById(idChefP).getLogin());
			}catch(Exception ex){
				ChefPConnetion.add("");
			}
			idSponsor= projects.get(i).getSpons();
			try{
			SponsorConnetion.add(userService.findUserById(idSponsor).getLogin());
			System.out.println("sponsor="
					+ userService.findUserById(idSponsor).getLogin());
			}catch(Exception ex){
				SponsorConnetion.add("");
			}

			idMOA = projects.get(i).getMOA();
			try{
			MOAConnetion.add(userService.findUserById(idMOA).getLogin());
			System.out.println("user="
					+ userService.findUserById(idMOA).getLogin());
			}catch(Exception ex){
				MOAConnetion.add("");
			}
			idp = projects.get(i).getPriorité();

			

			try {
				prioriteConnetion.add( attributService.findPrioritéById(idp).getLibélé());
				System.out.println("priorité=" +attributService.findPrioritéById(idp)
						.getLibélé());
			} catch (Exception ex) {
				prioriteConnetion.add("");
			}
			ids = projects.get(i).getStatut();
			try {
				statutConnetion.add(attributService.findStatutById(ids)
						.getLibélé());
				System.out.println("statut="+attributService.findStatutById(ids)
						.getLibélé());
			} catch (Exception ex) {
				statutConnetion.add("");
			}
			idr = projects.get(i).getReliquat();
			try {
				reliquatConnetion.add(attributService.findReliquatById(idr)
						.getLibélé());
				System.out.println("statut="+attributService.findReliquatById(idr)
						.getLibélé());
			} catch (Exception ex) {
				reliquatConnetion.add("");
			}
			idda = projects.get(i).getTypeDA();
			try{
			type_daConnetion.add(attributService.findType_DAById(idda)
					.getLibélé());
			}catch(Exception ex){
				type_daConnetion.add("");
			}
			ide = projects.get(i).getEnjeux();
			try{
			enjeuxConnetion.add(attributService.findEnjeuxById(ide).getLibélé());
			}catch(Exception ex){
				enjeuxConnetion.add("");
			}
			System.out.println("enjeux done");
			System.out.println("type_da done");
			
			
		}
		System.out.println("**************  fin Init *********");
	}
	public String incrementationChefP() {
		nomUser = ChefPConnetion.get(iChefP);

		iChefP++;
		System.out.println("incrementationChefP done***");
		return nomUser;

	}
	public String incrementationSponsor() {
		nomUser = SponsorConnetion.get(iSponsor);

		iSponsor++;
		System.out.println("incrementationSponsor done***");
		return nomUser;

	}
	public String incrementationMOA() {
		nomUser = MOAConnetion.get(iMOA);

		iMOA++;
		System.out.println("incrementationMOA done***");
		return nomUser;

	}
	public String incrementTypeDA() {
		da = type_daConnetion.get(ida);

		ida++;

		return da;

	}
	public String incrementEntité() {
		System.out.println(" ****************début incrementEntité***");
		System.out.println("ientité="+ientite);
		
		entité = entiteConnection.get(ientite);
		System.out.println("entité= "+entité);
		ientite++;
		System.out.println("incrementEntité done***");
		return entité;

	}
	public String incrementAPP() {
		app = appConnetion.get(iapp);

		iapp++;
		System.out.println("incrementAPP done***");
		return app;

	}

	public String incrementreliquat() {
		r = reliquatConnetion.get(ir);

		ir++;

		return r;

	}

	public String incrementstatut() {
		s = statutConnetion.get(is);

		is++;

		return s;

	}

	public String incrementPriorite() {
		p = prioriteConnetion.get(ip);

		ip++;

		return p;

	}

	public String incrementEnjeux() {
		e = enjeuxConnetion.get(ie);

		ie++;

		return e;

	}

	// getters &Setters

	public List<Project> getProjects() {
		return projects;
	}

	public List<String> getEnjeuxConnetion() {
		return enjeuxConnetion;
	}

	public void setEnjeuxConnetion(List<String> enjeuxConnetion) {
		this.enjeuxConnetion = enjeuxConnetion;
	}

	public List<String> getPrioriteConnetion() {
		return prioriteConnetion;
	}

	public void setPrioriteConnetion(List<String> prioriteConnetion) {
		this.prioriteConnetion = prioriteConnetion;
	}

	public List<String> getStatutConnetion() {
		return statutConnetion;
	}

	public void setStatutConnetion(List<String> statutConnetion) {
		this.statutConnetion = statutConnetion;
	}

	public List<String> getReliquatConnetion() {
		return reliquatConnetion;
	}

	public void setReliquatConnetion(List<String> reliquatConnetion) {
		this.reliquatConnetion = reliquatConnetion;
	}

	public List<String> getType_daConnetion() {
		return type_daConnetion;
	}

	public void setType_daConnetion(List<String> type_daConnetion) {
		this.type_daConnetion = type_daConnetion;
	}

	public List<String> getPrestatiresConnetion() {
		return prestatiresConnetion;
	}

	public void setPrestatiresConnetion(List<String> prestatiresConnetion) {
		this.prestatiresConnetion = prestatiresConnetion;
	}

	public String getLibélé() {
		return libélé;
	}

	public void setLibélé(String libélé) {
		this.libélé = libélé;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public String getNomUser() {
		return nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	

	public String getLancerMetier() {
		return lancerMetier;
	}

	public void setLancerMetier(String lancerMetier) {
		this.lancerMetier = lancerMetier;
	}

	public List<String> getLancer() {
		return lancer;
	}

	public void setLancer(List<String> lancer) {
		this.lancer = lancer;
	}

	public List<String> getLCS() {
		return LCS;
	}

	public void setLCS(List<String> lCS) {
		LCS = lCS;
	}

	public String getLc() {
		return lc;
	}

	public void setLc(String lc) {
		this.lc = lc;
	}

	public UserServiceLocal getUserService() {
		return userService;
	}

	public void setUserService(UserServiceLocal userService) {
		this.userService = userService;
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

	public List<String> getEntiteConnection() {
		return entiteConnection;
	}

	public void setEntiteConnection(List<String> entiteConnection) {
		this.entiteConnection = entiteConnection;
	}

	public List<String> getAppConnetion() {
		return appConnetion;
	}

	public void setAppConnetion(List<String> appConnetion) {
		this.appConnetion = appConnetion;
	}

	public List<Entité> getEntités() {
		return entités;
	}

	public void setEntités(List<Entité> entités) {
		this.entités = entités;
	}

	public List<Application> getApplication() {
		return application;
	}

	public void setApplication(List<Application> application) {
		this.application = application;
	}
	public List<Project> getFilteredProjects() {
		return filteredProjects;
	}
	public void setFilteredProjects(List<Project> filteredProjects) {
		this.filteredProjects = filteredProjects;
	}

	
}
