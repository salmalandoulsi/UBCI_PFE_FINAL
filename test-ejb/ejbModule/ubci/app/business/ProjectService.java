package ubci.app.business;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ubci.app.persistence.Enjeux;
import ubci.app.persistence.Priorité;
import ubci.app.persistence.Project;
import ubci.app.persistence.ProjectPrestataire;
import ubci.app.persistence.ProjectPrestataireID;
import ubci.app.persistence.Statut;
import ubci.app.persistence.Type_DA;
import ubci.app.persistence.User;

@Stateless
public class ProjectService implements ProjectServiceLocal,
		ProjectServiceRemote {

	@PersistenceContext
	private   EntityManager em;
	
	private List<Project> projects = new ArrayList<Project>();


	public ProjectService() {
		super();
	}
	@Override
public void createProjetPrestataire(String idproject, int idprestataire, String référence)
{
	ProjectPrestataireID ppID= new ProjectPrestataireID();
	ppID.setIdPrestataire(idprestataire);
	ppID.setIdProject(idproject);
	
	
	ProjectPrestataire p = new ProjectPrestataire(ppID);
	p.setRéférence(référence);
	em.merge(p);
	
	
}

	
@Override
	public void createProject(Project p) {
	

		
		em.persist(p);


	}
@Override
	public void saveOrUpdateProject(Project p) {
		em.merge(p);

	}
@Override
	public Project findProjectById(String id) {
	String jpql = "select q from Project q where q.idProject =:x";
	Query query = em.createQuery(jpql);
	query.setParameter("x", id);
	Project p = (Project) query.getSingleResult();
	System.out.println("*********");
	return p;
	// em.find(users.class, id);
	
		//return em.find(Project.class, id);
	}
@Override
	public void removeProject(Project p) {

		em.remove(em.merge(p));
	}
@Override
	public List<Project> findAllProject() {
System.out.println("début find all Projects");
		String jpql = "select q from Project q ";

		Query query = em.createQuery(jpql);
		System.out.println("list");

		List<Project> a = query.getResultList();
		System.out.println("envoie list ****");

		return a;
	}


}
