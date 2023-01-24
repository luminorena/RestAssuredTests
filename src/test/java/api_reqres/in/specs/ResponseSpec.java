package api_reqres.in.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static org.hamcrest.Matchers.notNullValue;

public class ResponseSpec {
    public static ResponseSpecification createUserResponseSpec =
             new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(201)
            .build();

    public static ResponseSpecification updateUserResponseSpec =
            new ResponseSpecBuilder()
                    .log(STATUS)
                    .log(BODY)
                    .expectStatusCode(200)
                    .build();

    public static ResponseSpecification deleteUserResponseSpec =
            new ResponseSpecBuilder()
                    .log(STATUS)
                    .log(BODY)
                    .expectStatusCode(204)
                    .build();

    public static ResponseSpecification getUserResponseSpec =
            new ResponseSpecBuilder()
                    .log(STATUS)
                    .log(BODY)
                    .expectStatusCode(200)
                    .build();

    public static ResponseSpecification registerUserResponseSpec =
            new ResponseSpecBuilder()
                    .log(STATUS)
                    .log(BODY)
                    .expectStatusCode(200)
                    .expectBody("token", notNullValue())
                    .build();
}
