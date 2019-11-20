package com.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
//	@Autowired
//	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	
	// define a default constructor
	
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	// define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside of doMyStartupStuff");
	}
	
	// define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside of doMyCleanupStuff");
	}
	
	// define a setter method
	
	@Autowired
	public void setFortuneService(@Qualifier("randomFortuneService") FortuneService theFortuneSerivce) {
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
	public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneSerivce) {
		fortuneService=theFortuneSerivce;
	}
	*/
	
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley"+" "+email+" "+team;
	}

	@Override
	public String getDailyFortune() {		
		return fortuneService.getFortune();
	}
	
	
}
