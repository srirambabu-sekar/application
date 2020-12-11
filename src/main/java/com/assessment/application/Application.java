package com.assessment.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author srirambabu.sekar on 11-12-2020.
 * Application Starts here
 * Main Class
 */
@SpringBootApplication(scanBasePackages = {"com.assessment.application"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
