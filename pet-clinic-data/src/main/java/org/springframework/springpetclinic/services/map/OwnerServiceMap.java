package org.springframework.springpetclinic.services.map;

import java.util.Set;

import org.springframework.springpetclinic.model.Owner;
import org.springframework.springpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService{


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
		return super.save( object);
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
