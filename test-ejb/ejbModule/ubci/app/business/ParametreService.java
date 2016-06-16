package ubci.app.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ubci.app.persistence.Entité;
import ubci.app.persistence.Parametre;
import ubci.app.persistence.TypeP;


@Stateless
public class ParametreService  implements ParametreLocal,ParametreRemote{
	
	@PersistenceContext
	private EntityManager em;
	
	public void createParameter(Parametre app) {
		em.persist(app);
		
	}
	

	public  void saveOrUpdateParameter(Parametre app) {
		em.merge(app);
	 }

	public  Parametre findParameterById(int id) {
		return em.find(Parametre.class, id);
	}

	public  void removeParameter(Parametre app) 
	{
		em.remove(em.merge(app));
	}
	

	public  List<Parametre> findAllParameter() {
		String jpql = "select q from Parametre q ";
		
		Query query = em.createQuery(jpql);
	
		List<Parametre> a = query.getResultList();
		
		return a;
	 }
	@Override
	public  List<Parametre> findSpecificType(int type ) {
	List <Parametre> parms=null;
	String jpql = "select q from Parametre q where q.type =:x";
	
	Query query = em.createQuery(jpql);

	query.setParameter("x", type);
	 parms = query.getResultList();
	
	return parms;
 }


	@Override
		public  List<Parametre> findSpecificType(TypeP type ) {
		List <Parametre> parms=null;
		String jpql = "select q from Parametre q where q.type =:x";
		
		Query query = em.createQuery(jpql);
	
		query.setParameter("x", type);
		 parms = query.getResultList();
		
		return parms;
	 }
	
	
	public void createTypeP(TypeP app)
	{
		em.persist(app);
	}

	public void saveOrUpdateTypeP(TypeP app)
	{
		em.merge(app);
	}

	public TypeP findTypePById(int id)
	{
		return em.find(TypeP.class, id);
	}

	public void removeTypeP(TypeP app)
	{
		em.remove(em.merge(app));
	}

	public List<TypeP> findAllTypeP()
	{
		String jpql = "select q from TypeP q ";
		
		Query query = em.createQuery(jpql);
	
		List<TypeP> a = query.getResultList();
		
		return a;
	}
}
	


