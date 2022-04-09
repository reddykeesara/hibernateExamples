package net.rag.hib.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/*You can use the @JoinColumn annotation to map the foreign key column of a 
managed association. The @PrimaryKeyJoinColumn specifies the mapping of
the foreign key column of a secondary table or the foreign key column 
in an inheritance mapping that uses the JOINED strategy.*/

@Entity
@Table(name="emplDetl")
public class EmplDetl {

	@Id
	@Column(name = "emplDtlId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@GeneratedValue(generator = "newGenerator")
	//@GenericGenerator(name="newGenerator", strategy ="foreign", parameters={@Parameter=(value="empl", name="property")})
	//@GenericGenerator(name="newGenerator", strategy="foreign", parameters={@Parameter(value="empl", name="property")})
	int id;
	
	String tech;
	String city;
	int sal;
	
    @OneToOne(mappedBy = "emplDetl")
	Empl empl;
	

//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public Empl getEmpl() {
		return empl;
	}
	public void setEmpl(Empl empl) {
		this.empl = empl;
	}

	
}
