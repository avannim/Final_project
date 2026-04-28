package steps;

import com.codeborne.selenide.Configuration;
import context.TestContext;
import dto.response.SearchAdvertResponse;
import enums.APIEndpoints;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.response.Response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.screenshot;
import static io.restassured.RestAssured.given;
import static io.restassured.config.RestAssuredConfig.config;

public class Hooks {
    private TestContext context;

    public Hooks(TestContext context){
        this.context = context;
    }

    @BeforeAll
    public static void setUpAll() {
        Configuration.baseUrl = System.getProperty("base.url", Configuration.baseUrl);
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.timeout = 12000;
        Configuration.pageLoadTimeout = 30000;
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        Configuration.reportsFolder = "target/selenide-report";
        Configuration.screenshots = true;
        Configuration.savePageSource = true;
        Configuration.pageLoadStrategy = "normal";
        Configuration.screenshots = true;
        Configuration.reportsFolder = "target/screenshots";

        RestAssured.config = config()
                .encoderConfig(EncoderConfig.encoderConfig()
                        .defaultContentCharset("UTF-8")
                        .appendDefaultContentCharsetToContentTypeIfUndefined(true)
                );
    }

    @After("@advert")
    public void teardownAfterAvdertTest() {
        Response searchAdvert = given()
                .spec(context.requestSpec())
                .queryParam("name", context.getAdvert().getName() )
                .get(APIEndpoints.SEARCH_ADVERT.getPath());
        searchAdvert.then().statusCode(200);
        SearchAdvertResponse advert = context.gson.fromJson(searchAdvert.body().asString(), SearchAdvertResponse.class);
        Response response = given()
                .spec(context.requestSpec())
                .header("Authorization", String.format("Bearer %s",  context.getAccessToken().getAccess_token()))
                .delete(APIEndpoints.DELETE_ADVERT.getPath()+advert.getOffers().get(0).getId());
        response.then().statusCode(200);
    }
    @After
    public void teardownAll(Scenario scenario) {
        if (scenario.isFailed()) {
            String time = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));

            screenshot("FAILED_" + scenario.getName()+ "_" + time);
        }
        System.out.println("🔥 Closing all browsers");
        closeWebDriver();
    }
}
