package com.generalassembly.yourdash.repositories;

import org.springframework.data.repository.CrudRepository;

import com.generalassembly.yourdash.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {

}
