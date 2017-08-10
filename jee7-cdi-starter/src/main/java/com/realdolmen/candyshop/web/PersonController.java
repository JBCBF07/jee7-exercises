package com.realdolmen.candyshop.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.realdolmen.candyshop.domain.Person;
import com.realdolmen.candyshop.services.PersonService;

@RequestScoped
public class PersonController {
	
	@Inject
	private PersonService personService;

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public void savePerson(Person person) {
		personService.getPersonRepository().savePerson(person);
	}

	public void findPersonById(int i) {
		personService.getPersonRepository().findPersonById(i);

		
		
	}
	
	
	
	

}
