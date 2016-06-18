package ubci.app.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ubci.app.persistence.Project;
import ubci.app.persistence.User;

@Stateless
public class UserService implements UserServiceLocal,UserServiceRemote {

	private List<User> users = new ArrayList<User>();

	@PersistenceContext
	private   EntityManager em;
	
	@Override

	public void createUser(User u) {
		
		em.persist(u);
	}

	@Override

	public void saveOrUpdateUser(User u) {
		
		em.merge(u);
	}
@Override
	public User findUserById(int id) {
		
		return em.find(User.class, id);
	}


@Override

	public void removeUser(User u) {
		
		em.remove(em.merge(u));

	}
	@Override

	public  List<User> findAllUser() {
		
		String jpql = "select q from User q ";

		Query query = em.createQuery(jpql);

		List<User> a =query.getResultList();
		
		
	
		System.out.println("\n******service********");
		for( int i=0; i<a.size();i++)
		{
			System.out.println(i);
			System.out.println(a.get(i).getLogin());
		}
//	  User user= new User();
//	  ListIterator itr = a.listIterator();
//		//Iterator<User> iterator = a.iterator();
//        while (itr.hasNext()) {
//        	//Object element=iterator.next();
//        	        	
//            user=(User)itr.next();
//            System.out.println(user.getLogin());
//            
//        }
	  // Get the Enumeration object
//      Enumeration<User> e = Collections.enumeration(a);
// 
//      // Enumerate through the ArrayList elements
//      System.out.println("ArrayList elements: ");
//      while(e.hasMoreElements())
//      System.out.println(e.nextElement());
//   
		return a;
	}

	@Override
	public boolean findUserByLoginAndPass(String log, String pass) {
		

		String jpql = "select q from User q where login = '"+log+"' and password = '"+pass+"' ";

		Query query = em.createQuery(jpql);

		List<User> a =query.getResultList();
		
		if(a!= null || a.size()>=0){
			return true;
		}else{
			return false;
		}
	
	}

	
	

}
