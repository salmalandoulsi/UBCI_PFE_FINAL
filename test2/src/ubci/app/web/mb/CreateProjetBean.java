package ubci.app.web.mb;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.jms.Session;

import ubci.app.business.AttributsProjetServiceLocal;
import ubci.app.business.AuthenticationServiceLocal;
import ubci.app.business.BudgetServiceLocal;
import ubci.app.business.HistoriqueProjectLocal;
import ubci.app.business.PrestataireServiceLocal;
import ubci.app.business.ProjectServiceLocal;
import ubci.app.business.UserServiceLocal;
import ubci.app.persistence.Application;
import ubci.app.persistence.Charge_Budget;
import ubci.app.persistence.Enjeux;
import ubci.app.persistence.Entit�;
import ubci.app.persistence.HistoriqueProjet;
import ubci.app.persistence.Prestataire;
import ubci.app.persistence.Priorit�;
import ubci.app.persistence.Project;
import ubci.app.persistence.ProjectPrestataire;
import ubci.app.persistence.Reliquat;
import ubci.app.persistence.Revision_Budget_Prestataire;
import ubci.app.persistence.R�vision_Budget_Projet;
import ubci.app.persistence.Statut;
import ubci.app.persistence.Type_DA;
import ubci.app.persistence.User;

@ManagedBean(name = "projetBean")
@ViewScoped
public class CreateProjetBean implements Serializable {

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
	@EJB
	private HistoriqueProjectLocal historiqueService;
	

	@EJB
	private BudgetServiceLocal budgetService;

	
	public String userName;
	public String userLastName;
	public String loginChef;
	public String loginSponsor;
	public String loginMOA;
	public String entit�;
	public String app;
	public String macrochiffrage;

	private List<Integer> prest = new ArrayList<Integer>();
	private HistoriqueProjet historique= new HistoriqueProjet();

	public String en, en2, en3, en4, en5;

	private List<Project> projects = new ArrayList<Project>();
	private List<User> users = new ArrayList<User>();
	private List<Enjeux> enjeux = new ArrayList<Enjeux>();
	private List<Priorit�> priorit� = new ArrayList<Priorit�>();
	private List<Statut> statut = new ArrayList<Statut>();
	private List<Reliquat> reliquat = new ArrayList<Reliquat>();
	private List<Type_DA> type_da = new ArrayList<Type_DA>();
	private List<Prestataire> prestataires = new ArrayList<Prestataire>();
	private List<Entit�> entites = new ArrayList<Entit�>();
	private List<Application> applications = new ArrayList<Application>();
	private List<PrestataireBean> PrestataireBeans = new ArrayList<PrestataireBean>();


	
	private List<PrestataireBean> SelectedPrestataires1 = new ArrayList<PrestataireBean>();
	private List<Prestataire> SelectedPrestataires = new ArrayList<Prestataire>();
	private List<SelectItem> usersSelect = new ArrayList<SelectItem>();
	private List<SelectItem> enjeuxSelect = new ArrayList<SelectItem>();
	private List<SelectItem> priorit�Select = new ArrayList<SelectItem>();
	private List<SelectItem> statutSelect = new ArrayList<SelectItem>();
	private List<SelectItem> reliquatSelect = new ArrayList<SelectItem>();
	private List<SelectItem> typeDASelect = new ArrayList<SelectItem>();
	private List<SelectItem> applicationSelect = new ArrayList<SelectItem>();
	private List<SelectItem> entiteSelect = new ArrayList<SelectItem>();

	private Project p = new Project();

	private String lib�l� = "";
	private String descriptionProjet="";

	private static final long serialVersionUID = -9040274036031665311L;

	private String lancerMetier="";
	private String lc="";
	private float budget_int=0;
	private float budget_supp=0;
	private float budget_rev=0;
	private int charge_prev=0;
	private int charge_supp=0;
	private int charge_Total=0;
	
	
	private Date d_receptionDA = new Date();
	private Date d_cloture = new Date();

