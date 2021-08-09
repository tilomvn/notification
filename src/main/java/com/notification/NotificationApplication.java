package com.notification;

import com.notification.twilio.TwilioComponent;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}

	@Bean
	ApplicationRunner runner(TwilioComponent twilioComponent) {
		return args -> twilioComponent.sendSMS("+84965019428", "AAAAA");
	}

}
