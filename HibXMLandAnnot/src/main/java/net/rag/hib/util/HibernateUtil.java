package net.rag.hib.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private HibernateUtil() {

    }
    private static SessionFactory sessionFactory;

    public static synchronized SessionFactory getInstnce() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;

    }
    
	public static <T> void saveItem(T item) {

		SessionFactory factory = HibernateUtil.getInstnce();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(item);
		tx.commit();
		session.close();
	}
	
	public static <T> void saveItems(T item1, T item2) {

		SessionFactory factory = HibernateUtil.getInstnce();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(item1);
		session.save(item2);
		tx.commit();
		session.close();
	}
}
