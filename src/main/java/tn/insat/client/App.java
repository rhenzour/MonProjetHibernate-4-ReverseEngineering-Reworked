package tn.insat.client;

import java.math.BigDecimal;

import tn.insat.dao.ComptesDAO;
import tn.insat.dao.ComptesDAOImplHibernate;
import tn.insat.entities.Compte;


public class App 
{
    public static void main( String[] args )
    {
       
    	// Utilisation des services de Hibernate à travers un DAO
    	
    	ComptesDAO  dao = new ComptesDAOImplHibernate();
    	
    //	test_Persist(dao);
    	test_FindById(dao);
    	
    	
    }

	private static void test_Persist(ComptesDAO dao) {
		
		dao.persist(new Compte("A1200", "James Gosling", new BigDecimal(1100)));
		System.out.println("Création réussie !");
	}

	private static void test_FindById(ComptesDAO dao) {
		Compte c = dao.findById("A1200");
    	
    	if (c == null)
    	{
    		System.out.println(" Le compte A1200 n'existe pas !");
    	}else
    	{
    	 System.out.println(" Détails du  compte A1100  : " + c);
    	}
	}
}
