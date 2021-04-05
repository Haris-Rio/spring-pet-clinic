package org.springframework.springpetclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.springpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
