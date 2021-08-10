package com.notification;

public interface IMessageSender {

    void sendSMS(String fromTarget, String toTarget, String body);

    void sendSMS(String toTarget, String body);

    void sendMessage(String toTarget, String body);
    
}
