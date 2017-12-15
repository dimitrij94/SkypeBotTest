package com.example.skype.bot.dto.message;

public class SkypeActivityDto extends SkypeMessageDto{
    private String replyToId;

    public String getReplyToId() {
        return replyToId;
    }

    public void setReplyToId(String replyToId) {
        this.replyToId = replyToId;
    }
}
