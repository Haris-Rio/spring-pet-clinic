package org.springframework.petclinicdata.services;

import org.springframework.petclinicdata.model.Owner;

public interface OwnerService {
	
	Owner findByLastName(String lastName);

}
