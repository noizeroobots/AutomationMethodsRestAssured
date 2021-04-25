package ru.tinkoff.qa.simple.petshop;

import io.restassured.RestAssured;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class DeleteMethod_404 {

    @Test
    @Order(1)
    public void firstDeleteInMethodDelete404() {
        RestAssured.when()
                .delete("https://petstore.swagger.io/v2/pet/20217")
                .then()
                .statusCode(404)
                .assertThat();
    }

    @Test
    @Order(2)
    public void secondDeleteInMethodDelete404() {
        RestAssured.when()
                .delete("https://petstore.swagger.io/v2/pet/20217")
                .then()
                .statusCode(404)
                .assertThat();
    }

}
