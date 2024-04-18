package com.booking.hotel;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class HotelApplication {
	@PostConstruct
	public void startupApplication() {
		System.out.println("----------->Application Started");
	}

	@PreDestroy
	public void shutdownApplication() {
		System.out.println("----------->Stopping application---------------");
	}

	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}

}