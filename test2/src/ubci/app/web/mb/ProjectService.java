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
	private String lib�l� = "";
	private String nomMOA = "";
	private String nomSponsor = "";
	private String nomChefP = "";

	private String p, e, s, da, r,entit�,app;
	private String lancerMetier = "";
	private String lc = "";
	
	
	
	//getters & Setters
	
	public String getLib�l�() {
		return lib�l�;
	}
	public void setLib�l�(String lib�l�) {
		this.lib�l� = lib�l�;
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
