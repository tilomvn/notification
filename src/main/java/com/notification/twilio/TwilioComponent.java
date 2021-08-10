package com.notification.twilio;

import com.notification.MessageSender;
import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import org.springframework.stereotype.Component;

@Component
public class TwilioComponent extends MessageSender {

    private final String MY_TWILIO_NUMBER = "+16789495034";
    private final String MY_NUMBER = "+84965019428";

    //Register URL: https://www.twilio.com/
    private final String ACCOUNT_SID = "AC3dda8a0fef7f8a370249977c89f172da"; //this one is got by reading O_O
    private final String AUTH_TOKEN = "ec064a45213f27a4b592438ee93aceb9";
    private final String MESSAGING_SERVICE_SID = "MGfa5147e65051d1cc48f719f16b29bde2";

    private final String ACCOUNT_SID_TEST = "AC214e452ecdb0179b272b0d246fd7e835";
    private final String AUTH_TOKEN_TEST = "f24b6ba3fcd07842ff464aed2a6d2c1f";

    /**
     * Send sms by Messaging Service Id.
     */
    @Override
    public void sendSMS(String toTarget, String messageContent) {
        try {
            Twilio.init(ACCOUNT_SID_TEST, AUTH_TOKEN_TEST);
            Message message = Message
                    .creator(new PhoneNumber(toTarget), // to
                            MESSAGING_SERVICE_SID, // from
                            messageContent)
                    .create();
            System.out.println(message.getSid());
        } catch (ApiException ex) {
            ex.printStackTrace();
        }
    }
}