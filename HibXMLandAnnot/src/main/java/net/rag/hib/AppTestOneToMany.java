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

import net.rag.hib.model.Cart;
import net.rag.hib.model.Item;
import net.rag.hib.util.HibernateUtil;

public class AppTestOneToMany {

	public static void main(String[] args) {
		//one to many 
		
		/*		
		 		@OneToMany(cascade = CascadeType.ALL)
				@JoinColumn(name = "cartId")
				Set<Item> items = new HashSet<Item>();
				
				@ManyToOne
				private Cart cart;
		*/
		
		/*Cart cart1 = new Cart();
		
		Item item1 = new Item("mobile",25000);
		Item item2 = new Item("tv",50000);
		cart1.addItem(item1);
		cart1.addItem(item2);
		
		saveItem(cart1);*/
		
		/*		select * from cart;
				+--------+
				| cartId |
				+--------+
				|      1 |
				+--------+
				1 row in set (0.06 sec)
		
				mysql> select * from item;
				+--------+----------+----------+-------------+--------+
				| itemId | itemCost | itemName | cart_cartId | cartId |
				+--------+----------+----------+-------------+--------+
				|      1 |    50000 | tv       |        NULL |      1 |
				|      2 |    25000 | mobile   |        NULL |      1 |
				+--------+----------+----------+-------------+--------+*/
/********************************************************************************************************/		
		//one to many 
		
				/*		
				 		@OneToMany(cascade = CascadeType.ALL)
						Set<Item> items = new HashSet<Item>();
						
						@ManyToOne
						private Cart cart;
				*/
				
				/*				Cart cart1 = new Cart();
				
								Item item1 = new Item("mobile",25000);
								Item item2 = new Item("tv",50000);
								cart1.addItem(item1);
								cart1.addItem(item2);
								
								saveItem(cart1);*/
				
				
				/*select * from cart;
				+--------+
				| cartId |
				+--------+
				|      1 |
				+--------+

				mysql> select * from item;
				+--------+----------+----------+-------------+
				| itemId | itemCost | itemName | cart_cartId |
				+--------+----------+----------+-------------+
				|      1 |    50000 | tv       |        NULL |
				|      2 |    25000 | mobile   |        NULL |
				+--------+----------+----------+-------------+

				mysql> select * from cart_item;
				+-------------+--------------+
				| Cart_cartId | items_itemId |
				+-------------+--------------+
				|           1 |            1 |
				|           1 |            2 |
				+-------------+--------------+*/
				
/********************************************************************************************************/		

		//Many to One
		
		/*		@OneToMany(mappedBy = "cart")
				Set<Item> items = new HashSet<Item>();
				
				@ManyToOne(cascade = CascadeType.ALL)
				@JoinColumn(name="cartId", nullable = false)
				private Cart cart
		*/
		
		/*		Cart cart1 = new Cart();
		
				Item item1 = new Item("phone",25000);
				item1.setCart(cart1);
				Item item2 = new Item("washing machine",50000);
				item2.setCart(cart1);
				
				
				saveItem(item1);
				saveItem(item2);*/
		
		
		/*		select * from item;
				+--------+----------+-----------------+--------+
				| itemId | itemCost | itemName        | cartId |
				+--------+----------+-----------------+--------+
				|      1 |    25000 | phone           |      1 |
				|      2 |    50000 | washing machine |      1 |
				+--------+----------+-----------------+--------+
				2 rows in set (0.11 sec)
		
				mysql> select * from cart;
				+--------+
				| cartId |
				+--------+
				|      1 |
				+--------+*/
		
		/*		Hibernate: create table cart (cartId bigint not null auto_increment, primary key (cartId)) engine=MyISAM
				Hibernate: create table item (itemId integer not null auto_increment, itemCost integer not null, itemName varchar(255), cartId bigint not null, primary key (itemId)) engine=MyISAM
				Hibernate: alter table item add constraint FKn7rx6uavct84taruihter1x80 foreign key (cartId) references cart (cartId)
				Hibernate: insert into cart values ( )
				Hibernate: insert into item (cartId, itemCost, itemName) values (?, ?, ?)
				Hibernate: insert into item (cartId, itemCost, itemName) values (?, ?, ?)*/

		/********************************************************************************************************/		
		
		/*		@OneToMany(mappedBy = "cart")
				Set<Item> items = new HashSet<Item>();
				
				@ManyToOne(cascade = CascadeType.ALL)
				private Cart cart;	*/
		
				Cart cart1 = new Cart();
		
				Item item1 = new Item("phone",25000);
				item1.setCart(cart1);
				Item item2 = new Item("washing machine",50000);
				item2.setCart(cart1);
				
				
				saveItem(item1);
				saveItem(item2);
		
		/*		select * from cart;
				+--------+
				| cartId |
				+--------+
				|      1 |
				+--------+
		
				mysql> select * from item;
				+--------+----------+-----------------+-------------+
				| itemId | itemCost | itemName        | cart_cartId |
				+--------+----------+-----------------+-------------+
				|      1 |    25000 | phone           |           1 |
				|      2 |    50000 | washing machine |           1 |
				+--------+----------+-----------------+-------------+*/
				
		/********************************************************************************************************/		

		
	}

	public static <T> void saveItem(T item, T item2) {

		SessionFactory factory = HibernateUtil.getInstnce();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(item);
		session.save(item2);
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
		System.out.println("saved successfully");
	}

}
