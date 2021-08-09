package com.notification.twilio;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


import org.springframework.stereotype.Component;

@Component
public class TwilioComponent {

    public TwilioComponent() {

    }

    /**
     * Send sms by Messaging Service Id.
     */
    public void sendSMS(String toTarget, String messageContent) {
        try {
            Twilio.init(AuthorizationInfo.ACCOUNT_SID, AuthorizationInfo.AUTH_TOKEN);
            Message message = Message
                    .creator(new PhoneNumber(toTarget), // to
                            AuthorizationInfo.MESSAGING_SERVICE_SID, // from
                            messageContent)
                    .create();
            System.out.println(message.getSid());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}