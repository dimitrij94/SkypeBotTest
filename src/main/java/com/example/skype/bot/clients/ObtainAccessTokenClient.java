package com.example.skype.bot.clients;

import com.example.skype.bot.dto.authentication.SkypeAccessTokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class ObtainAccessTokenClient implements InitializingBean {
    private RestTemplate restTemplate;
    private SkypeAccessTokenResponse accessToken;
    private final String authenticationUrl = "https://login.microsoftonline.com/botframework.com/oauth2/v2.0/token";
    //private final String authenticationUrl = "https://137d0260.ngrok.io";
    private Logger logger = LoggerFactory.getLogger(ObtainAccessTokenClient.class);

    public ObtainAccessTokenClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //grant_type=client_credentials&client_id=MICROSOFT-APP-ID&client_secret=MICROSOFT-APP-PASSWORD&scope=https%3A%2F%2Fapi.botframework.com%2F.default
    @Override
    public void afterPropertiesSet() throws Exception {
        refreshAccessToken();

    }

    private void refreshAccessToken() {
        logger.debug("Sending request to get the access token");
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "client_credentials");
        map.add("scope", "https://api.botframework.com/.default");
        map.add("client_id", "6e27f9ec-1f6a-4a4e-8f9f-d91df9677a68");
        map.add("client_secret", "wurrnBCDE149wsDAL68@;!:");
        try {
            ResponseEntity<SkypeAccessTokenResponse> response = restTemplate.postForEntity(authenticationUrl, new HttpEntity<>(map, getHttpHeders()), SkypeAccessTokenResponse.class);
            if (response.getStatusCode().is2xxSuccessful())
                logger.info("ACCESS TOKEN: " + response.getBody().getAccessToken());
            accessToken = response.getBody();
        } catch (HttpClientErrorException e) {
            logger.error("Microsoft server returned this error: " + e.getResponseBodyAsString(), e);
        }
    }

    private HttpHeaders getHttpHeders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8, MediaType.APPLICATION_JSON));
        //headers.add("Accept", "application/json; charset=utf-8");
        //headers.add("Content-Type", "application/x-www-form-urlencoded");
        headers.set("Host", "login.microsoftonline.com");
        return headers;
    }

    public String getAccessToken() {
        return accessToken.getAccessToken();
    }
}
