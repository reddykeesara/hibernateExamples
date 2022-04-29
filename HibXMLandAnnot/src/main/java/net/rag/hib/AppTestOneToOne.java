package net.rag.hib;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import net.rag.hib.model.Empl;
import net.rag.hib.model.EmplDetl;
import net.rag.hib.model.Workstation;
import net.rag.hib.util.HibernateUtil;

public class AppTestOneToOne {

	public static void main(String[] args) {

		/*        ONE TO ONE WITH A FOREIGN KEY
		
		 		@OneToOne ( cascade = CascadeType.ALL)
				@JoinColumn(name="detId", referencedColumnName = "emplDtlId")
				EmplDetl emplDetl;
		
				@OneToOne
				@JoinColumn(name="emplDtlId", referencedColumnName = "empId")
				Empl empl;		
		
				@Id																		
				@GeneratedValue(strategy = GenerationType.IDENTITY)   //on both models
		
				by using above mappings no extra column created in emplDetl table
		*/

		/*		Empl empl = new Empl(0,"Ragg");
				EmplDetl ed = new EmplDetl(0,"Java","hyd",250000);
		
				empl.setEmplDetl(ed);
				saveItem(empl);
		*/

		/*		select * from emplDetl;
				+-----------+------+--------+------+
				| emplDtlId | city | sal    | tech |
				+-----------+------+--------+------+
				|         2 | hyd  | 250000 | Java |
				+-----------+------+--------+------+
		
				mysql> select * from empl;
				+-------+------+-------+
				| empId | name | detId |
				+-------+------+-------+
				|     1 | Ragg |     2 |
				+-------+------+-------+
		*/

		/*		Hibernate: create table empl (empId integer not null auto_increment, name varchar(255), detId integer, primary key (empId)) engine=MyISAM
				Hibernate: create table emplDetl (emplDtlId integer not null auto_increment, city varchar(255), sal integer not null, tech varchar(255), primary key (emplDtlId)) engine=MyISAM
				Hibernate: alter table empl add constraint FKcitr3jmld6ib6kt99vf3n6g79 foreign key (detId) references emplDetl (emplDtlId)
				Hibernate: insert into emplDetl (city, sal, tech) values (?, ?, ?)
				Hibernate: insert into empl (detId, name) values (?, ?)
				saved Successfully*/

		/******************************************************************************************************/

		/*        ONE TO ONE WITH A SHARED PRIMARY KEY
		
				@OneToOne (mappedBy = "empl", cascade = CascadeType.ALL) 
				@PrimaryKeyJoinColumn
				EmplDetl emplDetl;
		
				@OneToOne
				@MapsId
				@JoinColumn(name = "empId")
				Empl empl;		
		
				@Id																		
				@GeneratedValue(strategy = GenerationType.IDENTITY)   //on both models
		*/
		
		Empl empl = new Empl(0, "Ragg");
		EmplDetl ed = new EmplDetl(0, "Java", "hyd", 250000);

		ed.setEmpl(empl);
		empl.setEmplDetl(ed);
		saveItem(empl);

		// here we need to set emp to empldtl and empldtl back to emp and save emp

		/*		select * from empl;
				+-------+------+
				| empId | name |
				+-------+------+
				|     1 | Ragg |
				+-------+------+
		
				mysql> select * from empldetl;
				+-------+------+--------+------+
				| empId | city | sal    | tech |
				+-------+------+--------+------+
				|     1 | hyd  | 250000 | Java |
				+-------+------+--------+------+*/

		/*		Hibernate: create table empl (empId integer not null auto_increment, name varchar(255), primary key (empId)) engine=MyISAM
				Hibernate: create table emplDetl (empId integer not null, city varchar(255), sal integer not null, tech varchar(255), primary key (empId)) engine=MyISAM
				Hibernate: alter table emplDetl add constraint FKcyl8xt1wtblp8dap27xajkqm6 foreign key (empId) references empl (empId)
				Hibernate: insert into empl (name) values (?)
				Hibernate: insert into emplDetl (city, sal, tech, empId) values (?, ?, ?, ?)
				Saved Successfully */

		/******************************************************************************************************/

		// ONE TO ONE WITH A JOIN TABLE

		/*		Workstation ws = new Workstation(0, "Dell");
				Empl empl = new Empl(0, "Ragg");
				empl.setWorkstation(ws);
				saveItem(empl);*/

		/*		Hibernate: create table empl (empId integer not null auto_increment, name varchar(255), detId integer, primary key (empId)) engine=MyISAM
				Hibernate: create table empl_workstn (workstn_Id bigint, emp_Id integer not null, primary key (emp_Id)) engine=MyISAM
				Hibernate: create table emplDetl (emplDtlId integer not null auto_increment, city varchar(255), sal integer not null, tech varchar(255), primary key (emplDtlId)) engine=MyISAM
				Hibernate: create table workstn (workstnId bigint not null auto_increment, name varchar(255), primary key (workstnId)) engine=MyISAM
				Hibernate: alter table empl add constraint FKcitr3jmld6ib6kt99vf3n6g79 foreign key (detId) references emplDetl (emplDtlId)
				Hibernate: alter table empl_workstn add constraint FK8qcej4snlrnvdab9qwpo6rail foreign key (workstn_Id) references workstn (workstnId)
				Hibernate: alter table empl_workstn add constraint FK6pl42qw0hl1jbt5u1o1gjd3jl foreign key (emp_Id) references empl (empId)
				Hibernate: insert into workstn (name) values (?)
				Hibernate: insert into empl (detId, name) values (?, ?)
				Hibernate: insert into empl_workstn (workstn_Id, emp_Id) values (?, ?)
				Saved Successfully */

	}

	/*	select * from empl;
		+-------+------+-------+
		| empId | name | detId |
		+-------+------+-------+
		|     1 | Ragg |  NULL |
		+-------+------+-------+
	
		mysql> select * from workstn;
		+-----------+------+
		| workstnId | name |
		+-----------+------+
		|         1 | Dell |
		+-----------+------+
	
		mysql> select * from empl_workstn;
		+------------+--------+
		| workstn_Id | emp_Id |
		+------------+--------+
		|          1 |      1 |
		+------------+--------+
	*/

	/******************************************************************************************************/

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
