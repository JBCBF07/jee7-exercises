package com.realdolmen.candyshop.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.realdolmen.candyshop.repositories.CandyRepository;

@ApplicationScoped
public class CandyService {
	
	@Inject
	private CandyRepository candyRepository;
	@Inject
	private PersonService personService;
	
	
	

	public PersonService getPersonService() {
		return personService;
	}



	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}



	public CandyRepository getCandyRepository() {
		return candyRepository;
	}



	public void setCandyRepository(CandyRepository candyRepository) {
		this.candyRepository = candyRepository;
	}



	public void findAllCandy() {
		// TODO Auto-generated method stub
		
	}

}