	private Date d_�tude = new Date();
	private Date f_�tude = new Date();
	private Date envoiePres = new Date();
	private Date plannificationPres = new Date();
	private Date d_�tudePres = new Date();
	private Date f_�tudePres = new Date();
	private Date d_recette = new Date();
	private Date f_recette = new Date();
	private Date d_r�alisation= new Date();
	private Date f_r�alisation= new Date();

	private Date livraisonPres = new Date();
	private Date mepDA = new Date();
	private Date d_exp = new Date();
	private Date f_exp = new Date();
	private Date d_garentie= new Date();
	private Date f_garentie= new Date();


	
	private Date d_cloture_R = new Date();

	private Date d_�tude_R = new Date();
	private Date f_�tude_R = new Date();
	private Date envoiePres_R = new Date();
	private Date plannificationPres_R = new Date();
	private Date d_�tudePres_R = new Date();
	private Date f_�tudePres_R = new Date();
	private Date d_recette_R = new Date();
	private Date f_recette_R = new Date();
	private Date d_r�alisation_R= new Date();
	private Date f_r�alisation_R= new Date();

	private Date livraisonPres_R = new Date();
	private Date mepDA_R = new Date();
	private Date d_exp_R = new Date();
	private Date f_exp_R = new Date();
	private Date d_garentie_R= new Date();
	private Date f_garentie_R= new Date();









	public Date getD_r�alisation() {
		return d_r�alisation;
	}

	public void setD_r�alisation(Date d_r�alisation) {
		this.d_r�alisation = d_r�alisation;
	}

	public Date getF_r�alisation() {
		return f_r�alisation;
	}

	public void setF_r�alisation(Date f_r�alisation) {
		this.f_r�alisation = f_r�alisation;
	}

	public Date getD_garentie() {
		return d_garentie;
	}

	public void setD_garentie(Date d_garentie) {
		this.d_garentie = d_garentie;
	}

	public Date getF_garentie() {
		return f_garentie;
	}

	public void setF_garentie(Date f_garentie) {
		this.f_garentie = f_garentie;
	}

	public Date getD_r�alisation_R() {
		return d_r�alisation_R;
	}

	public void setD_r�alisation_R(Date d_r�alisation_R) {
		this.d_r�alisation_R = d_r�alisation_R;
	}

	public Date getF_r�alisation_R() {
		return f_r�alisation_R;
	}

	public void setF_r�alisation_R(Date f_r�alisation_R) {
		this.f_r�alisation_R = f_r�alisation_R;
	}

	public Date getD_garentie_R() {
		return d_garentie_R;
	}

	public void setD_garentie_R(Date d_garentie_R) {
		this.d_garentie_R = d_garentie_R;
	}

	public Date getF_garentie_R() {
		return f_garentie_R;
	}

	public void setF_garentie_R(Date f_garentie_R) {
		this.f_garentie_R = f_garentie_R;
	}

	public CreateProjetBean() {
		super();
	}

