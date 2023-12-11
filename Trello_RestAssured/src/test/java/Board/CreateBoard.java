package Board;

import Model.TestModel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateBoard extends TestModel {


    @Test
    public void TestCase1()
    {
        Response res =given().baseUri("https://api.trello.com/1")

                .contentType(ContentType.JSON)
                .queryParam("key",key)
                .queryParam("token",token)
                .queryParam("name","API_Testing")
              .queryParam("defaultLists",false)
                .when()
                .post("/boards/")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().body("name",equalTo("API_Testing"))
                .extract().response();

        BoardID=res.path("id");
        System.out.println(BoardID);



    }
    @Test
    public void Invalid_testCase2()
    {
        given()
                .baseUri("https://api.trello.com/1")
                .contentType(ContentType.JSON)
                .queryParam("key",key)
                .queryParam("token",token)
                .queryParam("name","")
                .when()
                .post("/boards/")
                .then()
                .log().all()
                .assertThat().statusCode(400)
                .assertThat().body("message",equalTo("invalid value for name"))
                .assertThat().body("error",equalTo("ERROR"));



    }
}
