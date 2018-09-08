package com.smartchoice.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com")
public class MainApp {

	public static void main(String[] args) {
		
		System.out.println("main method");
		
		SpringApplication.run(MainApp.class, args);
		
	}
}
