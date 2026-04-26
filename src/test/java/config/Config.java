package config;

import context.TestContext;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;


public class Config {

    public static String baseUri = "https://qa-desk.education-services.ru/";

    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .build();
    }

}
