package org.springframework.springpetclinic.services.map;

import java.util.Set;

import org.springframework.springpetclinic.model.PetType;
import org.springframework.springpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService{

	@Override
	public Set<PetType> findAll() {
		return super.findAll();
	}

	@Override
	public PetType findbyId(Long id) {
		return super.findbyId(id);
	}

	@Override
	public PetType save(PetType object) {
		return super.save(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(PetType object) {
		super.delete(object);
	}

}
