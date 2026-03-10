package config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;


public class Config {

    public static String baseUri = "https://qa-desk.stand.praktikum-services.ru/";

    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .build();
    }

}
