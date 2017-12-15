package com.example.skype.bot.clients;

import com.example.skype.bot.dto.message.SkypeActivityDto;
import com.example.skype.bot.dto.message.SkypeMessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class SendMessageResponse {
    private final String url = "/v3/conversations/{conversationId}/activities/{activityId}";
    private RestTemplate restTemplate;
    private Logger log = LoggerFactory.getLogger(SendMessageResponse.class);
    private ObtainAccessTokenClient accessTokenClient;

    public SendMessageResponse(RestTemplate restTemplate, ObtainAccessTokenClient accessTokenClient) {
        this.restTemplate = restTemplate;
        this.accessTokenClient = accessTokenClient;
    }

    public void sendResponse(SkypeActivityDto response) {
        try {
            HttpEntity<SkypeActivityDto> dto = new HttpEntity<>(response);
            restTemplate.postForObject(url, dto, Object.class, response.getConversation().getId(), response.getReplyToId());
        } catch (HttpClientErrorException e) {
            log.error(e.getResponseBodyAsString(), e);
        }
    }

    protected HttpHeaders getAuthenticationHeader(Optional<HttpHeaders> optionalHeaders) {
        HttpHeaders headers;
        if (optionalHeaders.isPresent()) {
            headers = optionalHeaders.get();
        } else {
            headers = new HttpHeaders();
        }
        headers.set("Authorization", "Bearer " + accessTokenClient.getAccessToken());
        return headers;
    }

}
