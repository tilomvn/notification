package com.notification.nexmo;

import com.notification.messages.MessageSender;
import com.vonage.client.VonageClient;
import com.vonage.client.sms.MessageStatus;
import com.vonage.client.sms.SmsSubmissionResponse;
import com.vonage.client.sms.messages.TextMessage;

import org.springframework.stereotype.Component;

/**
 * Visit Nexmo site to register authorization info.
 */
@Component
public class NexmoComponent extends MessageSender {

    //Still can not verify phone number ???
    //https://dashboard.nexmo.com/user/activation/verify
    final String VONAGE_API_KEY = "a3bcdf99";
    final String VONAGE_API_SECRET = "ZXIcAhxbKTSUVzj3";
    final String VONAGE_BRAND_NAME = "Vonage APIs";

    @Override
    public void sendSMS(String toTarget, String body) {
        VonageClient client = VonageClient.builder().apiKey(VONAGE_API_KEY).apiSecret(VONAGE_API_SECRET).build();

        TextMessage message = new TextMessage(VONAGE_BRAND_NAME, toTarget, body);

        SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

        if (response.getMessages().get(0).getStatus() == MessageStatus.OK) {
            System.out.println("Message sent successfully.");
        } else {
            System.out.println("Message failed with error: " + response.getMessages().get(0).getErrorText());
        }
    }

}