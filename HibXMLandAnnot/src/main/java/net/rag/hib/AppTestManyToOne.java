package net.rag.hib;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import net.rag.hib.model.Address;
import net.rag.hib.model.Order;
import net.rag.hib.util.HibernateUtil;

public class AppTestManyToOne {

	public static void main(String[] args) {

		/*		@OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
				private Set<Order> orders = new HashSet();
				
				@ManyToOne(cascade = CascadeType.ALL)
				@JoinColumn(name="addId")
				Address address;*/
		
		/*
				Address address = new Address();
				address.setCity("blore");
				address.setZipCode(600000);
		
				Order order = new Order();
				order.setName("annn");
				order.setAddress(address);
		
				Order order2 = new Order();
				order2.setName("parrr");
				order2.setAddress(address);
		
				saveItem(order);
				saveItem(order2);*/

		/*		sselect * from address2;
		+-------+-------+--------+
		| addId | city  | zip    |
		+-------+-------+--------+
		|     1 | blore | 600000 |
		+-------+-------+--------+
		1 row in set (0.00 sec)
		
		mysql> select * from order2;
		+---------+-------+-------+
		| orderId | name  | addId |
		+---------+-------+-------+
		|       1 | annn  |     1 |
		|       2 | parrr |     1 |
		+---------+-------+-------+ 
		*/

		/*		Hibernate: create table address2 (addId integer not null auto_increment, city varchar(255), zip integer, primary key (addId)) engine=MyISAM
				Hibernate: create table order2 (orderId integer not null auto_increment, name varchar(255), addId integer, primary key (orderId)) engine=MyISAM
				Hibernate: alter table order2 add constraint FKt8825samcs6id89jrhd986ru7 foreign key (addId) references address2 (addId)
				Hibernate: insert into address2 (city, zip) values (?, ?)
				Hibernate: insert into order2 (addId, name) values (?, ?)
				Hibernate: insert into order2 (addId, name) values (?, ?)
				Hibernate: update address2 set city=?, zip=? where addId=?*/

		/*******************************************************************************************************************/

		/*		
		@OneToMany( cascade = CascadeType.ALL)
		private Set<Order> orders = new HashSet();
		
		@ManyToOne
		Address address;*/

		/*		Address address = new Address();
				address.setCity("blore");
				address.setZipCode(600000);
		
				Order order = new Order();
				order.setName("annn");
		
				Order order2 = new Order();
				order2.setName("parrr");
				
				address.addOrders(order);
				address.addOrders(order2);
		
				saveItem(address);
				*/
		/*		 select * from address2;
				 +-------+-------+--------+
				 | addId | city  | zip    |
				 +-------+-------+--------+
				 |     1 | blore | 600000 |
				 +-------+-------+--------+
		
				 mysql> select * from order2;
				 +---------+-------+---------------+
				 | orderId | name  | address_addId |
				 +---------+-------+---------------+
				 |       1 | parrr |          NULL |
				 |       2 | annn  |          NULL |
				 +---------+-------+---------------+
		
				 mysql> select * from address2_order2;
				 +---------------+----------------+
				 | Address_addId | orders_orderId |
				 +---------------+----------------+
				 |             1 |              1 |
				 |             1 |              2 |
				 +---------------+----------------+*/
		
		/*******************************************************************************************************************/
		
		/*		@OneToMany( cascade = CascadeType.ALL)
				@JoinColumn(name="addId")
				private Set<Order> orders = new HashSet();
				
				@ManyToOne//(cascade = CascadeType.ALL)
				@JoinColumn(name="addId")
				Address address;*/
		
		Address address = new Address();
		address.setCity("blore");
		address.setZipCode(600000);

		Order order = new Order();
		order.setName("annn");

		Order order2 = new Order();
		order2.setName("parrr");
		
		address.addOrders(order);
		address.addOrders(order2);

		saveItem(address);
		
		/*		select * from address2;
				+-------+-------+--------+
				| addId | city  | zip    |
				+-------+-------+--------+
				|     1 | blore | 600000 |
				+-------+-------+--------+
		
				mysql> select * from order2;
				+---------+-------+-------+
				| orderId | name  | addId |
				+---------+-------+-------+
				|       1 | parrr |     1 |
				|       2 | annn  |     1 |
				+---------+-------+-------+
				2 rows in set (0.00 sec)*/
		
		/*		Hibernate: create table address2 (addId integer not null auto_increment, city varchar(255), zip integer, primary key (addId)) engine=MyISAM
				Hibernate: create table order2 (orderId integer not null auto_increment, name varchar(255), addId integer, primary key (orderId)) engine=MyISAM
				Hibernate: alter table order2 add constraint FKt8825samcs6id89jrhd986ru7 foreign key (addId) references address2 (addId)
				Hibernate: insert into address2 (city, zip) values (?, ?)
				Hibernate: insert into order2 (addId, name) values (?, ?)
				Hibernate: insert into order2 (addId, name) values (?, ?)
				Hibernate: update order2 set addId=? where orderId=?
				Hibernate: update order2 set addId=? where orderId=?*/

	}

	public static <T> void saveItem(T item) {

		SessionFactory factory = HibernateUtil.getInstnce();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(item);
		tx.commit();
		session.close();
		System.out.println("Saved Successfully ");
	}

}
