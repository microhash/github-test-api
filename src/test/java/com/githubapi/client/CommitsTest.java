package com.githubapi.client;

import com.githubapi.client.core.TestBase;
import com.githubapi.client.dto.commits.Commit;
import org.testng.annotations.Test;

import static com.githubapi.client.core.Data.Commits.COMMITS_ENDPOINT;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class CommitsTest extends TestBase {

    @Test
    public void testGetCommits() {
        given().spec(spec)
                .auth()
                .oauth2(testAuthToken)
                .expect()
                .statusCode(SC_OK)
                .when()
                .get(COMMITS_ENDPOINT).as(Commit.class);
    }
}
