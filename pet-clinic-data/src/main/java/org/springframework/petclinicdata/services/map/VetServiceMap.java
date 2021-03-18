package org.springframework.petclinicdata.services.map;

import java.util.Set;

import org.springframework.petclinicdata.model.Vet;
import org.springframework.petclinicdata.services.VetService;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService{

	@Override
	public Vet findbyId(Long id) {
		return super.findbyId(id);
	}

	@Override
	public Vet save(Vet object) {
		return super.save(object.getId(), object);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
		
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
}
