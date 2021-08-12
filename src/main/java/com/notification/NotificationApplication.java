package com.notification;

import com.notification.nexmo.NexmoComponent;
import com.notification.twilio.TwilioComponent;
import com.notification.wavecell.WaveCellComponent;

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
	ApplicationRunner runner(TwilioComponent twilioComponent, WaveCellComponent waveCellComponent, NexmoComponent nexmoComponent) {
		return args -> nexmoComponent.sendSMS("84965019428", "AAAAAB");
	}

}
