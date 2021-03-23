package org.springframework.petclinicweb.bootloader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.petclinicdata.model.Owner;
import org.springframework.petclinicdata.model.Vet;
import org.springframework.petclinicdata.services.OwnerService;
import org.springframework.petclinicdata.services.VetService;
import org.springframework.petclinicdata.services.map.OwnerServiceMap;
import org.springframework.petclinicdata.services.map.VetServiceMap;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner{
	
	private final OwnerService ownerService;
	
	private final VetService vetService;
	

	public DataLoader() {
		ownerService = new OwnerServiceMap();
		vetService = new VetServiceMap();
	}

	@Override
	public void run(String... args) throws Exception {
		
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstname("James");
		owner1.setLastName("Camaroon");
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstname("Lex");
		owner2.setLastName("Luthor");
		ownerService.save(owner2);
		
		System.out.println("Loaded owners.......");
		
		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstname("Peter");
		vet1.setLastName("Parkar");
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstname("Green");
		vet2.setLastName("lantern");
		vetService.save(vet2);
		
		System.out.println("Loaded vets.......");
		
		
		
		
	}

}
