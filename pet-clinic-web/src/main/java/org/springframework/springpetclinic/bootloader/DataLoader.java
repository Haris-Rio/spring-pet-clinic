package org.springframework.springpetclinic.bootloader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.springpetclinic.model.Owner;
import org.springframework.springpetclinic.model.Vet;
import org.springframework.springpetclinic.services.OwnerService;
import org.springframework.springpetclinic.services.VetService;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner{
	
	private final OwnerService ownerService;
	
	private final VetService vetService;

	public DataLoader(OwnerService ownerService, VetService vetService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Owner owner1 = new Owner();
		owner1.setFirstName("James");
		owner1.setLastName("Camaroon");
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Lex");
		owner2.setLastName("Luthor");
		ownerService.save(owner2);
		
		System.out.println("Loaded owners.......");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Peter");
		vet1.setLastName("Parkar");
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Green");
		vet2.setLastName("lantern");
		vetService.save(vet2);
		
		System.out.println("Loaded vets.......");
		
		
		
		
	}

}
