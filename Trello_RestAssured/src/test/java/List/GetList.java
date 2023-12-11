package List;

import Board.CreateBoard;
import Model.TestModel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetList extends CreateList {

    @Test
    public void TestCase4()
    {
            given().baseUri("https://api.trello.com/1")

                .contentType(ContentType.JSON)
                .queryParam("key",key)
                .queryParam("token",token)


                .when()
                .get("/Lists/"+ListID)

                .then()
                .log().all()
                .assertThat().statusCode(200);



    }
}
