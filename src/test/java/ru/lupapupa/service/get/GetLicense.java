package ru.lupapupa.service.get;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import ru.lupapupa.baseclass.BaseClass;
import ru.lupapupa.model.License;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;

public class GetLicense extends BaseClass {

    @Test
    public void getLicense() {
        BaseClass baseClass = new BaseClass();

        var getLicence = RestAssured.given().spec(baseClass.getRequestSpec())
                .when()
                .get("/f2a9c9d4-d2c0-44fa-97fe-724d77173c62")
                .then().spec(baseClass.getResponseSpec())
                .assertThat().statusCode(200)
                .extract().body()
                .as(License.class);

        assertAll(
                () -> assertThat("Проверка licenseId",getLicence.getLicenseId() , equalTo("f2a9c9d4-d2c0-44fa-97fe-724d77173c62")),
                () -> assertThat("Проверка productName",getLicence.getProductName() , equalTo("Ostock")),
                () -> assertThat("Проверка description",getLicence.getDescription() , equalTo("Software product")),
                () -> assertThat("Проверка licenseType",getLicence.getLicenseType() , equalTo("full")),
                () -> assertThat("Проверка organizationId",getLicence.getOrganizationId() , equalTo("d898a142-de44-466c-8c88-9ceb2c2429d3")));
    }
}
