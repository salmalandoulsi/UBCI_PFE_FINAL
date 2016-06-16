package ubci.app.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ubci.app.persistence.Prestataire;

@Stateless
public class PrestataireService implements PrestataireServiceLocal,
		PrestataireServiceRemote {
	private List<Prestataire> prestataires = new ArrayList<Prestataire>();

	@PersistenceContext
	private EntityManager em;

	public void createPrestataire(Prestataire p) {
		em.persist(p);
	}

	public void saveOrUpdatePrestataire(Prestataire p) {
		em.merge(p);
	}

	public Prestataire findPrestataireById(int id) {
		return em.find(Prestataire.class, id);

	}

	public void removePrestataire(Prestataire p) {
		em.remove(em.merge(p));

	}

	public List<Prestataire> findAllPrestataire() {
		String jpql = "select q from Prestataire q ";

		Query query = em.createQuery(jpql);

		List<Prestataire> a = query.getResultList();
		return a;
	}
}
