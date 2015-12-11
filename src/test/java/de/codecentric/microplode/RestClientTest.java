package de.codecentric.microplode;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GameServiceApplication.class)
@WebIntegrationTest
public class RestClientTest {

    /**
     * Using Restassured for elegant REST-Testing, see https://github.com/jayway/rest-assured
     */
    @Test
    public void testWithRestAssured() {
        
        given() 
        .when() 
            .get("http://localhost:8080/gameservice/start-new-game")
        .then()
            .statusCode(HttpStatus.SC_OK)
            .assertThat()
                .equals("Game started");
    }
    
}
