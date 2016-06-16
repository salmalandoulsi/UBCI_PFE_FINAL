package ubci.app.business;

import java.util.List;

import javax.ejb.Remote;

import ubci.app.persistence.Revision_Budget_Prestataire;
import ubci.app.persistence.R�vision_Budget_Projet;
import ubci.app.persistence.User;

@Remote
public interface BudgetServiceRemote {
	
	void createRevision_Budget_Prestataire(Revision_Budget_Prestataire u);
	void saveOrUpdateRevision_Budget_Prestataire(Revision_Budget_Prestataire u);
	Revision_Budget_Prestataire findRevision_Budget_PrestataireById(int id);
	void removeRevision_Budget_Prestataire(Revision_Budget_Prestataire u);
	List<Revision_Budget_Prestataire> findAllRevision_Budget_Prestataire();

	//R�vision_Budget_Projet
	
		void createR�vision_Budget_Projet(R�vision_Budget_Projet u);
		void saveOrUpdateR�vision_Budget_Projet(R�vision_Budget_Projet u);
		R�vision_Budget_Projet findR�vision_Budget_ProjetById(int id);
		void removeR�vision_Budget_Projet(R�vision_Budget_Projet u);
		List<R�vision_Budget_Projet> findAllR�vision_Budget_Projet();


}
