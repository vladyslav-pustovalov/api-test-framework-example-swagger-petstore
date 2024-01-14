package io.swagger.petstore.api.pet.util;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseSpecification {

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .setBaseUri("https://petstore3.swagger.io")
                .setBasePath("/api/v3/pet")
                .build();
    }

    public static ResponseSpecification responseSpecification() {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }

    public static void installSpecifications() {
        RestAssured.requestSpecification = BaseSpecification.requestSpecification();
        RestAssured.responseSpecification = BaseSpecification.responseSpecification();
    }
}
