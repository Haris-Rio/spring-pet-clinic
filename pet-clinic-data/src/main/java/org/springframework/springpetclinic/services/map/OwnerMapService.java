package org.springframework.springpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.springpetclinic.model.Owner;
import org.springframework.springpetclinic.services.OwnerService;
import org.springframework.springpetclinic.services.PetService;
import org.springframework.springpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
@Profile({"default","map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService{

	private final PetService petService;
	private final PetTypeService petTypeService;

	public OwnerMapService(PetService petService, PetTypeService petTypeService) {
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
						if(pet.getPetType().getId() == null) {
							pet.setPetType(petTypeService.save(pet.getPetType()));
						}
					}else {
						throw new RuntimeException("Pet Type should not be Null");
					}
					if(pet.getId() == null) {
						petService.save(pet);
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
