package org.springframework.springpetclinic.services.map;

import java.util.Set;

import org.springframework.springpetclinic.model.Owner;
import org.springframework.springpetclinic.model.Pet;
import org.springframework.springpetclinic.services.OwnerService;
import org.springframework.springpetclinic.services.PetService;
import org.springframework.springpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService{

	private final PetService petService;
	private final PetTypeService petTypeService;

	public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
		super();
		this.petService = petService;
		this.petTypeService = petTypeService;
	}

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
	}

	@Override
	public Owner findbyId(Long id) {
		return super.findbyId(id);
	}

	@Override
	public Owner save(Owner object) {
		
		if(object != null) {
			if(object.getPets() != null) {
				object.getPets().forEach(pet -> {
					if(pet.getPetType() != null) {
						pet.setPetType(petTypeService.save(pet.getPetType()));
					}else {
						throw new RuntimeException("Pet Type should not be Null");
					}
					if(pet.getId() != null) {
						Pet savedPet = petService.save(pet);
						pet.setId(savedPet.getId());
					}
				});
			}
			return super.save( object);
		}else {
			return null;
		}
		
		
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
		
	}
	
	@Override
	public Owner findByLastName(String lastName) {
		return null;
	}
	
	

}
