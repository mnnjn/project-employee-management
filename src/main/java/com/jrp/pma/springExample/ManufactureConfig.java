package com.jrp.pma.springExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ManufactureConfig {
	@Bean
	public Car newCar() {
		Engine e = new Engine();
		Door d = new Door();
		Tyre t = new Tyre();
		
		return new Car(e,d,t);
	}
}
