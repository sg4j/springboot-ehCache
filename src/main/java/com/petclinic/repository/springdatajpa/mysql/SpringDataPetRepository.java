package com.petclinic.repository.springdatajpa.mysql;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;

import com.petclinic.entity.mysql.Pet;

public interface SpringDataPetRepository extends CrudRepository<Pet, Integer> {

	public Collection<Pet> findByName(String name) throws DataAccessException;
	public Pet findById(Integer id);
}
