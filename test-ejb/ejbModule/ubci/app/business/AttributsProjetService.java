package ubci.app.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ubci.app.persistence.Application;
import ubci.app.persistence.Enjeux;
import ubci.app.persistence.Entité;
import ubci.app.persistence.Priorité;
import ubci.app.persistence.Reliquat;
import ubci.app.persistence.Statut;
import ubci.app.persistence.Type_DA;

@Stateless

public class AttributsProjetService implements AttributsProjetServiceLocal, AttributsProjetServiceRemote
{


	@PersistenceContext
	private EntityManager em;
	
	
	public AttributsProjetService()
	{}
	
	// Entité 
			public void createEntité(Entité app) {
				System.out.println("avant persist");

				em.persist(app);
				System.out.println("ajout :)");
			}

			public void saveOrUpdateEntité(Entité app) {
				em.merge(app);
			}

			public Entité findEntitéById(int id) {
				return em.find(Entité.class, id);
			}

			public void removeEntité(Entité app) {
				em.remove(em.merge(app));
			}

			public List<Entité> findAllEntité() {
		String jpql = "select q from Entité q ";
				
				Query query = em.createQuery(jpql);
			
				List<Entité> a = query.getResultList();
				
				return a;
			}
	
	// Application 
		public void createApplication(Application app) {
			System.out.println("avant persist");

			em.persist(app);
			System.out.println("ajout :)");
		}

		public void saveOrUpdateApplication(Application app) {
			em.merge(app);
		}

		public Application findApplicationById(int id) {
			return em.find(Application.class, id);
		}

		public void removeApplication(Application app) {
			em.remove(em.merge(app));
		}

		public List<Application> findAllApplication() {
	String jpql = "select q from Application q ";
			
			Query query = em.createQuery(jpql);
		
			List<Application> a = query.getResultList();
			
			return a;
		}
	// enjeux 
	public void createEnjeux(Enjeux enjeux) {
		System.out.println("avant persist");

		em.persist(enjeux);
		System.out.println("ajout :)");
	}

	public void saveOrUpdateEnjeux(Enjeux enjeux) {
		em.merge(enjeux);
	}

	public Enjeux findEnjeuxById(int id) {
		return em.find(Enjeux.class, id);
	}

	public void removeEnjeux(Enjeux enjeux) {
		em.remove(em.merge(enjeux));
	}

	public List<Enjeux> findAllEnjeux() {
String jpql = "select q from Enjeux q ";
		
		Query query = em.createQuery(jpql);
	
		List<Enjeux> a = query.getResultList();
		
		return a;
	}
	
	//priorité
	
	public void createPriorité(Priorité p) {
		em.persist(p);
	}

	public void saveOrUpdatePriorité(Priorité p) {
		em.merge(p);
	}

	public Priorité findPrioritéById(int id) {
		return em.find(Priorité.class, id);
	}

	public void removePriorité(Priorité p) {
		em.remove(em.merge(p));
	}

	public List<Priorité> findAllPriorité() {
		//return em.createQuery("select p from priorité p").getResultList();
String jpql = "select q from Priorité q ";
		
		Query query = em.createQuery(jpql);
	System.out.println("creation Query ");
		List<Priorité> a = query.getResultList();
		System.out.println("Result LIst  ");
		
		return a;
	}
	
	//priorité
	
		public void createReliquat(Reliquat r) {
			em.persist(r);
		}

		public void saveOrUpdateReliquat(Reliquat r) {
			em.merge(r);
		}

		public Reliquat findReliquatById(int id) {
			return em.find(Reliquat.class, id);
		}

		public void removeReliquat(Reliquat r) {
			em.remove(em.merge(r));
		}

		public List<Reliquat> findAllReliquat() {
			//return em.createQuery("select p from Reliquat p").getResultList();
	String jpql = "select q from Reliquat q ";
			
			Query query = em.createQuery(jpql);
		System.out.println("creation Query ");
			List<Reliquat> a = query.getResultList();
			System.out.println("Result LIst  ");
			
			return a;
		}
		
	
	//statut
	
	public void createStatut(Statut s) {
		em.persist(s);
	}

	public void saveOrUpdateStatut(Statut s) {
		em.merge(s);
	}

	public Statut findStatutById(int id) {
		return em.find(Statut.class, id);
	}

	public void removeStatut(Statut s) {
		em.remove(em.merge(s));
	}

	public List<Statut> findAllStatut() {
		return em.createQuery("select p from Statut p").getResultList();
	}
	
	
	//Type_DA
	public void createType_DA(Type_DA t) {
		em.persist(t);
	}

	public void saveOrUpdateType_DA(Type_DA t) {
		em.merge(t);
	}

	public Type_DA findType_DAById(int id) {
		return em.find(Type_DA.class, id);
	}

	public void removeType_DA(Type_DA t) {
		em.remove(em.merge(t));
	}

	public List<Type_DA> findAllType_DA() {
		return em.createQuery("select p from Type_DA p").getResultList();
	}
	
}