	@PostConstruct
	public void init() {
		entites=attributService.findAllEntit�();
		applications= attributService.findAllApplication();
		//projects = projService.findAllProject();
		users = userService.findAllUser();
		enjeux = attributService.findAllEnjeux();
		priorit� = attributService.findAllPriorit�();
		statut = attributService.findAllStatut();
		reliquat = attributService.findAllReliquat();
		type_da = attributService.findAllType_DA();
		prestataires = prestService.findAllPrestataire();
		
		Project p= new Project();
		p.setId("160001");
		
		Charge_Budget charge = new Charge_Budget();
		charge.setIdCharge(1);
		charge.setJh(50);
		charge.setTnd(100);
		R�vision_Budget_Projet budgetProjet = new R�vision_Budget_Projet();
		Revision_Budget_Prestataire budgetPrestataire= new Revision_Budget_Prestataire();

		budgetProjet.setBudget_final(12);
		budgetProjet.setBudget_initial(10);
		budgetProjet.setProjet(p);
//		
//		
//	
		budgetPrestataire.setCharge(charge);
		budgetPrestataire.setId_prestataire(1);
	
		budgetPrestataire.setMotif("dftgyhujikl");
		budgetPrestataire.setR�vision_projet(budgetProjet);
		//budgetService.createRevision_Budget_Prestataire(budgetPrestataire);
		budgetService.createR�vision_Budget_Projet(budgetProjet);
		System.out.println("Done");
		
		for (int i=0 ; i<prestataires.size();i++)
		{PrestataireBeans.add(new PrestataireBean(prestataires.get(i), ""));
			
		}

		for (int i = 0; i < reliquat.size(); i++) {
			SelectItem I5 = new SelectItem(reliquat.get(i).getLib�l�(),
					reliquat.get(i).getLib�l�());
			reliquatSelect.add(I5);

		}

		for (int i = 0; i < applications.size(); i++) {
			SelectItem I6 = new SelectItem(applications.get(i).getLib�l�(), applications
					.get(i).getLib�l�());
			applicationSelect.add(I6);
		}
		for (int i = 0; i < entites.size(); i++) {
			SelectItem I7 = new SelectItem(entites.get(i).getLib�l�(), entites
					.get(i).getLib�l�());
			entiteSelect.add(I7);
		}

		for (int i = 0; i < statut.size(); i++) {
			SelectItem I4 = new SelectItem(statut.get(i).getLib�l�(), statut
					.get(i).getLib�l�());
			statutSelect.add(I4);
		}

		for (int i = 0; i < priorit�.size(); i++) {

			SelectItem I3 = new SelectItem(priorit�.get(i).getLib�l�(),
					priorit�.get(i).getLib�l�());
			priorit�Select.add(I3);

		}
		for (int i = 0; i < users.size(); i++) {
			SelectItem I1 = new SelectItem(users.get(i).getLogin(), users
					.get(i).getLogin());
			usersSelect.add(I1);

		}

		for (int i = 0; i < enjeux.size(); i++) {

			SelectItem I2 = new SelectItem(enjeux.get(i).getLib�l�(), enjeux
					.get(i).getLib�l�());
			enjeuxSelect.add(I2);

		}

		for (int i = 0; i < type_da.size(); i++) {
			SelectItem I2 = new SelectItem(type_da.get(i).getLib�l�(), type_da
					.get(i).getLib�l�());
			typeDASelect.add(I2);

		}

	}

	// Creation Projet
	public void doCreateProject() {
		System.out.printf("**** id");

		String id = incr�mentID();
		p.setId(id);
		// p.setLib�l�("helloAgain");

		int idEnjeux = 0;
		int idPriorite = 0;
		int idReliquat = 0;
		int idStatut = 0;
		int idTypeDa = 0;
		int idChefP = 0;
		int idSponsor=0;
		int idMOA=0;
		int idEntit�=0;
		int idApp=0;
		System.out.printf("**** initialisation \n");

		idEntit�= searchTheIdEntit�(entit�, entites);
		idApp= searchTheIdApplication(app, applications);
		idEnjeux = searchTheIdEnjeux(en, enjeux);
		idPriorite = searchTheIdPriorite(en2, priorit�);
		idReliquat = searchTheIdReliquat(en3, reliquat);
		idStatut = searchTheIdStatut(en4, statut);
		idTypeDa = searchTheIdDA(en5, type_da);

		System.out.println("****searching \n");

		idChefP = searchTheIdUser(loginChef, users);
		idSponsor = searchTheIdUser(loginSponsor, users);
		idMOA = searchTheIdUser(loginMOA, users);

		System.out.println("***search done \n");

		p.setEnjeux(idEnjeux);
		p.setPriorit�(idPriorite);
		p.setReliquat(idReliquat);
		p.setStatut(idStatut);
		p.setTypeDA(idTypeDa);
		p.setMOA(idMOA);
		p.setChefP(idChefP);
		p.setSpons(idSponsor);
		p.setLib�l�(lib�l�);
		p.setD_r�ceptionDA(d_�tude);
		p.setLancerMetier(lancerMetier);
		p.setLC(lc);
		p.setEntite(idEntit�);
		p.setApp(idApp);
		p.setBudget_int(budget_int);
		p.setBudget_rev(budget_rev);
		p.setBudget_supp(budget_supp);
		p.setCharge_prev(charge_prev);
		p.setCharge_supp(charge_supp);
		p.setCharge_Total(charge_Total);
		p.setMacrochiffrage(macrochiffrage);
		p.setDescription(descriptionProjet);

		projService.createProject(p);
	
		
//		System.out.println("****creation hiqtorique********");
//		historique.setId(p.getId());
//		System.out.println("id ="+historique.getId());
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		Date date = new Date();
//		historique.setDate(dateFormat.format(date));
//		historique.setHdescription("Creation du projet");
//		historique.setId(null);
//		historiqueService.createHistorique(historique);
//		System.out.println("****fin historique********");
		System.out.println("****d�but prestataire********");

		System.out.println("****id=" + p.getId() + "********");

		for (int i = 0; i < SelectedPrestataires1.size(); i++) {
			System.out.println("****boucle ********");
			System.out.println(SelectedPrestataires1.get(i).getP().getId());
			projService.createProjetPrestataire(p.getId(), SelectedPrestataires1
					.get(i).getP().getId(),SelectedPrestataires1
					.get(i).getR�f�rence());
			System.out.println(SelectedPrestataires1.get(i).getP().getId());
		}

	}

