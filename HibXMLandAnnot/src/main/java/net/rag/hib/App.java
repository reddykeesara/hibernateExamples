package net.rag.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import net.rag.hib.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

//		// Create typesafe ServiceRegistry object
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();


//	//replacement code for above 
//		SessionFactory sf = new Configuration().configure().buildSessionFactory();
//		Session session = sf.openSession();
//		Transaction tx = session.beginTransaction();

//		Employee e1 = new Employee();
//		// e1.setId(101);
//		e1.setFirstName("raghun");
//		e1.setLastName("redddy");
//		e1.setCreatedDate(new Date(new java.util.Date().getTime()));
//		e1.setUpdatedDate(new Date(new java.util.Date().getTime()));
//
//		EmployeeDetail ed = new EmployeeDetail();
//		ed.setCity("hyd");
//		ed.setSal(250000);
//		ed.setTech("python");
//		ed.setEmployee(e1);
//
//		e1.setEmployeeDetail(ed);
//		// d1.setEmployee(e1);
//
//		saveItem(e1);

		
		Customer customer = new Customer();
		customer.setCustName("rag");
		customer.setCity("hyd");
		
	//	Item item = new Item();
	//	item.setItemName("item2");
	//	item.setItemCost(3000);
	//	item.setCustomer(customer);
		
	//	saveItem(item);
		
		//tx.commit();
		System.out.println("successfully saved");
		//session.close();
		//sf.close();

	}
	
	
    public static <T> void saveItem(T item) {
        
        SessionFactory factory = HibernateUtil.getInstnce();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(item);
        tx.commit();
        session.close();
    }
}

class ManytoMany2{
	
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		
		Group groupAdmin = new Group();
		groupAdmin.setGroupName("Administrator Group");
        Group groupGuest = new Group();
        groupGuest.setGroupName("Guest Group");
        User user1 = new User("Tom", "tomcat", "tom@codejava.net");
        User user2 = new User("Mary", "mary", "mary@codejava.net");
         
        groupAdmin.addUser(user1);
        groupAdmin.addUser(user2);
         
        groupGuest.addUser(user1);
         
        user1.addGroup(groupAdmin);        
        user2.addGroup(groupAdmin);
        user1.addGroup(groupGuest);
         
        HibernateUtil.saveItems(groupAdmin, groupGuest);
        //HibernateUtil.saveItem(user1,user2);
         System.out.println("Saved successfully ");
      
	}

}