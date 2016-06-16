package ubci.app.test;

import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.w3c.dom.Attr;

import ubci.app.business.AttributsProjetService;
import ubci.app.business.AttributsProjetServiceLocal;
import ubci.app.persistence.Enjeux;

public class Test {

	@PersistenceContext
	static  EntityManager em;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("**********");
		
		
			em.createQuery("select p from enjeux p");
	
}}