	public void dosaveOrUpdateProject(Project p) {

		projService.saveOrUpdateProject(p);
	}

	public String doLogin() {
		User fund = authentif.authenticate(user.getLogin(), user.getPassword());

		// System.out.printf("************");
		String navigateTo = null;

		// System.out.printf("comparaison");
		if (fund != null) {
			// System.out.printf("comparaison faite ");
			user = fund;
			navigateTo = "admin/home.xhtml";
			// System.out.printf("redirection effectu�e");

		} else {
			// System.out.printf("erreur");
			navigateTo = "error.xhtml";
			// System.out.printf("erreur confirmer");

		}
		return navigateTo;
	}

	// methos

	public int CalculateNBJour() {
		int jour = 0;
		Date date = new Date();

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		// get current date time with Date()

		// System.out.println(dateFormat.format(date));

		return jour;
	}

	public String incr�mentID() {
		String id = "";
		Date date = new Date();

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		// get current date time with Date()

		// System.out.println(dateFormat.format(date));

		char[] idyear = new char[3];// r�cup�ration de l'ann�e
		char[] id1 = new char[6];// l'id
		String nbprojet;
		int n = 0;// nbr de projet
		projects = projService.findAllProject();
		n = projects.size();

		try {
			dateFormat.format(date).getChars(2, 4, idyear, 0);

			// initialisation de l'id � 000
			for (int i = 0; i < id1.length; i++) {
				id1[i] = '0';
			}
			// System.out.println(id1);
			nbprojet = "" + n++;

			// ajout de l'ann�e
			for (int i = 0; i < 2; i++) {
				id1[i] = idyear[i];
			}

			nbprojet = "" + n++;// incr�mentation du nbr de projet
			// affectation du nbr de projet � l'id
			int j = 0;
			for (int i = nbprojet.toCharArray().length - 1; i >= 0; i--) {

				id1[id1.length - 1 - j] = nbprojet.toCharArray()[i];
				j++;
			}

			// System.out.println("le nouvel id ");
			// System.out.println(id1);

		} catch (Exception ex) {
			// System.out.println("Raised exception...");
		}

		// affectation de l'id
		id = String.valueOf(id1);

		return id;
	}

