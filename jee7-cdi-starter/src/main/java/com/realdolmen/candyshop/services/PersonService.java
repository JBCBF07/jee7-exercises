package com.realdolmen.candyshop.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.realdolmen.candyshop.repositories.PersonRepository;

@ApplicationScoped
public class PersonService {
	
	@Inject
	private PersonRepository personRepository;

	public PersonRepository getPersonRepository() {
		return personRepository;
	}

	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public void findPersonById(int i) {
		// TODO Auto-generated method stub
		
	}
	
	

}
