package ubci.app.web.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ubci.app.persistence.Project;

@ManagedBean(name = "projectService")
@ViewScoped
public class ProjectService {
	private String id="";
	private String libélé = "";
	private String nomMOA = "";
	private String nomSponsor = "";
	private String nomChefP = "";

	private String p, e, s, da, r,entité,app;
	private String lancerMetier = "";
	private String lc = "";
	
	
	
	//getters & Setters
	
	public String getLibélé() {
		return libélé;
	}
	public void setLibélé(String libélé) {
		this.libélé = libélé;
	}
	
	public String getNomMOA() {
		return nomMOA;
	}
	public void setNomMOA(String nomMOA) {
		this.nomMOA = nomMOA;
	}
	public String getNomSponsor() {
		return nomSponsor;
	}
	public void setNomSponsor(String nomSponsor) {
		this.nomSponsor = nomSponsor;
	}
	public String getNomChefP() {
		return nomChefP;
	}
	public void setNomChefP(String nomChefP) {
		this.nomChefP = nomChefP;
	}
	public String getP() {
		return p;
	}
	public void setP(String p) {
		this.p = p;
	}
	public String getE() {
		return e;
	}
	public void setE(String e) {
		this.e = e;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public String getDa() {
		return da;
	}
	public void setDa(String da) {
		this.da = da;
	}
	public String getR() {
		return r;
	}
	public void setR(String r) {
		this.r = r;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	

}
