package org.top.currencysaverwebapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableScheduling
@OpenAPIDefinition(
		info = @Info(
				title = "Currency Saver",
				version = "1.0.0",
				description = "Сервис для работы с курсами валют",
				contact = @Contact(
						name = "Виталий",
						email = "vitalijjvasilchenko@gmail.com"
				)
		)
)
@Controller
public class CurrencySaverWebAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(CurrencySaverWebAppApplication.class, args);
	}

	@GetMapping
	public String redirectToSwagger() {
		return "redirect:/swagger-ui.html";
	}
}
