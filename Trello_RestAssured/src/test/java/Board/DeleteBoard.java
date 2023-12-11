package Board;

import Model.TestModel;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class DeleteBoard extends CreateBoard {


        @Test
        public void TestCase5() {


            given().baseUri("https://api.trello.com/1")
                    .contentType(ContentType.JSON)
                    .queryParam("key",key)
                    .queryParam("token",token)

                    .when()
                    .delete("/boards/" + BoardID)

                    .then()
                    .log().all()
                  .assertThat().body("value",equalTo(null))
                    .assertThat().statusCode(200);
        }
}