	/*
	 * Helper methods
	 */
	public int searchTheIdUser(String login, List<User> ar) {
		int val = 0;
		for (int i = 0; i < ar.size(); i++) {

			if ((ar.get(i)).getLogin().equals(login)) {

				val = users.get(i).getId();

			}
		}
		System.out.printf("enjeu id " + val + "");

		return val;
	}
	//enit�
		public int searchTheIdEntit�(String lib, List<Entit�> ar) {
			int val = 0;
			for (int i = 0; i < ar.size(); i++) {

				if ((ar.get(i)).getLib�l�().equals(lib)) {
					val = entites.get(i).getId();
				}
			}
			System.out.printf("Entit� id " + val + "");

			return val;
		}
	//applicatiion
	public int searchTheIdApplication(String lib, List<Application> ar) {
		int val = 0;
		for (int i = 0; i < ar.size(); i++) {

			if ((ar.get(i)).getLib�l�().equals(lib)) {
				val = applications.get(i).getId();
			}
		}
		System.out.printf("Application id " + val + "");

		return val;
	}
	// Enjeux
	public int searchTheIdEnjeux(String lib, List<Enjeux> ar) {
		int val = 0;
		for (int i = 0; i < ar.size(); i++) {

			if ((ar.get(i)).getLib�l�().equals(lib)) {
				val = enjeux.get(i).getId();
			}
		}
		System.out.printf("enjeu id " + val + "");

		return val;
	}

	// Priorite
	public int searchTheIdPriorite(String lib, List<Priorit�> ar) {
		int val = 0;
		for (int i = 0; i < ar.size(); i++) {

			if ((ar.get(i)).getLib�l�().equals(lib)) {
				val = priorit�.get(i).getId();
			}
		}
		System.out.printf("priorite id " + val + "");

		return val;
	}

	// Reliquat
	public int searchTheIdReliquat(String lib, List<Reliquat> ar) {
		int val = 0;
		for (int i = 0; i < ar.size(); i++) {

			if ((ar.get(i)).getLib�l�().equals(lib)) {
				val = reliquat.get(i).getId();
			}
		}
		System.out.printf("Reliquat id " + val + "");

		return val;
	}

	// Statut
	public int searchTheIdStatut(String lib, List<Statut> ar) {
		int val = 0;
		for (int i = 0; i < ar.size(); i++) {

			if ((ar.get(i)).getLib�l�().equals(lib)) {
				val = statut.get(i).getId();
			}
		}
		System.out.printf("Statut id " + val + "");

		return val;
	}

