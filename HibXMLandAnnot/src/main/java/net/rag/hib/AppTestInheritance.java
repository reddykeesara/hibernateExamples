package net.rag.hib;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.DiscriminatorFormula;

import net.rag.hib.model.inherit.Animal;
import net.rag.hib.model.inherit.Book;
import net.rag.hib.model.inherit.Bus;
import net.rag.hib.model.inherit.Car;
import net.rag.hib.model.inherit.MyEmployee;
import net.rag.hib.model.inherit.Pen;
import net.rag.hib.model.inherit.Person;
import net.rag.hib.model.inherit.Pet;
import net.rag.hib.model.inherit.Stationery;
import net.rag.hib.model.inherit.Vehicle;
import net.rag.hib.util.HibernateUtil;

public class AppTestInheritance {

	public static void main(String[] args) {
		
		//@MappedSuperClass example using Person and MyEmployee.. 
		//Person is superclass mapped with @mappedsuperclass..
		//we save child class MyEmployee
		//if we are using this inheritance strategy , anscestors cant contain associations with other entities

		/*		
				MyEmployee myemp = new MyEmployee(0l,"person1","comp1");
				MyEmployee myemp2 = new MyEmployee(0l,"person2","comp2");
				saveItem(myemp);
				saveItem(myemp2);
		*/		
		
//		select * from myemployee;
//		+----------+---------+---------+
//		| personId | name    | company |
//		+----------+---------+---------+
//		|        1 | person1 | comp1   |
//		|        2 | person2 | comp2   |
//		+----------+---------+---------+
		
		/*********************************************************************************************/
		
		//Single Table Strategy
		//JPA chooses this strategy by default if we dont specify any
		//This strategy creates one ?? for each class hierarchy..
		// no discriminators used 
		//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) .. used creates only stationery table

		/*		Book book = new Book(0l,"book1","author1");
				Pen pen = new Pen(0l,"pen1","red");
				saveItem(book);
				saveItem(pen);*/
		
		
//		select * from stationery;
//		+-------+-----------+-------+---------+-------+
//		| DTYPE | productId | name  | author  | color |
//		+-------+-----------+-------+---------+-------+
//		| Book  |         1 | book1 | author1 | NULL  |
//		| Pen   |         2 | pen1  | NULL    | red   |
//		+-------+-----------+-------+---------+-------+
		
		//table per class strategy
		//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS).. while using this change generatedValue strategy to GenerationType.AUTO
		
		/*		Book book = new Book(0l,"book1","author1");
				Pen pen = new Pen(0l,"pen1","red");
				saveItem(book);
				saveItem(pen);
				
				Stationery st = new Stationery(0l, "stationery");
				saveItem(st);*/
		
//		select * from book;
//		+-----------+-------+---------+
//		| productId | name  | author  |
//		+-----------+-------+---------+
//		|         1 | book1 | author1 |
//		+-----------+-------+---------+
//		1 row in set (0.01 sec)
//
//		mysql> select * from pen;
//		+-----------+------+-------+
//		| productId | name | color |
//		+-----------+------+-------+
//		|         2 | pen1 | red   |
//		+-----------+------+-------+
//
//		select * from stationery;
//		+-----------+------------+
//		| productId | name       |
//		+-----------+------------+
//		|         3 | stationery |
//		+-----------+------------+
		
		/*********************************************************************************************/
		
		//Using Discriminator.. after adding below annot to myproduct
		//@DiscriminatorColumn(name="productType", discriminatorType = DiscriminatorType.INTEGER)
		//and @discriminatorValue("1"),2 to subclasses
		
		/*		Book book = new Book(0l,"book1","author1");
				Pen pen = new Pen(0l,"pen1","red");
				saveItem(book);
				saveItem(pen);*/

		
//		result
//		select * from stationery;
//		+-------------+-----------+-------+---------+-------+
//		| productType | productId | name  | author  | color |
//		+-------------+-----------+-------+---------+-------+
//		|           1 |         1 | book1 | author1 | NULL  |
//		|           2 |         2 | pen1  | NULL    | red   |
//		+-------------+-----------+-------+---------+-------+
		
		/*********************************************************************************************/
		
//		table per class
//		@GeneratedValue(strategy = GenerationType.IDENTITY) is not working for this strategy use .AUTO
//		three tables created for each class
		
//		Vehicle veh = new Vehicle(0l,"jaguar");
//		Car car = new Car(0l,"benz",5);
//		Bus bus = new Bus(0l,"volvo",50);
//		saveItem(veh);
//		saveItem(car);
//		saveItem(bus);
		
//		result ?????????		
//		select * from bus;
//		+-----------+--------------+-----------+
//		| vehicleId | manufacturer | noOfSeats |
//		+-----------+--------------+-----------+
//		|         3 | volvo        |        50 |
//		+-----------+--------------+-----------+
//
//		mysql> select * from car;
//		+-----------+--------------+-----------+
//		| vehicleId | manufacturer | noOfSeats |
//		+-----------+--------------+-----------+
//		|         2 | benz         |         5 |
//		+-----------+--------------+-----------+
//
//		mysql> select * from vehicle;
//		+-----------+--------------+
//		| vehicleId | manufacturer |
//		+-----------+--------------+
//		|         1 | jaguar       |
//		+-----------+--------------+
		
		
		/*********************************************************************************************/
		//add @DiscriminatorFormula("case when author is not null then '1' else '2' end")
		//remove @DiscriminatorColumn(name="productType", discriminatorType = DiscriminatorType.INTEGER)
		//from stationery class
		//this strategy has adv of polymorphic query performance since only one table needs to be accessed
		// when querying parent entities.
		//we can no longer use NOT NULL constraints ono subclass entity properties
		
//		Book book = new Book(0l,"book1","author1");
//		Pen pen = new Pen(0l,"pen1","red");
//		saveItem(book);
//		saveItem(pen);
		
		//not working as expected.. no extra column created
//		 select * from stationery;
//		 +-----------+-------+---------+-------+
//		 | productId | name  | author  | color |
//		 +-----------+-------+---------+-------+
//		 |         1 | book1 | author1 | NULL  |
//		 |         2 | pen1  | NULL    | red   |
//		 +-----------+-------+---------+-------+
		
		/*********************************************************************************************/
		//Joined table
//		@Inheritance(strategy = InheritanceType.JOINED)
//		public class Animal
//		@PrimaryKeyJoinColumn(name = "petId")
//		public class Pet extends Animal 
		
//		Pet pet = new Pet(0l,"dog","pupppy");
//		saveItem(pet);
		
//		select * from animal;
//		+----------+---------+
//		| animalId | species |
//		+----------+---------+
//		|        1 | dog     |
//		+----------+---------+
//		1 row in set (0.06 sec)
//
//		mysql> select * from pet;
//		+--------+-------+
//		| name   | petId |
//		+--------+-------+
//		| pupppy |     1 |
//		+--------+-------+
		
		
	}
	

	public static <T> void saveItem(T item) {

		SessionFactory factory = HibernateUtil.getInstnce();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(item);
		System.out.println("Saved Sucessfully ");
		tx.commit();
		session.close();
	}
}
