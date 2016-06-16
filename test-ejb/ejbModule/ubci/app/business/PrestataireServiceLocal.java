package ubci.app.business;

import java.util.List;

import javax.ejb.Local;

import ubci.app.persistence.Prestataire;

@Local
public interface PrestataireServiceLocal {
	
	void createPrestataire(Prestataire p);
	void saveOrUpdatePrestataire(Prestataire p);
	Prestataire findPrestataireById(int id);
	void removePrestataire(Prestataire p);
	List<Prestataire> findAllPrestataire();

}
