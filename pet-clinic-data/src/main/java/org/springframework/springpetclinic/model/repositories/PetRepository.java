package org.springframework.springpetclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.springpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long>{

}
