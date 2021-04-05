package org.springframework.springpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.springpetclinic.model.Speciality;
import org.springframework.springpetclinic.model.Vet;
import org.springframework.springpetclinic.services.SpecialityService;
import org.springframework.springpetclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
@Profile({"default","map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService{
	
	private final SpecialityService specialityService;

	public VetMapService(SpecialityService specialityService) {
		super();
		this.specialityService = specialityService;
	}

	@Override
	public Vet findbyId(Long id) {
		return super.findbyId(id);
	}

	@Override
	public Vet save(Vet object) {
		
		if(object.getSpecialities().size()>0) {
			object.getSpecialities().forEach(speciality -> {
				if(speciality.getId() == null) {
					Speciality savedSpeciality = specialityService.save(speciality);
					speciality.setId(savedSpeciality.getId());
				}
			});
		}
		return super.save(object);
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
