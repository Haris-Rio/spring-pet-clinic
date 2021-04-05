package org.springframework.springpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.springpetclinic.model.Vet;
import org.springframework.springpetclinic.model.repositories.VetRepository;
import org.springframework.springpetclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VetSDJService implements VetService{
	
	private final VetRepository vetRepository;

	public VetSDJService(VetRepository vetRepository) {
		super();
		this.vetRepository = vetRepository;
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<>();
		vetRepository.findAll().forEach(vets::add);
		return vets;
	}

	@Override
	public Vet findbyId(Long id) {	
		return vetRepository.findById(id).orElse(null);
	}

	@Override
	public Vet save(Vet object) {
		return vetRepository.save(object);
	}

	@Override
	public void delete(Vet object) {
		vetRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);
	}

}
