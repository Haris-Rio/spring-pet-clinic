package org.springframework.petclinicdata.services.map;

import java.util.Set;

import org.springframework.petclinicdata.model.Owner;
import org.springframework.petclinicdata.services.CrudService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long>{


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
		return super.save(object.getId(), object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
		
	}
	
	

}