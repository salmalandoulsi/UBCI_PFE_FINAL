package ubci.app.web.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ubci.app.business.AttributsProjetServiceLocal;
import ubci.app.persistence.Enjeux;

public class tesst {

	
	@EJB
	static AttributsProjetServiceLocal auth ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	
		
		
	  List<Enjeux> enj = new ArrayList<Enjeux>();
	  System.out.println("**********");
			enj = auth.findAllEnjeux();
			System.out.println("**********");
			for ( int i=0; i<enj.size(); i++)
			{
			System.out.println(	enj.get(i).getLibélé());
			}

	
		

	}

}
