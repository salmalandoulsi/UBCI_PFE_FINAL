package ubci.app.business;

import java.util.List;

import javax.ejb.Remote;

import ubci.app.persistence.Revision_Budget_Prestataire;
import ubci.app.persistence.Révision_Budget_Projet;
import ubci.app.persistence.User;

@Remote
public interface BudgetServiceRemote {
	
	void createRevision_Budget_Prestataire(Revision_Budget_Prestataire u);
	void saveOrUpdateRevision_Budget_Prestataire(Revision_Budget_Prestataire u);
	Revision_Budget_Prestataire findRevision_Budget_PrestataireById(int id);
	void removeRevision_Budget_Prestataire(Revision_Budget_Prestataire u);
	List<Revision_Budget_Prestataire> findAllRevision_Budget_Prestataire();

	//Révision_Budget_Projet
	
		void createRévision_Budget_Projet(Révision_Budget_Projet u);
		void saveOrUpdateRévision_Budget_Projet(Révision_Budget_Projet u);
		Révision_Budget_Projet findRévision_Budget_ProjetById(int id);
		void removeRévision_Budget_Projet(Révision_Budget_Projet u);
		List<Révision_Budget_Projet> findAllRévision_Budget_Projet();


}
