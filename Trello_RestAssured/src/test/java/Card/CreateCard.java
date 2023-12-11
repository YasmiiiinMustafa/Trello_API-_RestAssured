package Card;

import List.CreateList;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateCard extends CreateList {

    @Test
    public void TestCase7()
    {
        TestCase3();

        Response Card = given().baseUri("https://api.trello.com/1")

                .contentType(ContentType.JSON)
                .queryParam("key",key)
                .queryParam("token",token)
                .queryParam("name","Task1")
                .queryParam("idList",ListID)

                .when()
                .post("/cards/")

                .then()
                .log().all()
                .assertThat().statusCode(200)
                .extract().response();

        CardID=Card.path("id");
        System.out.println(CardID);



    }
}
