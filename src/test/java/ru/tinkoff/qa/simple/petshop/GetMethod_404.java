package ru.tinkoff.qa.simple.petshop;

import io.restassured.RestAssured;
import org.junit.jupiter.api.*;
import static org.hamcrest.CoreMatchers.equalTo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class GetMethod_404 {

    @Test
    @Order(1)
    public void deleteInMethodGet404() {
            RestAssured.when()
                    .delete("https://petstore.swagger.io/v2/pet/20212")
                    .then()
                    .statusCode(404)
                    .assertThat();
    }

    @Test
    @Order(2)
    public void getInMethodGet404() {
        RestAssured.when()
                .get("https://petstore.swagger.io/v2/pet/20212")
                .then()
                .statusCode(404)
                .assertThat()
                .body("name",equalTo(null))
                .body("status",equalTo(null));
    }

}
