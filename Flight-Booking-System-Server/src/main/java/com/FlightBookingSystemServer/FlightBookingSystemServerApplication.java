package com.FlightBookingSystemServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FlightBookingSystemServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightBookingSystemServerApplication.class, args);
	}

}
