package ubci.app.business;

import java.util.List;

import javax.ejb.Remote;

import ubci.app.persistence.Enjeux;
import ubci.app.persistence.Priorit�;
import ubci.app.persistence.Reliquat;
import ubci.app.persistence.Statut;
import ubci.app.persistence.Type_DA;

@Remote
public interface AttributsProjetServiceRemote {


	void createEnjeux(Enjeux enjeux);
	void saveOrUpdateEnjeux(Enjeux enjeux);
	Enjeux findEnjeuxById(int id);
	void removeEnjeux(Enjeux enjeux);
	List<Enjeux> findAllEnjeux();
	
	//Priorit�
	void createPriorit�(Priorit� s);
	void saveOrUpdatePriorit�(Priorit� p);
	Priorit� findPriorit�ById(int id);
	void removePriorit�(Priorit� p);
	List<Priorit�> findAllPriorit�();
	
	//Reliquat
	void createReliquat(Reliquat s);
	void saveOrUpdateReliquat(Reliquat p);
	Reliquat findReliquatById(int id);
	void removeReliquat(Reliquat p);
	List<Reliquat> findAllReliquat();
	
	
	//Statut
	void createStatut(Statut s);
	void saveOrUpdateStatut(Statut s);
	Statut findStatutById(int id);
	void removeStatut(Statut s);
	List<Statut> findAllStatut();
	
	
	//TypeDA
	void createType_DA(Type_DA t);
	void saveOrUpdateType_DA(Type_DA t);
	Type_DA findType_DAById(int id);
	void removeType_DA(Type_DA t);
	List<Type_DA> findAllType_DA();
	
}
