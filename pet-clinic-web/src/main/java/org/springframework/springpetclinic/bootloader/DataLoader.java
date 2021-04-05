package org.springframework.springpetclinic.bootloader;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.springpetclinic.model.Owner;
import org.springframework.springpetclinic.model.Pet;
import org.springframework.springpetclinic.model.PetType;
import org.springframework.springpetclinic.model.Speciality;
import org.springframework.springpetclinic.model.Vet;
import org.springframework.springpetclinic.model.Visit;
import org.springframework.springpetclinic.services.OwnerService;
import org.springframework.springpetclinic.services.PetTypeService;
import org.springframework.springpetclinic.services.SpecialityService;
import org.springframework.springpetclinic.services.VetService;
import org.springframework.springpetclinic.services.VisitService;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner{
	
	private final OwnerService ownerService;
	
	private final VetService vetService;

	private final PetTypeService petTypeService;
	
	private final SpecialityService specialityService;
	
	private final VisitService visitService;
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
		
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args) throws Exception {
		int count = petTypeService.findAll().size();
		if(count == 0) {
			loadData();
		}
	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		Speciality savedRadiology = specialityService.save(radiology);
		
		Speciality surgery = new Speciality();
		radiology.setDescription("Surgery");
		Speciality savedSurgery = specialityService.save(surgery);
		
		Speciality dentistry = new Speciality();
		radiology.setDescription("Dentistry");
		Speciality savedDentistry = specialityService.save(dentistry);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("James");
		owner1.setLastName("Camaroon");
		owner1.setAddress("123 Vallabhai St");
		owner1.setCity("Chennai");
		owner1.setTelephone("7994111313");
			
		Pet jamesPet = new Pet();
		jamesPet.setOwner(owner1);
		jamesPet.setPetType(savedDogPetType);
		jamesPet.setBirthDate(LocalDate.now());
		jamesPet.setName("Whishkey");
		owner1.getPets().add(jamesPet);
		ownerService.save(owner1);
		
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Lex");
		owner2.setLastName("Luthor");
		owner2.setAddress("123 Rajubhai St");
		owner2.setCity("Chennai");
		owner2.setTelephone("7899977131");
		
		Pet lexPet = new Pet();
		lexPet.setOwner(owner2);
		lexPet.setPetType(savedCatPetType);
		lexPet.setBirthDate(LocalDate.now());
		lexPet.setName("Jin");
		owner2.getPets().add(lexPet);
		ownerService.save(owner2);
		
		Visit catVisit = new Visit();
		catVisit.setPet(lexPet);
		catVisit.setDate(LocalDate.now());
		catVisit.setDescription("Sneezy Cat...");
		
		visitService.save(catVisit);
		
		System.out.println("Loaded owners.......");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Peter");
		vet1.setLastName("Parkar");
		vet1.getSpecialities().add(savedRadiology);
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Green");
		vet2.setLastName("lantern");
		vet2.getSpecialities().add(savedSurgery);
		vetService.save(vet2);
		
		System.out.println("Loaded vets.......");
	}

}
