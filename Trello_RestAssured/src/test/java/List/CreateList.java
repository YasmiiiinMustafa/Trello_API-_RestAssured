package List;

import Board.CreateBoard;
import Model.TestModel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class CreateList extends CreateBoard {


    @Test
    public void TestCase3()
    {


        Response List = given().baseUri("https://api.trello.com/1")

                .contentType(ContentType.JSON)
                .queryParam("key",key)
                .queryParam("token",token)
                .queryParam("name","project")
                .queryParam("idBoard",BoardID)

                .when()
                .post("/Lists/")

                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().body("name",equalTo("project"))
                .extract().response();

        ListID=List.path("id");
        System.out.println(ListID);



    }

}
