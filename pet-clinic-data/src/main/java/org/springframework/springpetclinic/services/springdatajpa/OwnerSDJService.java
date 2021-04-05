package org.springframework.springpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.springpetclinic.model.Owner;
import org.springframework.springpetclinic.model.repositories.OwnerRepository;
import org.springframework.springpetclinic.model.repositories.PetRepository;
import org.springframework.springpetclinic.model.repositories.PetTypeRepository;
import org.springframework.springpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class OwnerSDJService implements OwnerService{
	
	private final PetRepository petRepository;
	private final PetTypeRepository petTypeRepository;
	private final OwnerRepository ownerRepository;

	public OwnerSDJService(PetRepository petRepository, PetTypeRepository petTypeRepository,
			OwnerRepository ownerRepository) {
		super();
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
		this.ownerRepository = ownerRepository;
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll().forEach(owners::add);
		return owners;
	}

	@Override
	public Owner findbyId(Long id) {
//		Optional<Owner> optionalOwner = ownerRepository.findById(id);
//		if(optionalOwner.isPresent()) {
//			return optionalOwner.get();
//		}else {
//			return null;
//		}
		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Owner save(Owner object) {
		return ownerRepository.save(object);
	}

	@Override
	public void delete(Owner object) {
		ownerRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}

}
