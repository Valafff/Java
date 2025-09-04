package org.top.airportdirectoryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.top.airportdirectoryapp.api.message.CommonApiMessages;

@SpringBootApplication
public class AirportDirectoryAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirportDirectoryAppApplication.class, args);
    }

}
