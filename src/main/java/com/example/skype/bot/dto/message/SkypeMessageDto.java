package com.example.skype.bot.dto.message;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SkypeMessageDto {
    private String timestamp;

    private String id;

    private String text;

    private String channelId;

    private Conversation conversation;

    private Recipient from;

    private String serviceUrl;

    private String type;

    private Recipient recipient;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public Recipient getFrom() {
        return from;
    }

    public void setFrom(Recipient from) {
        this.from = from;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    @Override
    public String toString() {
        return "ClassPojo [timestamp = " + timestamp + ", id = " + id + ", text = " + text + ", channelId = " + channelId + ", conversation = " + conversation + ", from = " + from + ", serviceUrl = " + serviceUrl + ", type = " + type + ", recipient = " + recipient + "]";
    }
}