package apis;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RandomUser {

    @Test
    public void test() {
        String getRandomUser = "https://randomuser.me/api/";
        Response response = given()
                .when().get(getRandomUser);
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void test1() {
        String getDummyApi = "https://randomuser.me/api/";
        Response response = given().when().get(getDummyApi);
        int statusCode = response.statusCode();
        response.then().log().all();
        Assert.assertEquals(statusCode, 200);
//        System.out.println(response.asString());
//        System.out.println(response.getStatusCode());
//        System.out.println(response.getContentType());
//        System.out.println(response.getTime());
//        System.out.println(response.jsonPath());
//        System.out.println(response.cookies());
//        System.out.println(response.body());

    }

    @Test
    public void reqresApi() {
        given().get("https://reqres.in/api/users?page=2")
                .then().statusCode(200)
//                 .log().all()
                .body("data.id[1]", equalTo(8))
                .body("data.first_name", hasItems("Michael", "Byron"))
                .body("data.last_name", hasItem("Lawson"))
                .body("data.email[1]", equalTo("lindsay.ferguson@reqres.in"));
    }

    @Test
    public void test2() {

        baseURI = "https://reqres.in";
        JSONObject jsonObject = new JSONObject();
        String name = "poonam";
        String job = "IT";
        jsonObject.put("name", name);
        jsonObject.put("job", job);

        given()
                .body(jsonObject.toJSONString())
                .contentType(ContentType.JSON)
                .when()
                .post("/api/users")
                .then()
                .log().all()
                .statusCode(201)
                .body("name", equalTo(name))
                .body("job", equalTo(job));
    }
}
