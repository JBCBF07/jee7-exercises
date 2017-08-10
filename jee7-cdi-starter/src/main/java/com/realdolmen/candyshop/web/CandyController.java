package com.realdolmen.candyshop.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.realdolmen.candyshop.domain.CandyColor;
import com.realdolmen.candyshop.services.CandyService;

@RequestScoped
public class CandyController {
	
	
	@Inject
	private CandyService candyService;

	public CandyService getCandyService() {
		return candyService;
	}

	public void setCandyService(CandyService candyService) {
		this.candyService = candyService;
	}

	public void findAllCandy() {
		candyService.getCandyRepository().findAllCandy();
		
	}

	public void findCandyByColor() {
		candyService.getCandyRepository().findByColor(CandyColor.BLUE);
		
	}
	
	
	
}
