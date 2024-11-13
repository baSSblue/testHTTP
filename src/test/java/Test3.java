import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.specification.RequestSpecification;

import org.junit.jupiter.api.Test;
import java.io.File;

import static io.restassured.RestAssured.given;

public class Test3 {
    private RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("https://petstore.swagger.io")
            .setBasePath("/v2")
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();


    @Test
    void findStatus() {

        given()
                .spec(requestSpec)

                .when()
                .get("/pet/findByStatus")

                .then()
                .statusCode(200);
    }
}