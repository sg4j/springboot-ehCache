package com.petclinic.api.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petclinic.repository.springdatajpa.mysql.SpringDataPetRepository;

@RestController
public class PetServiceEndpoint {

	@Autowired
	SpringDataPetRepository petRepository;
	
	@RequestMapping("/pet/name")
	public Collection<com.petclinic.entity.mysql.Pet> getPetByName(@RequestParam(value="name") String petName){
		System.out.println("Came here in getPetByName");
		return petRepository.findByName(petName);
	}
	
	@RequestMapping("/pet/id")
	public String getPetById(@RequestParam(value="id") Integer id){
		System.out.println("Came here in getPetById");
		return petRepository.findById(id).toString();
	}	
}
