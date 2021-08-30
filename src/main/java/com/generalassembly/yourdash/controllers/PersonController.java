package com.generalassembly.contacts.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.beans.factory.annotation.Autowired;

import com.generalassembly.yourdash.repositories.PersonRepository;
import com.generalassembly.yourdash.entities.Person;

@RestController
public class PersonController {
    @Autowired
	private PersonRepository personRepository;

    @CrossOrigin(origins = {"http://localhost:3000","http://localhost:8080"})
	@GetMapping("/people")
	public Iterable<Person> index() {
		return personRepository.findAll();
	}

	@CrossOrigin(origins = {"http://localhost:3000"})
	@PostMapping("/people")
	public Iterable<Person> create (@RequestBody Person personData) {
		personRepository.save(personData);
		return personRepository.findAll();
	}

	@DeleteMapping("/people/{id}")
	public Iterable<Person> delete(@PathVariable int id) {
		personRepository.deleteById(id);
		return personRepository.findAll();
	}

	@PutMapping("/people/{id}")
	public Iterable<Person> update(@PathVariable int id, @RequestBody Person personData) {
		personData.setId(id);
		personRepository.save(personData);
		return personRepository.findAll();
	}
}
