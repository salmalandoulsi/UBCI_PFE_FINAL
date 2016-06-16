package ubci.app.web.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CheckboxView {

	private String[] selectedCities;
	private List<String> cities;
	private Boolean reference = true;
	private Boolean entite = true;
	private Boolean chefP = true;
	private Boolean sponsor = true;
	private Boolean type_da = true;
	private Boolean reliquat = true;
	private Boolean priorite = true;
	private Boolean chefMOA = true;
	private Boolean app = true;
	private Boolean statut = true;
	private Boolean lc = true;
	private Boolean enjeux = true;

	private Boolean lanceMetier = true;

	@PostConstruct
	public void init() {
		reference = true;
		entite = true;
		chefP = true;
		sponsor = true;
		type_da = true;
		reliquat = true;
		priorite = true;
		chefMOA = true;
		app = true;
		statut = true;
		lc = true;
		enjeux = true;
		lanceMetier = true;

		cities = new ArrayList<String>();
		cities.add("Reference DA");
		cities.add("Entite");
		cities.add("LancerMetier");
		cities.add("Chef de Projet MOA");
		cities.add("Sponsor");
		cities.add("Reliquat");
		cities.add("Enjeux");
		cities.add("Priorite");
		cities.add("Type_DA");
		cities.add("Chef de Projet");
		cities.add("Local/Central");
		cities.add("Application");

	}

	public void Recherche() {
		System.out.println("initialisation recherche");
		reference = false;
		entite = false;
		chefP = false;
		sponsor = false;
		type_da = false;
		reliquat = false;
		priorite = false;
		chefMOA = false;
		app = false;
		statut = false;
		lc = false;
		lanceMetier = false;

		int i = 0;

		for (i = 0; i < selectedCities.length; i++) {

			if (selectedCities[i].equals("Application") == true) {
				app = true;
			}
			if (selectedCities[i].equals("Chef de Projet MOA") == true) {
				chefMOA = true;
			}
			if (selectedCities[i].equals("Type_DA") == true) {
				type_da = true;
			}
			if (selectedCities[i].equals("Priorite") == true) {
				priorite = true;
			}
			if (selectedCities[i].equals("LancerMetier") == true) {
				lanceMetier = true;
			}
			if (selectedCities[i].equals("Local/Central") == true) {
				lc = true;
			}
			if (selectedCities[i].equals("Statut") == true) {
				statut = true;
			}
			if (selectedCities[i].equals("Enejeux") == true) {
				enjeux=true;
			}
			if (selectedCities[i].equals("Reference DA") == true) {
				reference = true;

			}
			if (selectedCities[i].equals("Entite") == true) {
				entite = true;
			}
			if (selectedCities[i].equals("Sponsor") == true) {
				sponsor = true;
			}
			if (selectedCities[i].equals("Chef de Projet") == true) {
				chefP = true;
			}

		}
		System.out.println("référence=" + reference);
		System.out.println("sponsor=" + sponsor);
		System.out.println("chefP=" + chefP);
		System.out.println("entité=" + entite);
	}

	public String[] getSelectedCities() {
		return selectedCities;
	}

	public void setSelectedCities(String[] selectedCities) {
		this.selectedCities = selectedCities;
	}

	public List<String> getCities() {
		return cities;
	}

	public Boolean getRéférence() {
		return reference;
	}

	public void setRéférence(Boolean référence) {
		this.reference = référence;
	}

	public Boolean getEntité() {
		return entite;
	}

	public void setEntité(Boolean entité) {
		this.entite = entité;
	}

	public Boolean getSponsor() {
		return sponsor;
	}

	public void setSponsor(Boolean sponsor) {
		this.sponsor = sponsor;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	public Boolean getChefP() {
		return chefP;
	}

	public void setChefP(Boolean chefP) {
		this.chefP = chefP;
	}

	public Boolean getType_da() {
		return type_da;
	}

	public void setType_da(Boolean type_da) {
		this.type_da = type_da;
	}

	public Boolean getReliquat() {
		return reliquat;
	}

	public void setReliquat(Boolean reliquat) {
		this.reliquat = reliquat;
	}

	public Boolean getPriorité() {
		return priorite;
	}

	public void setPriorité(Boolean priorité) {
		this.priorite = priorité;
	}

	public Boolean getChefMOA() {
		return chefMOA;
	}

	public void setChefMOA(Boolean chefMOA) {
		this.chefMOA = chefMOA;
	}

	public Boolean getApp() {
		return app;
	}

	public void setApp(Boolean app) {
		this.app = app;
	}

	public Boolean getStatut() {
		return statut;
	}

	public void setStatut(Boolean statut) {
		this.statut = statut;
	}

	public Boolean getLc() {
		return lc;
	}

	public void setLc(Boolean lc) {
		this.lc = lc;
	}

	public Boolean getLanceMetier() {
		return lanceMetier;
	}

	public void setLanceMetier(Boolean lanceMetier) {
		this.lanceMetier = lanceMetier;
	}

	public Boolean getEnjeux() {
		return enjeux;
	}

	public void setEnjeux(Boolean enjeux) {
		this.enjeux = enjeux;
	}

}