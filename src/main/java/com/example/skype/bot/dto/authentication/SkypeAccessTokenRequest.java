package com.example.skype.bot.dto.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SkypeAccessTokenRequest {
    @JsonProperty("grant_type")
    private String grandType;

    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("client_secret")
    private String clientSecret;

    private String scope;

    public String getGrandType() {
        return grandType;
    }

    public SkypeAccessTokenRequest() {
    }



    public void setGrandType(String grandType) {
        this.grandType = grandType;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public SkypeAccessTokenRequest grandType(String grandType) {
        this.grandType = grandType;
        return this;
    }

    public SkypeAccessTokenRequest clientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public SkypeAccessTokenRequest clientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }

    public SkypeAccessTokenRequest scope(String scope) {
        this.scope = scope;
        return this;
    }
}
