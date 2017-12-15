package com.example.skype.bot.handler;

import com.example.skype.bot.builders.SkypeActivityBuilder;
import com.example.skype.bot.clients.ObtainAccessTokenClient;
import com.example.skype.bot.clients.SendMessageResponse;
import com.example.skype.bot.dto.message.SkypeActivityDto;
import com.example.skype.bot.dto.message.SkypeMessageDto;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SkypeMessagesHandlerImpl implements SkypeMessagesHandler {
    private SkypeActivityBuilder activityBuilder;
    private SendMessageResponse messageResponseClient;

    public SkypeMessagesHandlerImpl(SkypeActivityBuilder activityBuilder, SendMessageResponse messageResponseClient) {
        this.activityBuilder = activityBuilder;
        this.messageResponseClient = messageResponseClient;
    }

    public SkypeActivityBuilder getActivityBuilder() {
        return activityBuilder;
    }

    public void setActivityBuilder(SkypeActivityBuilder activityBuilder) {
        this.activityBuilder = activityBuilder;
    }

    public SendMessageResponse getMessageResponseClient() {
        return messageResponseClient;
    }

    public void setMessageResponseClient(SendMessageResponse messageResponseClient) {
        this.messageResponseClient = messageResponseClient;
    }

    @Override
    @Async
    public void execute(SkypeMessageDto messageDto) {
        SkypeActivityDto res = activityBuilder.buildResponse(messageDto, "I AM ALIVE!!!");
        messageResponseClient.sendResponse(res);
    }
}
