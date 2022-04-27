package net.rag.hib.model.inherit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long animalId;
	private String species;

	public Animal() {
		super();
	}

	public Animal(long animalId, String species) {
		super();
		this.animalId = animalId;
		this.species = species;
	}

	public long getAnimalId() {
		return animalId;
	}

	public void setAnimalId(long animalId) {
		this.animalId = animalId;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

}
