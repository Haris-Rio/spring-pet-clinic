package org.springframework.springpetclinic.services.map;

import java.util.Set;

import org.springframework.springpetclinic.model.Speciality;
import org.springframework.springpetclinic.services.SpecialitiesService;
import org.springframework.stereotype.Service;

@Service
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialitiesService{

	@Override
	public Set<Speciality> findAll() {
		return super.findAll();
	}

	@Override
	public Speciality findbyId(Long id) {
		return super.findbyId(id);
	}

	@Override
	public Speciality save(Speciality object) {
		return super.save(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Speciality object) {
		super.delete(object);
	}

	
}
