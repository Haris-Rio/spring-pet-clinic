package org.springframework.springpetclinic.model;

import java.util.Set;

public class Vet extends Person{

	private Set<Speciality> specialities;

	public Set<Speciality> getSpecialities() {
		return specialities;
	}

	public void setSpeialities(Set<Speciality> specialities) {
		this.specialities = specialities;
	}

}
