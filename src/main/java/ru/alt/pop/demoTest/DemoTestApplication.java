package ru.alt.pop.demoTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.alt.pop.demoTest.controller.TelegramBotController;
import ru.alt.pop.demoTest.service.TelegramBotService;

@SpringBootApplication
public class DemoTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTestApplication.class, args);
	}

}
