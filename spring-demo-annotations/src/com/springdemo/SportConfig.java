package com.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.springdemo")
@PropertySource({"classpath:sport.properties","classpath:fortune.properties"})
public class SportConfig {

	// define bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneSerivce() { // This method name will be the "bean id"
		return new SadFortuneService();
	}
	
	// define bean for our swim coach AND inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneSerivce());
	}
	
}