	// DA
	public int searchTheIdDA(String lib, List<Type_DA> ar) {
		int val = 0;
		for (int i = 0; i < ar.size(); i++) {

			if ((ar.get(i)).getLib�l�().equals(lib)) {
				val = type_da.get(i).getId();
			}
		}
		System.out.printf("DA id " + val + "");

		return val;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// getters & Setters

	public String getEn3() {
		return en3;
	}

	public List<Prestataire> getSelectedPrestataires() {
		return SelectedPrestataires;
	}

	public void setSelectedPrestataires(List<Prestataire> selectedPrestataires) {
		SelectedPrestataires = selectedPrestataires;
	}

	public List<Integer> getPrest() {
		return prest;
	}

	public void setPrest(List<Integer> prest) {
		this.prest = prest;
	}

	public List<Prestataire> getPrestataires() {
		return prestataires;
	}

	public void setPrestataires(List<Prestataire> prestataires) {
		this.prestataires = prestataires;
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

	public String getEn2() {
		return en2;
	}

	public void setEn2(String en2) {
		this.en2 = en2;
	}

	public String getEn() {
		return en;
	}

	public void setEn(String en) {
		this.en = en;
	}

	public PrestataireServiceLocal getPrestService() {
		return prestService;
	}

	public void setPrestService(PrestataireServiceLocal prestService) {
		this.prestService = prestService;
	}

	public String getLogin() {
		return loginChef;
	}

	public void setLogin(String login) {
		this.loginChef = login;
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

	public List<SelectItem> getTypeDASelect() {
		return typeDASelect;
	}

	public void setTypeDASelect(List<SelectItem> typeDASelect) {
		this.typeDASelect = typeDASelect;
	}

	private User user = new User();

	public List<SelectItem> getPriorit�Select() {
		return priorit�Select;
	}

	public void setPriorit�Select(List<SelectItem> priorit�Select) {
		this.priorit�Select = priorit�Select;
	}

	public List<Priorit�> getPriorit�() {
		return priorit�;
	}

	public void setPriorit�(List<Priorit�> priorit�) {
		this.priorit� = priorit�;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public List<SelectItem> getStatutSelect() {
		return statutSelect;
	}

	public void setStatutSelect(List<SelectItem> statutSelect) {
		this.statutSelect = statutSelect;
	}

	public List<SelectItem> getUsersSelect() {
		return usersSelect;
	}

	public void setUsersSelect(List<SelectItem> usersSelect) {
		this.usersSelect = usersSelect;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public String getLib�l�() {
		return lib�l�;
	}

	public void setLib�l�(String lib�l�) {
		this.lib�l� = lib�l�;
	}

	public Project getP() {
		return p;
	}

	public void setP(Project p) {
		this.p = p;
	}

	public Date getF_�tude() {
		return f_�tude;
	}

	public void setF_�tude(Date f_�tude) {
		this.f_�tude = f_�tude;
	}

	public Date getD_�tude() {
		return d_�tude;
	}

	public void setD_�tude(Date d_�tude) {
		this.d_�tude = d_�tude;
	}

	public User getUser() {
		return user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Enjeux> getEnjeux() {
		return enjeux;
	}

	public void setEnjeux(List<Enjeux> enjeux) {
		this.enjeux = enjeux;
	}

	public List<SelectItem> getEnjeuxSelect() {
		return enjeuxSelect;
	}

	public void setEnjeuxSelect(List<SelectItem> enjeuxSelect) {
		this.enjeuxSelect = enjeuxSelect;
	}

	public List<SelectItem> getReliquatSelect() {
		return reliquatSelect;
	}

	public void setReliquatSelect(List<SelectItem> reliquatSelect) {
		this.reliquatSelect = reliquatSelect;
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

	public Date getD_receptionDA() {
		return d_receptionDA;
	}

	public void setD_receptionDA(Date d_receptionDA) {
		this.d_receptionDA = d_receptionDA;
	}

	public Date getD_cloture() {
		return d_cloture;
	}

	public void setD_cloture(Date d_cloture) {
		this.d_cloture = d_cloture;
	}

	public Date getEnvoiePres() {
		return envoiePres;
	}

	public void setEnvoiePres(Date envoiePres) {
		this.envoiePres = envoiePres;
	}

	public Date getPlannificationPres() {
		return plannificationPres;
	}

	public void setPlannificationPres(Date plannificationPres) {
		this.plannificationPres = plannificationPres;
	}

	public Date getD_�tudePres() {
		return d_�tudePres;
	}

	public void setD_�tudePres(Date d_�tudePres) {
		this.d_�tudePres = d_�tudePres;
	}

	public Date getF_�tudePres() {
		return f_�tudePres;
	}

	public void setF_�tudePres(Date f_�tudePres) {
		this.f_�tudePres = f_�tudePres;
	}

	public Date getD_recette() {
		return d_recette;
	}

	public void setD_recette(Date d_recette) {
		this.d_recette = d_recette;
	}

	public Date getF_recette() {
		return f_recette;
	}

	public void setF_recette(Date f_recette) {
		this.f_recette = f_recette;
	}

	public Date getLivraisonPres() {
		return livraisonPres;
	}

	public void setLivraisonPres(Date livraisonPres) {
		this.livraisonPres = livraisonPres;
	}

	public Date getMepDA() {
		return mepDA;
	}

	public void setMepDA(Date mepDA) {
		this.mepDA = mepDA;
	}

	public Date getD_exp() {
		return d_exp;
	}

	public void setD_exp(Date d_exp) {
		this.d_exp = d_exp;
	}

	public Date getF_exp() {
		return f_exp;
	}

	public void setF_exp(Date f_exp) {
		this.f_exp = f_exp;
	}

	public Date getD_cloture_R() {
		return d_cloture_R;
	}

	public void setD_cloture_R(Date d_cloture_R) {
		this.d_cloture_R = d_cloture_R;
	}

	public Date getD_�tude_R() {
		return d_�tude_R;
	}

	public void setD_�tude_R(Date d_�tude_R) {
		this.d_�tude_R = d_�tude_R;
	}

	public Date getF_�tude_R() {
		return f_�tude_R;
	}

	public void setF_�tude_R(Date f_�tude_R) {
		this.f_�tude_R = f_�tude_R;
	}

	public Date getEnvoiePres_R() {
		return envoiePres_R;
	}

	public void setEnvoiePres_R(Date envoiePres_R) {
		this.envoiePres_R = envoiePres_R;
	}

	public Date getPlannificationPres_R() {
		return plannificationPres_R;
	}

	public void setPlannificationPres_R(Date plannificationPres_R) {
		this.plannificationPres_R = plannificationPres_R;
	}

	public Date getD_�tudePres_R() {
		return d_�tudePres_R;
	}

	public void setD_�tudePres_R(Date d_�tudePres_R) {
		this.d_�tudePres_R = d_�tudePres_R;
	}

	public Date getF_�tudePres_R() {
		return f_�tudePres_R;
	}

	public void setF_�tudePres_R(Date f_�tudePres_R) {
		this.f_�tudePres_R = f_�tudePres_R;
	}

	public Date getD_recette_R() {
		return d_recette_R;
	}

	public void setD_recette_R(Date d_recette_R) {
		this.d_recette_R = d_recette_R;
	}

	public Date getF_recette_R() {
		return f_recette_R;
	}

	public void setF_recette_R(Date f_recette_R) {
		this.f_recette_R = f_recette_R;
	}

	public Date getLivraisonPres_R() {
		return livraisonPres_R;
	}

	public void setLivraisonPres_R(Date livraisonPres_R) {
		this.livraisonPres_R = livraisonPres_R;
	}

	public Date getMepDA_R() {
		return mepDA_R;
	}

	public void setMepDA_R(Date mepDA_R) {
		this.mepDA_R = mepDA_R;
	}

	public Date getD_exp_R() {
		return d_exp_R;
	}

	public void setD_exp_R(Date d_exp_R) {
		this.d_exp_R = d_exp_R;
	}

	public Date getF_exp_R() {
		return f_exp_R;
	}

	public void setF_exp_R(Date f_exp_R) {
		this.f_exp_R = f_exp_R;
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

	public String getEntit�() {
		return entit�;
	}

	public void setEntit�(String entit�) {
		this.entit� = entit�;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public List<Entit�> getEntites() {
		return entites;
	}

	public void setEntites(List<Entit�> entites) {
		this.entites = entites;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
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

	public String getMacrochiffrage() {
		return macrochiffrage;
	}

	public void setMacrochiffrage(String macrochiffrage) {
		this.macrochiffrage = macrochiffrage;
	}

	public String getDescriptionProjet() {
		return descriptionProjet;
	}

	public void setDescriptionProjet(String descriptionProjet) {
		this.descriptionProjet = descriptionProjet;
	}

	public HistoriqueProjet getHistorique() {
		return historique;
	}

	public void setHistorique(HistoriqueProjet historique) {
		this.historique = historique;
	}

	public List<PrestataireBean> getSelectedPrestataires1() {
		return SelectedPrestataires1;
	}

	public void setSelectedPrestataires1(List<PrestataireBean> selectedPrestataires1) {
		SelectedPrestataires1 = selectedPrestataires1;
	}

	public List<PrestataireBean> getPrestataireBeans() {
		return PrestataireBeans;
	}

	public void setPrestataireBeans(List<PrestataireBean> prestataireBeans) {
		PrestataireBeans = prestataireBeans;
	}

	
}
