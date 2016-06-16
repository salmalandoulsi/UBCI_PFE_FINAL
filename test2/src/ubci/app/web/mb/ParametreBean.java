package ubci.app.web.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ubci.app.business.AttributsProjetServiceLocal;
import ubci.app.business.ParametreLocal;
import ubci.app.persistence.Parametre;
import ubci.app.persistence.TypeP;

@ManagedBean(name = "paramBean")
@ViewScoped
public class ParametreBean implements Serializable {
	private static final long serialVersionUID = -9040274036031665311L;
	
	@EJB
	private ParametreLocal param;
	
	private List<Parametre> parametres = new ArrayList<Parametre>();
	private List<Parametre> parameterType = new ArrayList<Parametre>();
	private List<TypeP> typeParams = new ArrayList<TypeP>();
	private List<String> typeParam = new ArrayList<String>();

	
	
	private String selectedTypeP=new String();

	
	private int id_type;
	private String libélé;
	private String type_param;

	
	
	
	
	public String getLibélé() {
		return libélé;
	}

	public void setLibélé(String libélé) {
		this.libélé = libélé;
	}

	public ParametreBean() {
		super();
	}
	
	@PostConstruct
	public void init() {
		parametres= param.findAllParameter();
	//parameterType= param.findSpecificType(id_type);
		typeParams= param.findAllTypeP();
		for(int i=0 ;i<typeParams.size();i++)
		{
			
			//System.out.println(typeParams.get(i).toString());
			typeParam.add( typeParams.get(i).getLibélé());
		}
	}
	public void CreateType_Param()
	{
		TypeP typeP= new TypeP(type_param);
		param.createTypeP(typeP);
	}
	public void CreatePrarameter()
	{
		Parametre p= new Parametre(libélé, RechercheType());
		param.createParameter(p);
			
	}
	public void submit()
	
	{System.out.println("******début submit *******");
	try{
		parameterType= param.findSpecificType(RechercheType());
	}catch(Exception ex)
	{
		System.out.println("*erreuur *");
	}
		System.out.println("******fin submit*******");
		
	}

	
	public TypeP RechercheType()
	{
		System.out.println("******recherche*******");
		TypeP t= new TypeP();
		System.out.println("selectedTypeP   "+selectedTypeP);
		System.out.println("******début recherche*******");

	for(int i=0; i<=9;i++)

		{		System.out.println("** i="+i);

		System.out.println("typeParams  "+typeParams.get(i).getLibélé());
		
			if(selectedTypeP.equals(typeParams.get(i).getLibélé()))
			{
			return t=typeParams.get(i);
			 
			
			}
			
		}
		return t;
		
	}
	
	
	public int RechercheType_ID()
	{
		System.out.println("******recherche*******");
		int id=0;
		System.out.println("selectedTypeP"+selectedTypeP);
	
	for(int i=1; i<=typeParams.size();i++)
		
		{
		System.out.println("typeParams"+typeParams.get(i).getLibélé());
		
			if(selectedTypeP.equals(typeParams.get(i).getLibélé()))
			{id=i;
			System.out.println("******selection *******id ="+id);
			 
			
			}
			
		}
		return id;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
		
	}
	//getters/Setters
	
	
	
	public List<Parametre> getParametres() {
		return parametres;
	}

	
	public List<String> getTypeParam() {
		return typeParam;
	}

	public void setTypeParam(List<String> typeParam) {
		this.typeParam = typeParam;
	}

	

	public String getSelectedTypeP() {
		return selectedTypeP;
	}

	public void setSelectedTypeP(String selectedTypeP) {
		this.selectedTypeP = selectedTypeP;
	}

	public List<TypeP> getTypeParams() {
		return typeParams;
	}

	public void setTypeParams(List<TypeP> typeParams) {
		this.typeParams = typeParams;
	}

	public void setParametres(List<Parametre> parametres) {
		this.parametres = parametres;
	}

	public List<Parametre> getParameterType() {
		return parameterType;
	}

	public void setParameterType(List<Parametre> parameterType) {
		this.parameterType = parameterType;
	}

	public int getId_type() {
		return id_type;
	}

	public void setId_type(int id_type) {
		this.id_type = id_type;
	}

	public String getType_param() {
		return type_param;
	}

	public void setType_param(String type_param) {
		this.type_param = type_param;
	}
	
	
	
	
}
