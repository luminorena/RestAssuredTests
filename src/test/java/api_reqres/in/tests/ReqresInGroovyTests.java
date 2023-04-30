package api_reqres.in.tests;

import org.junit.jupiter.api.Test;

import static api_reqres.in.specs.RequestSpec.createUserRequestSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

public class ReqresInGroovyTests {


    @Test
    public void checkEmail() {
        // @formatter:off
        given()
                .spec(createUserRequestSpec)
        .when()
                .get()
        .then()
                .log().body()
                .body("data.findAll{it.email =~/.*?@/}.email.flatten()",
                        hasItem("eve.holt@reqres.in"));
        // @formatter:on

    }

    @Test
    public void checkFirstName() {
        // @formatter:off
        given()
                .spec(createUserRequestSpec)
        .when()
                .get()
        .then()
                .log().body()
                .body("data.findAll{it.first_name =~/[a-zA-Z]+/}.first_name.flatten()",
                        hasItem("Janet"));
        // @formatter:on

    }

    @Test
    public void checkLastName() {
        // @formatter:off
        given()
                .spec(createUserRequestSpec)
        .when()
                .get()
        .then()
                .log().body()
                .body("data.findAll{it.last_name =~/[a-zA-Z]+/}.last_name.flatten()",
                        hasItem("Bluth"));
        // @formatter:on

    }

    @Test
    public void checkAvatar() {
        // @formatter:off
        given()
                .spec(createUserRequestSpec)
        .when()
                .get()
        .then()
                .log().body()
                .body("data.findAll{it.avatar =~/https.*?\\.jpg/}.avatar.flatten()",
                        hasItem("https://reqres.in/img/faces/2-image.jpg"));
        // @formatter:on

    }

}
