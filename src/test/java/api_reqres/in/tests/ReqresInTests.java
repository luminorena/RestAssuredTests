package api_reqres.in.tests;

import api_reqres.in.models.CreateUpdateUserBodyModel;
import api_reqres.in.models.CreateUpdateUserResponseModel;
import api_reqres.in.models.RegisterUserBodyModel;
import api_reqres.in.models.RegisterUserResponseModel;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static api_reqres.in.specs.RequestSpec.*;
import static api_reqres.in.specs.ResponseSpec.*;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;



public class ReqresInTests {
    Faker faker = new Faker();
    String name = faker.name().name();
    String job = faker.job().position();

    @Test
    void createUserTest() {
        CreateUpdateUserBodyModel body = new CreateUpdateUserBodyModel();
        body.setName(name);
        body.setJob(job);
        CreateUpdateUserResponseModel response =
        given()
                .spec(createUserRequestSpec)
                .body(body)
                .when()
                .post()
                .then()
                .spec(createUserResponseSpec)
                .extract().as(CreateUpdateUserResponseModel.class);

        assertThat(response.getName()).isEqualTo(name);
        assertThat(response.getJob()).isEqualTo(job);
    }

    @Test
    void updateUserTest() {
        CreateUpdateUserBodyModel body = new CreateUpdateUserBodyModel();
        body.setName(name);
        body.setJob(job);
        CreateUpdateUserResponseModel response =
        given()
                .spec(updateUserRequestSpec)
                .body(body)
                .when()
                .put()
                .then()
                .spec(updateUserResponseSpec)
                .extract().as(CreateUpdateUserResponseModel.class);

        assertThat(response.getName()).isEqualTo(name);
        assertThat(response.getJob()).isEqualTo(job);
    }

    @Test
    void deleteUserTest() {
        given()
                .spec(deleteUserRequestSpec)
                .when()
                .delete()
                .then()
                .spec(deleteUserResponseSpec)
                .assertThat().body(containsString(""));

    }

    @Test
    void getUserTest() {
        given()
                .spec(getUserRequestSpec)
                .when()
                .get()
                .then()
                .spec(getUserResponseSpec)
                .assertThat().body(containsString("email"))
                .assertThat().body(containsString("first_name"))
                .assertThat().body(containsString("last_name"))
                .assertThat().body(containsString("avatar"));

    }

    @Test
    void registerSuccessfulTest() {
        RegisterUserBodyModel body = new RegisterUserBodyModel();
        body.setEmail("eve.holt@reqres.in");
        body.setPassword("pistol");
        RegisterUserResponseModel response =
        given()
                .spec(registerUserRequestSpec)
                .body(body)
                .when()
                .post()
                .then()
                .spec(registerUserResponseSpec)
                .extract().as(RegisterUserResponseModel.class);

        assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }
}
