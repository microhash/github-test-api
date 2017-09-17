package com.githubapi.client.core;

import com.githubapi.client.dto.token.OauthResponse;
import java.util.HashMap;
import java.util.Map;

import static com.githubapi.client.core.Data.Authorization.AUTHORIZATIONS_ENDPOINT;
import static com.githubapi.client.core.Data.General.AUTHORIZATION_HEADER;
import static com.githubapi.client.core.Data.General.AUTHORIZATION_HEADER_VALUE;
import static com.githubapi.client.core.Data.General.BASE_API_URL;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_NO_CONTENT;
import static org.apache.http.HttpStatus.SC_OK;

public class Oauth {

    String createOauthToken(String appName) {
        Map<String, Object> authJSON = new HashMap<>();
        authJSON.put("note", appName);

        return given()
                .baseUri(BASE_API_URL)
                .header(AUTHORIZATION_HEADER, AUTHORIZATION_HEADER_VALUE)
                .contentType(JSON)
                .body(authJSON)
                .expect()
                .statusCode(SC_CREATED)
                .when()
                .post(AUTHORIZATIONS_ENDPOINT)
                .getBody().as(OauthResponse.class).getToken();
    }

    private String viewSpecificOauthToken(String tokenId) {
        return given()
                .baseUri(BASE_API_URL)
                .header(AUTHORIZATION_HEADER, AUTHORIZATION_HEADER_VALUE)
                .expect()
                .statusCode(SC_OK)
                .when()
                .get(AUTHORIZATIONS_ENDPOINT + tokenId)
                .getBody().prettyPrint();
    }

    public String viewAllOauthTokens() {
        return viewSpecificOauthToken("");
    }

    void deleteOauthToken(String tokenId) {
        given()
                .baseUri(BASE_API_URL)
                .header(AUTHORIZATION_HEADER, AUTHORIZATION_HEADER_VALUE)
                .expect()
                .statusCode(SC_NO_CONTENT)
                .when()
                .delete(AUTHORIZATIONS_ENDPOINT + tokenId);
    }

    public static void main(String[] args) {
        Oauth oauth = new Oauth();
//        System.out.println(oauth.viewAllOauthTokens());
        System.out.println(oauth.createOauthToken("test2"));
    }
}
