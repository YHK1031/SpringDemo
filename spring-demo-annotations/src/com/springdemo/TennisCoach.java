package com.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	private FortuneService fortuneService;
	
	// define a default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	// define a setter method
	
	@Autowired
	public void setFortuneService(FortuneService theFortuneSerivce) {
		System.out.println(">> TennisCoach: inside setFortuneService() method");
		this.fortuneService = theFortuneSerivce;
	}
	
	
	/*
	@Autowired
	public void doSomeCrazyStuff(FortuneService theFortuneSerivce) {
		System.out.println(">> TennisCoach: inside doSomeCrazyStuff() method");
		this.fortuneService = theFortuneSerivce;
	}
	*/
	
	
	/*
	@Autowired
	public TennisCoach(FortuneService theFortuneSerivce) {
		fortuneService=theFortuneSerivce;
	}
	*/
	
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {		
		return fortuneService.getFortune();
	}
	
	
}
