package com.githubapi.client.dto.token;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OauthResponse {
    private int id;
    private String url;
    private App app;
    private String token;
    @JsonProperty("hashed_token")
    private String hashedToken;
    @JsonProperty("token_last_eight")
    private String tokenLastEight;
    private String note;
    @JsonProperty("note_url")
    private String noteUrl;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    private String[] scopes;
    private String fingerprint;
}