package ubci.app.business;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.Query;

import ubci.app.persistence.Application;
import ubci.app.persistence.Enjeux;
import ubci.app.persistence.Entité;
import ubci.app.persistence.Priorité;
import ubci.app.persistence.Reliquat;
import ubci.app.persistence.Statut;
import ubci.app.persistence.Type_DA;

@Local
public interface AttributsProjetServiceLocal {
	// Entité
	void createEntité(Entité app) ;

	 void saveOrUpdateEntité(Entité app) ;

	 Entité findEntitéById(int id) ;

	 void removeEntité(Entité app) ;

	 List<Entité> findAllEntité() ;

	// Application
	void createApplication(Application app);

	void saveOrUpdateApplication(Application app);

	Application findApplicationById(int id);

	void removeApplication(Application app);

	List<Application> findAllApplication();

	// Enjeux
	void createEnjeux(Enjeux enjeux);

	void saveOrUpdateEnjeux(Enjeux enjeux);

	Enjeux findEnjeuxById(int id);

	void removeEnjeux(Enjeux enjeux);

	List<Enjeux> findAllEnjeux();

	// Priorité
	void createPriorité(Priorité s);

	void saveOrUpdatePriorité(Priorité p);

	Priorité findPrioritéById(int id);

	void removePriorité(Priorité p);

	List<Priorité> findAllPriorité();

	// Reliquat
	void createReliquat(Reliquat s);

	void saveOrUpdateReliquat(Reliquat p);

	Reliquat findReliquatById(int id);

	void removeReliquat(Reliquat p);

	List<Reliquat> findAllReliquat();

	// Statut
	void createStatut(Statut s);

	void saveOrUpdateStatut(Statut s);

	Statut findStatutById(int id);

	void removeStatut(Statut s);

	List<Statut> findAllStatut();

	// TypeDA
	void createType_DA(Type_DA t);

	void saveOrUpdateType_DA(Type_DA t);

	Type_DA findType_DAById(int id);

	void removeType_DA(Type_DA t);

	List<Type_DA> findAllType_DA();

}
