package ubci.app.web.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import ubci.app.business.AttributsProjetServiceLocal;
import ubci.app.persistence.Enjeux;

 
@ManagedBean(name="dtEditView")
@ViewScoped
public class EditView implements Serializable {
     
	/**
	 * 
	 */
	private static final long serialVersionUID = 8220058037837405154L;
	@EJB
	private AttributsProjetServiceLocal attributService;
	
	  public void setAttributService(AttributsProjetServiceLocal attributService) {
		this.attributService = attributService;
	}

	
//    private List<Enjeux> cars1;
	private List<Enjeux> cars1 = new ArrayList<Enjeux>();

  
    @PostConstruct
    public void init() {
        cars1 = attributService.findAllEnjeux();
        //cars2 = service.createCars(10);
    }
 
    
    
    public String deleteEnjeux(Enjeux e) {
	    System.out.println("****début suppression");
    	attributService.removeEnjeux(e);
    	String navigateTo =null;
		 navigateTo = "EditView.xhtml?faces-redirect=true";
		 System.out.println("redirection effectuée  " );
		 return navigateTo;
    	
    }
    
    public List<Enjeux> getCars1() {
        return cars1;
    }
 
//    public List<Car> getCars2() {
//        return cars2;
//    }
     
    
    public List<String> getBrands() {
    	
    	List<String> libailles= new ArrayList<String>();
    	for( int i=0; i<cars1.size();i++)
		{

			String lib = cars1.get(i).getLibélé();
			libailles.add(lib);

		}
        return libailles;
    }
     
//    public List<String> getColors() {
//        return service.getColors();
//    }
 
   
     
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Car Selected", ""+((Enjeux) event.getObject()).getId()+" newlib" +((Enjeux) event.getObject()).getLibélé());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        Enjeux nouveauEnjeux=new Enjeux();
        nouveauEnjeux.setId(((Enjeux) event.getObject()).getId());
        nouveauEnjeux.setLibélé(((Enjeux) event.getObject()).getLibélé());
        attributService.saveOrUpdateEnjeux(nouveauEnjeux);
        
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Car Canceled", ""+((Enjeux) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}