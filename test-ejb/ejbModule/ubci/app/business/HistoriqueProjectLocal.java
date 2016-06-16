package ubci.app.business;

import java.util.List;

import javax.ejb.Local;

import ubci.app.persistence.Entité;
import ubci.app.persistence.HistoriqueProjet;

@Local
public interface HistoriqueProjectLocal {
	
	void createHistorique(HistoriqueProjet app) ;

	 void saveOrUpdateHistorique(HistoriqueProjet app) ;

	 HistoriqueProjet findHistoriqueById(String id) ;

	 void removeHistorique(HistoriqueProjet app) ;

	 List<HistoriqueProjet> findAllHistorique() ;

}
