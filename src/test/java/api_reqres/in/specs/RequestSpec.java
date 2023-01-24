package api_reqres.in.specs;

import io.restassured.specification.RequestSpecification;

import static api_reqres.in.helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class RequestSpec {
    public static RequestSpecification createUserRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri("https://reqres.in")
            .basePath("/api/users")
            .log().all()
            .contentType(JSON);

    public static RequestSpecification updateUserRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri("https://reqres.in")
            .basePath("/api/users/2")
            .log().all()
            .contentType(JSON);

    public static RequestSpecification deleteUserRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri("https://reqres.in")
            .basePath("/api/users/2")
            .log().all()
            .contentType(JSON);

    public static RequestSpecification getUserRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri("https://reqres.in")
            .basePath("/api/users/2")
            .log().all()
            .contentType(JSON);

    public static RequestSpecification registerUserRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri("https://reqres.in")
            .basePath("/api/register")
            .log().all()
            .contentType(JSON);

}
