package com.realdolmen.candyshop.repositories;

import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.realdolmen.candyshop.domain.Person;

@ApplicationScoped
public class PersonRepository {
	
	@Inject
	private Logger log;
	
	public void savePerson(Person p){
		log.info("Person has been saved");
	}
	
	public void findPersonById(int id){
		log.info("Person has been returned");
	}

}
