package net.rag.hib.model.inherit;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Book extends Stationery {

	private String author;
	
	

	public Book() {
		super();
	}

	public Book(long productId, String name, String author) {
		
		super(productId, name);
		this.author = author;
	}

	public Book(String author) {
		super();
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
