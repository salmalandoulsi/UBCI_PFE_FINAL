package ubci.app.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ubci.app.persistence.Entité;
import ubci.app.persistence.HistoriqueProjet;
import ubci.app.persistence.Project;

@Stateless
public class HistoriqueProjectService implements HistoriqueProjectLocal, HistoriqueProjectRemote {

	@PersistenceContext
	private   EntityManager em;
	
	private List<Project> projects = new ArrayList<Project>();
	@Override
	public void createHistorique(HistoriqueProjet h) 
	{
		em.persist(h);
	}

	public  void saveOrUpdateHistorique(HistoriqueProjet p) {
		
		em.merge(p);
	}

	 public HistoriqueProjet findHistoriqueById(String id) {
		 String jpql = "select q from HistoriqueProjet q where q.id =:x";
			Query query = em.createQuery(jpql);
			query.setParameter("x", id);
			HistoriqueProjet p = (HistoriqueProjet) query.getSingleResult();
			System.out.println("*********");
			return p;
	 }

	 public void removeHistorique(HistoriqueProjet h) 
	 {
		 em.remove(em.merge(h));
	 }

	public  List<HistoriqueProjet> findAllHistorique() 
	{
		String jpql = "select q from Project q ";

		Query query = em.createQuery(jpql);
		

		List<HistoriqueProjet> a = query.getResultList();
		

		return a;
	}


}
