package ru.lupapupa.service.post;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import ru.lupapupa.baseclass.BaseClass;
import ru.lupapupa.model.License;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CreateLicense extends BaseClass {

    @Test
    public void createLicense() {
        BaseClass baseClass = new BaseClass();

        String licenseId = UUID.randomUUID().toString();

        String createLicence = RestAssured.given().spec(baseClass.getRequestSpec())
                .body(new License()
                        .id(1)
                        .licenseId(licenseId)
                        .description("Software Product")
                        .organizationId("d898a142-de44-466c-8c88-9ceb2c2429d3")
                        .productName("Ostock")
                        .licenseType("complete"))
                .when().post()
                .then().spec(baseClass.getResponseSpec()).statusCode(200)
                .extract().body().asString();

        assertAll(
                () -> assertThat("Проверка licenseId",createLicence , containsString("licenseId=" + licenseId)),
                () -> assertThat("Проверка organizationId",createLicence , containsString("organizationId=d898a142-de44-466c-8c88-9ceb2c2429d3")));
    }
}
