package org.csc480.bgclub.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/** Hibernate tools
 * 
 * @author kenb
 *
 */
public class HibernateUtil { 
    private static final SessionFactory sessionFactory;
    
	
    static { 
        try { 

        	sessionFactory =  new AnnotationConfiguration().configure().buildSessionFactory();  
        	
        } catch (Throwable ex) { 
            // Make sure you log the exception, as it might be swallowed 
            System.err.println("Initial SessionFactory creation failed." + ex); 
            throw new ExceptionInInitializerError(ex); 
        } 
    } 
    
    /** Get the session factory
     * 
     * @return session factory
     */
    public static SessionFactory getSessionFactory() { 
        return sessionFactory; 
    } 

    /** Get the session
     * 
     * @return session factory
     */
    public static Session getCurrentSession() { 
        return sessionFactory.getCurrentSession();
    } 
}
