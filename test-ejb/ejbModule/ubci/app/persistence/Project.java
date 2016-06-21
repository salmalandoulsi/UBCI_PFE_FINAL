package ubci.app.persistence;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String idProject;
	private HistoriqueProjet historiqueP;
	private String libélé;
	private String macrochiffrage;
	private float budget_int = 0;
	private float budget_supp = 0;
	private float budget_rev = 0;
	private int charge_prev = 0;
	private int charge_supp = 0;
	private int charge_Total = 0;

	private int spons = 0;
	private int chefP = 0;
	private int MOA = 0;
	private int app = 0;
	private int entite = 0;
	private int enjeux = 0;
	private int priorité = 0;
	private int statut = 0;
	private int typeDA = 0;
	private int reliquat = 0;
	private int iduser = 0;
	private String lancerMetier = "";
	private String LC = "";// local/central
	private String descriptionProjet;

	@Temporal(TemporalType.TIMESTAMP)
	private Date d_réceptionDA;
	@Temporal(TemporalType.TIMESTAMP)
	private Date d_étude;
	@Temporal(TemporalType.TIMESTAMP)
	private Date f_étude;
	@Temporal(TemporalType.TIMESTAMP)
	private Date d_réalisation;
	@Temporal(TemporalType.TIMESTAMP)
	private Date f_réalisation;
	@Temporal(TemporalType.TIMESTAMP)
	private Date livraison_prestataire;
	@Temporal(TemporalType.TIMESTAMP)
	private Date d_recette;
	@Temporal(TemporalType.TIMESTAMP)
	private Date f_recette;

	@Temporal(TemporalType.TIMESTAMP)
	private Date d_cloture = new Date();

	@Temporal(TemporalType.TIMESTAMP)
	private Date envoiePres = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	private Date plannificationPres = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	private Date d_étudePres = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	private Date f_étudePres = new Date();

	@Temporal(TemporalType.TIMESTAMP)
	private Date mepDA = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	private Date d_exp = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	private Date f_exp = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	private Date d_garentie = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	private Date f_garentie = new Date();
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date d_cloture_R = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	private Date d_étude_R = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	private Date f_étude_R = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	private Date envoiePres_R = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	private Date plannificationPres_R = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	private Date d_étudePres_R = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	private Date f_étudePres_R = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	private Date d_recette_R = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	private Date f_recette_R = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	private Date livraisonPres_R = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	private Date mepDA_R = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	private Date d_exp_R = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	private Date f_exp_R = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	private Date d_réalisation_R;
	@Temporal(TemporalType.TIMESTAMP)
	private Date f_réalisation_R;
	@Temporal(TemporalType.TIMESTAMP)
	private Date d_garentie_R = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	private Date f_garentie_R = new Date();
	
	
	@OneToMany(mappedBy = "project", cascade = CascadeType.PERSIST)
	private List<ProjectUser> projectUser;

	@OneToMany(mappedBy = "proj", cascade = CascadeType.PERSIST)
	private List<ProjectPrestataire> projectPrestataire;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "projet", cascade = CascadeType.ALL)
	private Révision_Budget_Projet budgetProjet;

	public Project() {
		super();

	}

	public String getDescriptionProjet() {
		return descriptionProjet;
	}

	public void setDescriptionProjet(String descriptionProjet) {
		this.descriptionProjet = descriptionProjet;
	}

	public List<ProjectPrestataire> getProjectPrestataire() {
		return projectPrestataire;
	}

	public void setProjectPrestataire(
			List<ProjectPrestataire> projectPrestataire) {
		this.projectPrestataire = projectPrestataire;
	}

	public Révision_Budget_Projet getBudgetProjet() {
		return budgetProjet;
	}

	public void setBudgetProjet(Révision_Budget_Projet budgetProjet) {
		this.budgetProjet = budgetProjet;
	}

	public Project(String id) {
		super();
		this.idProject = id;

	}

	public Project(String id, String libélé) {
		super();
		this.idProject = id;
		this.libélé = libélé;

	}

	public Project(String id, String libélé, int sponsor, int chef_projet,
			int chef_MOA, int enjeux, int priorité, int statut, int typeDA,
			Date d_étude, Date f_étude, Date d_réalisation, Date f_réalisation,
			Date livraison_prestataire, Date d_recette, Date f_recette,
			Date d_garentie, Date f_garentie) {
		super();
		this.idProject = id;
		this.libélé = libélé;
		this.spons = sponsor;
		this.chefP = chef_projet;
		this.MOA = chef_MOA;
		this.enjeux = enjeux;
		this.priorité = priorité;
		this.statut = statut;
		this.typeDA = typeDA;
		this.d_étude = d_étude;
		this.f_étude = f_étude;
		this.d_réalisation = d_réalisation;
		this.f_réalisation = f_réalisation;
		this.livraison_prestataire = livraison_prestataire;
		this.d_recette = d_recette;
		this.f_recette = f_recette;

	}

	// getters &Setters

	public String getId() {
		return idProject;
	}

	public void setId(String id) {

		this.idProject = id;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getLibélé() {
		return libélé;
	}

	public void setLibélé(String libélé) {
		this.libélé = libélé;
	}

	public int getEnjeux() {
		return enjeux;
	}

	public void setEnjeux(int enjeux) {
		this.enjeux = enjeux;
	}

	public int getPriorité() {
		return priorité;
	}

	public void setPriorité(int priorité) {
		this.priorité = priorité;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	public int getTypeDA() {
		return typeDA;
	}

	public void setTypeDA(int typeDA) {
		this.typeDA = typeDA;
	}

	public int getReliquat() {
		return reliquat;
	}

	public void setReliquat(int reliquat) {
		this.reliquat = reliquat;
	}

	public Date getD_étude() {
		return d_étude;
	}

	public void setD_étude(Date d_étude) {
		this.d_étude = d_étude;
	}

	public Date getF_étude() {
		return f_étude;
	}

	public void setF_étude(Date f_étude) {
		this.f_étude = f_étude;
	}

	public Date getD_réalisation() {
		return d_réalisation;
	}

	public void setD_réalisation(Date d_réalisation) {
		this.d_réalisation = d_réalisation;
	}

	public Date getF_réalisation() {
		return f_réalisation;
	}

	public void setF_réalisation(Date f_réalisation) {
		this.f_réalisation = f_réalisation;
	}

	public Date getLivraison_prestataire() {
		return livraison_prestataire;
	}

	public void setLivraison_prestataire(Date livraison_prestataire) {
		this.livraison_prestataire = livraison_prestataire;
	}

	public Date getD_recette() {
		return d_recette;
	}

	public void setD_recette(Date d_recette) {
		this.d_recette = d_recette;
	}

	public String getLancerMetier() {
		return lancerMetier;
	}

	public String getLC() {
		return LC;
	}

	public void setLC(String lC) {
		LC = lC;
	}

	public void setLancerMetier(String lancerMetier) {
		this.lancerMetier = lancerMetier;
	}

	public Date getF_recette() {
		return f_recette;
	}

	public void setF_recette(Date f_recette) {
		this.f_recette = f_recette;
	}

	/*
	 * public List<User> getUsers() { return users; }
	 * 
	 * public void setUsers(List<User> users) { this.users = users; }
	 */

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

	public Date getD_étudePres() {
		return d_étudePres;
	}

	public void setD_étudePres(Date d_étudePres) {
		this.d_étudePres = d_étudePres;
	}

	public Date getF_étudePres() {
		return f_étudePres;
	}

	public void setF_étudePres(Date f_étudePres) {
		this.f_étudePres = f_étudePres;
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

	public Date getD_étude_R() {
		return d_étude_R;
	}

	public void setD_étude_R(Date d_étude_R) {
		this.d_étude_R = d_étude_R;
	}

	public Date getF_étude_R() {
		return f_étude_R;
	}

	public void setF_étude_R(Date f_étude_R) {
		this.f_étude_R = f_étude_R;
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

	public Date getD_étudePres_R() {
		return d_étudePres_R;
	}

	public void setD_étudePres_R(Date d_étudePres_R) {
		this.d_étudePres_R = d_étudePres_R;
	}

	public Date getF_étudePres_R() {
		return f_étudePres_R;
	}

	public void setF_étudePres_R(Date f_étudePres_R) {
		this.f_étudePres_R = f_étudePres_R;
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

	public List<ProjectUser> getProjectUser() {
		return projectUser;
	}

	public void setProjectUser(List<ProjectUser> projectUser) {
		this.projectUser = projectUser;
	}

	public Date getD_réceptionDA() {
		return d_réceptionDA;
	}

	public void setD_réceptionDA(Date d_réceptionDA) {
		this.d_réceptionDA = d_réceptionDA;
	}

	public void main(String[] args) {
		Date date = new Date();

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		// get current date time with Date()

		System.out.println(dateFormat.format(date));

		char[] idyear = new char[3];
		char[] year = new char[5];
		char[] day = new char[3];
		char[] month = new char[3];
		char[] id1 = new char[6];
		String nbprojet;
		int n = 15;

		try {
			dateFormat.format(date).getChars(2, 4, idyear, 0);
			dateFormat.format(date).getChars(0, 4, year, 0);
			dateFormat.format(date).getChars(5, 7, month, 0);
			dateFormat.format(date).getChars(8, 10, day, 0);

			// initialisation de l'id à 000
			for (int i = 0; i < id1.length; i++) {
				id1[i] = '0';
			}
			System.out.println(id1);
			nbprojet = "" + n++;

			// ajout de l'année
			for (int i = 0; i < 2; i++) {
				id1[i] = idyear[i];
			}

			nbprojet = "" + n++;// incrémentation du nbr de projet
			// affectation du nbr de projet à l'id
			int j = 0;
			for (int i = nbprojet.toCharArray().length - 1; i >= 0; i--) {

				id1[id1.length - 1 - j] = nbprojet.toCharArray()[i];
				j++;
			}

			System.out.println("le nouvel id ");
			System.out.println(id1);

		} catch (Exception ex) {
			System.out.println("Raised exception...");
		}

	}

	public int getApp() {
		return app;
	}

	public void setApp(int app) {
		this.app = app;
	}

	public int getEntite() {
		return entite;
	}

	public void setEntite(int entite) {
		this.entite = entite;
	}

	public String getDescription() {
		return descriptionProjet;
	}

	public void setDescription(String description) {
		descriptionProjet = description;
	}

	public int getMOA() {
		return MOA;
	}

	public void setMOA(int mOA) {
		MOA = mOA;
	}

	public int getChefP() {
		return chefP;
	}

	public void setChefP(int chefP) {
		this.chefP = chefP;
	}

	public int getSpons() {
		return spons;
	}

	public void setSpons(int spons) {
		this.spons = spons;
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

	public HistoriqueProjet getHistoriqueP() {
		return historiqueP;
	}

	public void setHistoriqueP(HistoriqueProjet historiqueP) {
		this.historiqueP = historiqueP;
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

	public Date getD_réalisation_R() {
		return d_réalisation_R;
	}

	public void setD_réalisation_R(Date d_réalisation_R) {
		this.d_réalisation_R = d_réalisation_R;
	}

	public Date getF_réalisation_R() {
		return f_réalisation_R;
	}

	public void setF_réalisation_R(Date f_réalisation_R) {
		this.f_réalisation_R = f_réalisation_R;
	}

	
	
	
	
}
