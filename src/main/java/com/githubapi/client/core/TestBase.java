package com.githubapi.client.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.githubapi.client.core.Data.General.BASE_API_URL;

public class TestBase {

    private Oauth oauth = new Oauth();
    protected String testAuthToken = oauth.createOauthToken("test");

    protected RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri(BASE_API_URL)
            .addFilter(new RequestLoggingFilter())
            .addFilter(new ResponseLoggingFilter())
            .build();

    @BeforeSuite
    public void setUp() {
        RestAssured.config = RestAssuredConfig.config().objectMapperConfig(
                new ObjectMapperConfig().jackson2ObjectMapperFactory((aClass, s) ->
                        new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL)));
    }

    @AfterSuite
    public void tearDown() {
        oauth.deleteOauthToken(testAuthToken);
    }
}