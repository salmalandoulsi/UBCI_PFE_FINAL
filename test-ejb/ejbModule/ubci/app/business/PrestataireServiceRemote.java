package ubci.app.business;

import java.util.List;

import ubci.app.persistence.Prestataire;

public interface PrestataireServiceRemote {
	
	void createPrestataire(Prestataire p);
	void saveOrUpdatePrestataire(Prestataire p);
	Prestataire findPrestataireById(int id);
	void removePrestataire(Prestataire p);
	List<Prestataire> findAllPrestataire();

}
