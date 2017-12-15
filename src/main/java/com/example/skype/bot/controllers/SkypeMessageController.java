package com.example.skype.bot.controllers;

import com.example.skype.bot.builders.SkypeActivityBuilder;
import com.example.skype.bot.clients.SendMessageResponse;
import com.example.skype.bot.dto.message.SkypeActivityDto;
import com.example.skype.bot.dto.message.SkypeMessageDto;
import com.example.skype.bot.handler.SkypeMessagesHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class SkypeMessageController {
    private SkypeMessagesHandler handler;

    public SkypeMessageController(SkypeMessagesHandler handler) {
        this.handler = handler;
    }

    @PostMapping
    public ResponseEntity<?> postMessage(SkypeMessageDto messageDto) {
        handler.execute(messageDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
