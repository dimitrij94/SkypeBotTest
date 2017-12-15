package com.example.skype.bot.builders;

import com.example.skype.bot.consts.SkypeMessagesTypes;
import com.example.skype.bot.dto.message.SkypeActivityDto;
import com.example.skype.bot.dto.message.SkypeMessageDto;
import org.springframework.stereotype.Component;

@Component
public class SkypeActivityBuilder {

    public SkypeActivityDto buildResponse(SkypeMessageDto messageDto, String text) {
        SkypeActivityDto activityDto = new SkypeActivityDto();
        activityDto.setRecipient(messageDto.getFrom());
        activityDto.setFrom(messageDto.getRecipient());
        activityDto.setConversation(messageDto.getConversation());
        activityDto.setReplyToId(messageDto.getId());
        activityDto.setType(SkypeMessagesTypes.MESSAGE_TYPE);
        activityDto.setText(text);
        return activityDto;
    }
}
