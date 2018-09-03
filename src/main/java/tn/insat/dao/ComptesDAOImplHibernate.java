package tn.insat.dao;

// Generated 22 ao�t 2014 14:50:44 by Hibernate Tools 4.0.0

import java.util.List;





import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import tn.insat.entities.Compte;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Comptes.
 * @see tn.insat.entities.Compte
 * @author Hibernate Tools
 */
public class ComptesDAOImplHibernate implements ComptesDAO {

	private static final Log log = LogFactory.getLog(ComptesDAOImplHibernate.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			//return (SessionFactory) new InitialContext()
			//		.lookup("SessionFactory");
			
			// Get the Configuration
			Configuration configuration = new Configuration().configure();
			
			// Set Up a Service Registry (Hibernate 4)
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).build();            
            
			// Build a Session factory
		    return configuration.buildSessionFactory(serviceRegistry);
		   
			
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	/* (non-Javadoc)
	 * @see be.businesstraining.dao.ComptesDAO#persist(be.businesstraining.entities.Comptes)
	 */
	@Override
	public void persist(Compte transientInstance) {
		log.debug("persisting Comptes instance");
		try {
			sessionFactory.getCurrentSession().getTransaction().begin();
			sessionFactory.getCurrentSession().persist(transientInstance);
			sessionFactory.getCurrentSession().getTransaction().commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see be.businesstraining.dao.ComptesDAO#attachDirty(be.businesstraining.entities.Comptes)
	 */
	@Override
	public void attachDirty(Compte instance) {
		log.debug("attaching dirty Comptes instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see be.businesstraining.dao.ComptesDAO#attachClean(be.businesstraining.entities.Comptes)
	 */
	@Override
	public void attachClean(Compte instance) {
		log.debug("attaching clean Comptes instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see be.businesstraining.dao.ComptesDAO#delete(be.businesstraining.entities.Comptes)
	 */
	@Override
	public void delete(Compte persistentInstance) {
		log.debug("deleting Comptes instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see be.businesstraining.dao.ComptesDAO#merge(be.businesstraining.entities.Comptes)
	 */
	@Override
	public Compte merge(Compte detachedInstance) {
		log.debug("merging Comptes instance");
		try {
			Compte result = (Compte) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see be.businesstraining.dao.ComptesDAO#findById(java.lang.String)
	 */
	@Override
	public Compte findById(java.lang.String id) {
		log.debug("getting Comptes instance with id: " + id);
		try {
			Compte instance = (Compte) sessionFactory.openSession().
					get("be.businesstraining.entities.Compte", id);
			if (instance == null) {
				log.info("get successful, no instance found");
			} else {
				log.info("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see be.businesstraining.dao.ComptesDAO#findByExample(be.businesstraining.entities.Comptes)
	 */
	@Override
	public List<Compte> findByExample(Compte instance) {
		log.debug("finding Comptes instance by example");
		try {
			List<Compte> results = (List<Compte>) sessionFactory
					.getCurrentSession()
					.createCriteria("be.businesstraining.entities.Comptes")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
