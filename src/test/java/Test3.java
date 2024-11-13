import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.specification.RequestSpecification;

import org.junit.jupiter.api.Test;



import static io.restassured.RestAssured.given;

public class Test3 {
    private RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("https://e.lanbook.com")
            .setBasePath("/api/v2")
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    private RequestSpecification requestSpec2 = new RequestSpecBuilder()
            .setBaseUri("https://security.lanbook.com")
            .setBasePath("/api/1.0")
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();


    @Test
    void findInfoBook() {

        given()
                .spec(requestSpec)

                .when()
                .get("/catalog/book/437237")

                .then()
                .statusCode(200);
    }

    @Test
    void securityTest() throws Exception {
        String filePath = "E:/space/IdeaProjects/testEBShttp/src/test/resources/body.json";
        String requestBody = new String(Files.readAllBytes(Paths.get(filePath)));

        given()
                .spec(requestSpec2)
                .body(requestBody)

                .when()
                .post("/signup/")

                .then()
                .statusCode(200);
    }
}