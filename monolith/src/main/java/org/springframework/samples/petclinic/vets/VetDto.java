package org.springframework.samples.petclinic.vets;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Markus Claessens
 */
public class VetDto {

	private int id;
	private String firstName;
	private String lastName;
	private Set<String> specialties;

	public VetDto(int id, String firstName, String lastName, Set<String> specialties) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialties = specialties;
	}

	public int getId() {
		return id;
	}

	public int getNrOfSpecialties() {
		return specialties.size();
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public List<String> getSpecialties() {
		return new ArrayList<>(specialties);
	}
}
