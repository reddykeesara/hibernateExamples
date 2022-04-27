package net.rag.hib.model.inherit;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.DiscriminatorFormula;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name="productType", discriminatorType = DiscriminatorType.INTEGER)
//@DiscriminatorFormula("case when author is not null then 'b' else 'c' end")
public class Stationery {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;
	private String name;
	
	

	public Stationery() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stationery(long productId, String name) {
		super();
		this.productId = productId;
		this.name = name;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
