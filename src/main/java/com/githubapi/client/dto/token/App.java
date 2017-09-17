package com.githubapi.client.dto.token;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class App {
    String name;
    String url;
    @JsonProperty("client_id")
    String clientId;
}
