package steps;

import context.TestContext;
import dto.response.CreateUserResponse;
import enums.APIEndpoints;
import io.cucumber.java.en.When;
import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.apache.http.Consts.UTF_8;

public class RestSteps {

    private TestContext context;

    public RestSteps(TestContext context){
        this.context = context;
    }

    @When("создаю пользователя рестом")
    public void createUser(){
        context.setUser();
        Response response = given()
                .spec(context.requestSpec())
                .header("Content-type", "application/json")
                .and()
                .body(context.gson.toJson(context.getUser()))
                .when()
                .post(APIEndpoints.CREATE_USER.getPath());
        response.then().statusCode(201);
        CreateUserResponse userResponse = context.gson.fromJson(response.body().asString(), CreateUserResponse.class);
        context.setAccessToken(userResponse.getAccess_token().getAccess_token());
    }

    @When("создаю объявление рестом")
    public void createAdvert(){
        context.setAdvert();
        Response response = given()
                .spec(context.requestSpec())
                .header("Authorization", String.format("Bearer %s",  context.getAccessToken().getAccess_token()))
                .multiPart(new MultiPartSpecBuilder(context.getAdvert().getName())
                        .controlName("name")
                        .fileName("")
                        .mimeType("text/plain")
                        .charset(UTF_8.name())
                        .build())
                .multiPart(new MultiPartSpecBuilder(context.getAdvert().getCategory())
                        .controlName("category")
                        .fileName("")
                        .mimeType("text/plain")
                        .charset(UTF_8.name())
                        .build())
                .multiPart(new MultiPartSpecBuilder(context.getAdvert().getCondition())
                        .controlName("condition")
                        .fileName("")
                        .mimeType("text/plain")
                        .charset(UTF_8.name())
                        .build())
                .multiPart(new MultiPartSpecBuilder(context.getAdvert().getCity())
                        .controlName("city")
                        .fileName("")
                        .mimeType("text/plain")
                        .charset(UTF_8.name())
                        .build())
                .multiPart(new MultiPartSpecBuilder(context.getAdvert().getDescription())
                        .controlName("description")
                        .fileName("")
                        .mimeType("text/plain")
                        .charset(UTF_8.name())
                        .build())
                .multiPart(new MultiPartSpecBuilder(String.valueOf(context.getAdvert().getPrice()))
                        .controlName("price")
                        .fileName("")
                        .mimeType("text/plain")
                        .charset(UTF_8.name())
                        .build())
                .when()
                .post(APIEndpoints.CREATE_ADVERT.getPath());
        System.out.println(response.body().asString());
        response.then().statusCode(201);
    }
}
