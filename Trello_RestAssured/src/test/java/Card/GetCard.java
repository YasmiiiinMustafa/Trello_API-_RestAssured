package Card;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetCard extends CreateCard{

    @Test
    public void TestCase8()
    {
        given().baseUri("https://api.trello.com/1")

                .contentType(ContentType.JSON)
                .queryParam("key",key)
                .queryParam("token",token)


                .when()
                .get("/cards/"+CardID)

                .then()
                .log().all()
                .assertThat().statusCode(200);



    }
}
