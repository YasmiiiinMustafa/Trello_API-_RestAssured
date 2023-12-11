package Board;


import Model.TestModel;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetBoard extends CreateBoard {

    @Test
    public void TestCase6() {


        given().baseUri("https://api.trello.com/1")
                .contentType(ContentType.JSON)
                .queryParam("key", key)
                .queryParam("token", token)

                .when()
                .get("/boards/" + BoardID)

                .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}
