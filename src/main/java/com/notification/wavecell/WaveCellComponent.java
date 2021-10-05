package com.notification.wavecell;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.notification.messages.MessageSender;

import org.springframework.stereotype.Component;

/**
 * Visit Wavecell page to register subAccountId.
 */
@Component
public class WaveCellComponent extends MessageSender {

    final String MY_NUMBER = "+84965019428";
    final String SUB_ACCOUNT_ID = "SMSNotification_5kK14_hq";
    final String AUTH_TOKEN = "L0MTGD1JFuN4qikcZbgVtYgNjDCJ1zuSVKuNiY";
    final String api = "https://sms.8x8.com/api/v1/subaccounts/" + SUB_ACCOUNT_ID + "/messages";

    final RestTemplate restTemplate;

    public WaveCellComponent(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    @Override
    public void sendSMS(final String toTarget, final String body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(AUTH_TOKEN);
        Map<String, Object> requestBody = new  HashMap<>();
        requestBody.put("source", MY_NUMBER);
        requestBody.put("destination", toTarget);
        requestBody.put("text", body);
        requestBody.put("encoding", "AUTO");
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(api, entity, String.class);
        System.out.print(response.getBody());
    }
}