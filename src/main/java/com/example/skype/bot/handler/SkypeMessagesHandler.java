package com.example.skype.bot.handler;

import com.example.skype.bot.dto.message.SkypeMessageDto;

public interface SkypeMessagesHandler {
    void execute(SkypeMessageDto messageDto);
}
