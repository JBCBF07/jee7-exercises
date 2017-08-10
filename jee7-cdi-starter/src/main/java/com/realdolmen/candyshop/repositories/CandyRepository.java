package com.realdolmen.candyshop.repositories;

import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.realdolmen.candyshop.domain.Candy;
import com.realdolmen.candyshop.domain.CandyColor;

@ApplicationScoped
public class CandyRepository {
	
	@Inject
	private Logger log;
	
	public void saveCandy(Candy c){
		log.info("Candy has been saved");
	}
	
	public void findAllCandy(){
		log.info("All candy has been returned");
	}
	
	public void findByColor(CandyColor cc){
		log.info("Candy has been returned");
	}

}
