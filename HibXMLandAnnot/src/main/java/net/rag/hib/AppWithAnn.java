package net.rag.hib;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import net.rag.hib.model.Address;
import net.rag.hib.model.Cart;
import net.rag.hib.model.Course;
import net.rag.hib.model.CourseRating;
import net.rag.hib.model.Empl;
import net.rag.hib.model.EmplDetl;
import net.rag.hib.model.Employee;
import net.rag.hib.model.EmployeeDetail;
import net.rag.hib.model.Item;
import net.rag.hib.model.Order;
import net.rag.hib.model.Project;
import net.rag.hib.model.Student;
import net.rag.hib.model.Workstation;
import net.rag.hib.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class AppWithAnn {
	public static void main(String[] args) {

//		// Create typesafe ServiceRegistry object
//		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
//		
//		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//
//		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

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

		Address add = new Address();
		add.setCity("blore");
		add.setZipCode(500000);

		Order order = new Order();
		order.setName("ann");
		order.setAddress(add);

		Order order2 = new Order();
		order2.setName("parr");
		order2.setAddress(add);

		add.addOrders(order);
		add.addOrders(order2);

		saveItem(add);

		// saveItem(student2);

		// tx.commit();
		System.out.println("successfully saved");
		// session.close();
		// sf.close();

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

class ManyToOneAnnot {
	public static void main(String[] args) {
		Address add = new Address();
		add.setCity("blore");
		add.setZipCode(600000);

		Order order = new Order();
		order.setName("annn");
		order.setAddress(add);

		Order order2 = new Order();
		order2.setName("parrr");
		order2.setAddress(add);

		add.addOrders(order);
		add.addOrders(order2);
		saveItem(add);
		System.out.println("saved successfully ");

		// saveItem(order);
		// saveItem(order2);

		// saveItem(student2);

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

class OneToOneAnn {
	public static void main(String[] args) {

		// ONE TO ONE WITH A FOREIGN KEY
		Empl empl = new Empl();
		empl.setName("ragkkk");
		
		//Workstation ws = new Workstation();
		//ws.setName("Delll");
		//ws.setEmpl(empl);

		EmplDetl ed = new EmplDetl();
		ed.setCity("delhi");
		ed.setSal(100000);
		ed.setTech("ssql");

		//ed.setEmpl(empl);
		empl.setEmplDetl(ed);
		saveItem(empl);

		//empl.setEmplDetl(ed);
		//empl.setWorkstation(ws);
		//saveItem(empl);

		// ONE TO ONE WITH A JOIN TABLE
//		Workstation ws = new Workstation();
//		ws.setName("Dell");
//		empl.setWorkstation(ws);
//		
//		Workstation ws2 = new Workstation();
//		ws2.setName("hp");
//		//empl.setWorkstation(ws2);
//		
//		saveItem(empl);
//		saveItem(ws2);

		// fetch code
//		 SessionFactory factory = HibernateUtil.getInstnce();
//	        Session session = factory.openSession();
//	        Transaction tx = session.beginTransaction();
//	        Empl empl = (Empl) session.get(Empl.class,3);
//	      System.out.println(empl.getEmplDetl().getTech());
//	      empl.getEmplDetl().setTech("sqll");
//	        tx.commit();
//	        session.close();

		System.out.println("saved Successfully");
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

class ManytoManyAnn {

	public static void main(String[] args) {
		// SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Employee emp = new Employee();
		emp.setName("rag");
		EmployeeDetail empdet1 = new EmployeeDetail();
		empdet1.setCity("chennai");
		empdet1.setSal(100000);
		empdet1.setTech("goovy");
		// emp.setEmployeeDetail(empdet1);

		Employee emp2 = new Employee();
		emp2.setName("mohh");
		EmployeeDetail empdet2 = new EmployeeDetail();
		empdet2.setCity("chennai");
		empdet2.setSal(100000);
		empdet2.setTech("goovy");
		// emp.setEmployeeDetail(empdet2);

		Project project = new Project();
		project.setProjName("US proj");

		Project project2 = new Project();
		project2.setProjName("UK proj");

		Project project3 = new Project();
		project3.setProjName("local proj");

		// emp.addProject(project);

		// emp2.addProject(project2);
		// emp2.addProject(project3);

		project3.addEmployee(emp2);

		saveItem(emp, emp2);

//		Group groupAdmin = new Group();
//		groupAdmin.setGroupName("Administrator Group");
//        Group groupGuest = new Group();
//        groupGuest.setGroupName("Guest Group");
//        User user1 = new User("Tom", "tomcat", "tom@codejava.net");
//        User user2 = new User("Mary", "mary", "mary@codejava.net");
//         
//        groupAdmin.addUser(user1);
//        groupAdmin.addUser(user2);
//         
//        groupGuest.addUser(user1);
//         
//        user1.addGroup(groupAdmin);        
//        user2.addGroup(groupAdmin);
//        user1.addGroup(groupGuest);
//         
//        HibernateUtil.saveItems(groupAdmin, groupGuest);
//        //HibernateUtil.saveItem(user1,user2);

		System.out.println("Saved successfully ");

	}

	public static <T> void saveItem(T item, T item2) {

		SessionFactory factory = HibernateUtil.getInstnce();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(item);
		session.save(item2);
		tx.commit();
		session.close();
	}

}

class oneToMany {

	public static void main(String[] args) {
		Cart cart1 = new Cart();
		Cart cart2 = new Cart();

		Item item1 = new Item();
		item1.setCart(cart1);
		Item item2 = new Item();
		item2.setCart(cart2);
		//Item item3 = new Item();
		//item3.setCart(cart2);
		
		saveItem(item1);
		saveItem(item2);

		//cart1.addItem(item1);
		//cart1.addItem(item2);
		//saveItem(cart1);
		


		System.out.println("saved successfully");

	}

	public static <T> void saveItem(T item, T item2) {

		SessionFactory factory = HibernateUtil.getInstnce();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(item);
		session.save(item2);
		tx.commit();
		session.close();
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

class Many2Many {
	public static void main(String[] args) {

//		Student stud = new Student();
//		stud.setName("aaa");
//
//		Student stud2 = new Student();
//		stud2.setName("bbb");
//
//		Student stud3 = new Student();
//		stud3.setName("33333");
//		
//		
//		Course course = new Course();
//		course.setCourseName("java");
//		course.addStudent(stud);
//
//		Course course2 = new Course();
//		course2.setCourseName("c++");
//		course2.addStudent(stud2);
//
//		Course course3 = new Course();
//		course3.setCourseName("python");
//		course3.addStudent(stud2);
//
//		Course course4 = new Course();
//		course4.setCourseName("C");
//		course4.addStudent(stud3);
//		stud3.addCourse(course4);
	//	stud.addCourse(course);
	//	stud.addCourse(course2);

	//	stud2.addCourse(course3);
	//	stud2.addCourse(course4);

		//course.addStudent(stud);
		//course.addStudent(stud2);

		//MANY TO MANY WITH COMPOSITE KEY
		Student studR = new Student("ragg");
		Student studM = new Student("Mohh");
		Student studA = new Student("Ann");
		Course courseJ = new Course("Java");
		Course courseC = new Course("C");
		Course courseP = new Course("php");
		
		CourseRating cr = new CourseRating(studR, courseJ);
		CourseRating cr2 = new CourseRating(studM, courseC);
		CourseRating cr3 = new CourseRating(studM, courseJ);
		CourseRating cr4 = new CourseRating(studA, courseP);
		
		
		
		
		
		
		SessionFactory factory = HibernateUtil.getInstnce();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
	//	session.save(stud);
	//	session.save(stud2);
//		session.save(course);
//		session.save(course2);
//		session.save(course3);
		session.save(cr);
		session.save(cr2);
		session.save(cr3);
		session.save(cr4);
		
		tx.commit();
		session.close();
		System.out.println("saved successfully");

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