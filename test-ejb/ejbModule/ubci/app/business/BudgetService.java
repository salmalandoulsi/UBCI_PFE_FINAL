package ubci.app.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ubci.app.persistence.Revision_Budget_Prestataire;
import ubci.app.persistence.Révision_Budget_Projet;
import ubci.app.persistence.User;
@Stateless
public class BudgetService
	implements BudgetServiceLocal,BudgetServiceRemote {

		

		@PersistenceContext
		private   EntityManager em;
		
		@Override

		public void createRévision_Budget_Projet(Révision_Budget_Projet u) {
			
			em.persist(u);
		}

		@Override

		public void saveOrUpdateRévision_Budget_Projet(Révision_Budget_Projet u) {
			
			em.merge(u);
		}
	@Override
		public Révision_Budget_Projet findRévision_Budget_ProjetById(int id) {
			
			return em.find(Révision_Budget_Projet.class, id);
		}


	@Override

		public void removeRévision_Budget_Projet(Révision_Budget_Projet u) {
			
			em.remove(em.merge(u));

		}
		@Override

		public  List<Révision_Budget_Projet> findAllRévision_Budget_Projet() {
			
			String jpql = "select q from User Révision_Budget_Projet ";

			Query query = em.createQuery(jpql);

			List<Révision_Budget_Projet> a =query.getResultList();
			

		
		
   
			return a;
		}

		
		@Override

		public void createRevision_Budget_Prestataire(Revision_Budget_Prestataire u) {
			
			em.persist(u);
		}

		@Override

		public void saveOrUpdateRevision_Budget_Prestataire(Revision_Budget_Prestataire u) {
			
			em.merge(u);
		}
	@Override
		public Revision_Budget_Prestataire findRevision_Budget_PrestataireById(int id) {
			
			return em.find(Revision_Budget_Prestataire.class, id);
		}


	@Override

		public void removeRevision_Budget_Prestataire(Revision_Budget_Prestataire u) {
			
			em.remove(em.merge(u));

		}
		@Override

		public  List<Revision_Budget_Prestataire> findAllRevision_Budget_Prestataire() {
			
			String jpql = "select q from User Revision_Budget_Prestataire ";

			Query query = em.createQuery(jpql);

			List<Revision_Budget_Prestataire> a =query.getResultList();
			

		
		
   
			return a;
		}

		

}
