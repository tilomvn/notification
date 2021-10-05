package com.notification.messages;

public abstract class MessageSender implements IMessageSender {

    @Override
    public void sendSMS(String fromTarget, String toTarget, String body) {}

    @Override
    public void sendMessage(String toTarget, String body) {}

}