package ru.lupapupa.baseclass;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.springframework.stereotype.Component;

@Component("baseClassBean")
public class BaseClass {

    public final String BASE_PATH = RestAssured.basePath = "/d898a142-de44-466c-8c88-9ceb2c2429d3/license";

    public RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("http://192.168.2.100:8080/v1/organization")
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
}
