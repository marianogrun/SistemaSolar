package com.weather.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class WeatherApplicationComponentScan {
	
	@ComponentScan(basePackages = {"com", "com.weather.repositories", "com.weather.services"})
	@Configuration
	public class ApplicationComponentScan {
	}

}
